package org.dragon.practice.study.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2019/9/17
 **/
@Slf4j
public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFutureDemo.thenCompose();

    }

    public static void whenComplete() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            log.info("future");
            return 1;
        });

        CompletableFuture<Integer> futureLong = future.whenComplete((integer, throwable) -> {
            integer++;
            log.info("futureLong,{}", integer);
        });

        try {
            log.info("{}", futureLong.get());
        } catch (Exception e) {

        }
    }

    public static void thenApply() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            log.info("future");
            return 1 / 0;
        });

        CompletableFuture<Long> futureLong = future.thenApply(integer -> {
            integer++;
            return integer.longValue();
        });

        try {
            log.info("{}", futureLong.get());
        } catch (Exception e) {
            log.error("执行异常", e);
        }

    }

    public static void handle() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            log.info("future");
            return 1 / 0;
        });

        CompletableFuture<Long> futureLong = future.handle((integer, throwable) -> {
            if (throwable != null) {
                log.error("前置异常", throwable);
                return Long.MIN_VALUE;
            }
            integer++;
            return integer.longValue();
        });

        try {
            log.info("{}", futureLong.get());
        } catch (Exception e) {
            log.error("执行异常", e);
        }
    }

    public static void thenAccept() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            log.info("future");
            return 1 / 0;
        });

        CompletableFuture futureLong = future.thenAccept(integer -> {
            integer++;
            log.info("{}", integer);
        });

        try {
            log.info("{}", futureLong.get());
        } catch (Exception e) {
            log.error("执行异常", e);
        }
    }

    public static void thenRun() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            log.info("future");
            return 1;
        });

        CompletableFuture futureLong = future.thenRun(() -> log.info("执行完成"));

        try {
            log.info("{}", futureLong.get());
        } catch (Exception e) {
            log.error("执行异常", e);
        }
    }

    public static void thenCompose() {
        CompletableFuture<Long> futureLong = getLongCompletableFuture();
        CompletableFuture<Double> futureCompose = futureLong.thenCompose(aLong -> CompletableFuture.supplyAsync(() -> aLong / 2.0));

        try {
            log.info("{}", futureCompose.get());
        } catch (Exception e) {
            log.error("执行异常", e);
        }

    }

    /**
     * 合并任务,有返回值
     */
    public static void thenCombine() {
        CompletableFuture<Long> futureAdd = getLongCompletableFuture();

        CompletableFuture<Integer> futureDivide = CompletableFuture.supplyAsync(() -> {
            log.info("futureDivide");
            return 10 / 2;
        });

        CompletableFuture<Double> futureCombine = futureAdd.thenCombineAsync(futureDivide, (add, divide) -> {
            log.info("futureCombine");
            return add * divide * 1.0;
        });

        try {
            log.info("{}", futureCombine.get());
        } catch (Exception e) {
            log.error("执行异常", e);
        }
    }

    /**
     * 等待两个任务完成后执行，无返回值
     * runAfterBoth 两个都完成后执行，没有入参，没有返回值
     */
    public static void thenAcceptBoth() {
        CompletableFuture<Long> futureAdd = getLongCompletableFuture();

        CompletableFuture<Integer> futureDivide = CompletableFuture.supplyAsync(() -> {
            log.info("futureDivide");
            return 10 / 2;
        });

        CompletableFuture futureCombine = futureAdd.thenAcceptBoth(futureDivide, (add, divide) -> {
            log.info("futureCombine");
            log.info("acceptRes:{}", add * divide * 1.0);
        });

        try {
            log.info("{}", futureCombine.get());
        } catch (Exception e) {
            log.error("执行异常", e);
        }
    }

    /**
     * 其中一个完成后执行，使用完成的结果
     * <p>
     * acceptEither 无返回值的版本
     * runAfterEither  不用参数且无返回值的版本
     */
    public static void applyToEither() {
        CompletableFuture<Long> futureAdd = getLongCompletableFuture();

        CompletableFuture<Long> futureDivide = CompletableFuture.supplyAsync(() -> {
            sleep(2);
            log.info("futureDivide");
            return 10 / 2L;
        });

        CompletableFuture<Double> futureEither = futureAdd.applyToEither(futureDivide, (add) -> {
            log.info("futureCombine");
            return add * 1.0;
        });

        try {
            log.info("{}", futureEither.get());
        } catch (Exception e) {
            log.error("执行异常", e);
        }

    }

    private static CompletableFuture<Long> getLongCompletableFuture() {
        return CompletableFuture.supplyAsync(() -> {
            sleep(1);
            log.info("futureAdd");
            return 1 + 1L;
        });
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {

        }
    }

}
