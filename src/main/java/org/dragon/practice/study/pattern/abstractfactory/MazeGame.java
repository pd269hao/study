package org.dragon.practice.study.pattern.abstractfactory;

import org.dragon.practice.study.pattern.abstractfactory.model.Maze;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2019/6/10
 **/
public class MazeGame {
    Maze createMaze(MazeFactory factory){
       Maze maze=factory.makeMaze();
       return maze;
    }
}
