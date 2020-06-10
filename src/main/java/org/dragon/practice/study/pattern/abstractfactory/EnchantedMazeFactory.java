package org.dragon.practice.study.pattern.abstractfactory;

import org.dragon.practice.study.pattern.abstractfactory.model.Door;
import org.dragon.practice.study.pattern.abstractfactory.model.DoorNeedSpell;
import org.dragon.practice.study.pattern.abstractfactory.model.EnchantedRoom;
import org.dragon.practice.study.pattern.abstractfactory.model.Room;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2019/6/10
 **/
public class EnchantedMazeFactory extends MazeFactory {

    @Override
    public Room makeRoom(int n) {
        return new EnchantedRoom(n);
    }

    @Override
    public Door makeDoor(Room room1, Room room2) {
        return new DoorNeedSpell(room1, room2);
    }

}
