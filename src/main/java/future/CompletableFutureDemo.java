package future;

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


}
