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
public class Left extends RobotState {

    public Left(Robot rebot) {
        super(rebot);
    }

    @Override
    public void goUP() {
        robot.CurrentOrientation = Robot.UP_Orientation;
        robot.ChangeState(new Up(robot));
    }

    @Override
    public void goDown() {
        robot.CurrentOrientation = Robot.DOWN_Orientation;
        robot.ChangeState(new Down(robot));
    }

    @Override
    public void goLeft() {
    }

    @Override
    public void goRight() {
    }

    @Override
    public void Move() {
        robot.CC_X--;
    }

}
