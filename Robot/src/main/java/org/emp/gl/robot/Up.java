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
public class Up extends RobotState{

    public Up(Robot rebot) {
        super(rebot);
    }

   

    @Override
    public void goUP() {
    }

    @Override
    public void goDown() {
    }

    @Override
    public void goLeft() {
        robot.CurrentOrientation=Robot.LEFT_Orientation;
        robot.ChangeState(new Left(robot));
    }

    @Override
    public void goRight() {
        robot.CurrentOrientation=Robot.RIGHT_Orientation;
        robot.ChangeState(new Right(robot));
    }

    @Override
    public void Move() {
        robot.CC_Y--;
    }
    
}
