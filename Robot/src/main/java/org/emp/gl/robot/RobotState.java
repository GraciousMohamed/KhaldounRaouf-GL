/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.robot;

/**
 *
 * @author raouf
 */
public abstract class  RobotState {
    Robot robot ;

    public RobotState(Robot robot) {
        this.robot = robot;
    }
    
    public abstract void goUP();
    public abstract void goDown();
    public abstract void goLeft();
    public abstract void goRight();
    public abstract void Move();
    
}
