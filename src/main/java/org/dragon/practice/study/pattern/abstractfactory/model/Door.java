package org.dragon.practice.study.pattern.abstractfactory.model;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2019/6/10
 **/
public class Door {
    private Room room;
    private Room otherRoom;

    public Door(Room room1, Room room2) {
        this.room = room1;
        this.otherRoom = room2;
    }
}
