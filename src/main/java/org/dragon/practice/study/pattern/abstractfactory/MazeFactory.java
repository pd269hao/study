package org.dragon.practice.study.pattern.abstractfactory;

import org.dragon.practice.study.pattern.abstractfactory.model.Door;
import org.dragon.practice.study.pattern.abstractfactory.model.Maze;
import org.dragon.practice.study.pattern.abstractfactory.model.Room;
import org.dragon.practice.study.pattern.abstractfactory.model.Wall;

/**
 * Created with IntelliJ IDEA.
 * <p>
 * 抽象工厂方法
 * 迷宫
 *
 * @Author: Liuwl
 * Date: 2019/6/10
 **/
public abstract class MazeFactory {

    public Maze makeMaze() {
        return new Maze();
    }

    public Wall makeWall() {
        return new Wall();
    }

    public Room makeRoom(int n) {
        return new Room(n);
    }

    public Door makeDoor(Room room1, Room room2) {
        return new Door(room1, room2);
    }

}
