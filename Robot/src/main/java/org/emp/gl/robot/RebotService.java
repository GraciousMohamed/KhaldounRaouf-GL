/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.robot;

import org.emp.gl.timerservice.TimerService;
import org.emp.gl.timerservice.Observer;

/**
 *
 * @author raouf
 */
public interface RebotService extends Observer {
    
    public void goUP();

    public void goDown();

    public void goLeft();

    public void goRight();

    public final static String UP_Orientation = "UP";
    public final static String DOWN_Orientation = "Down";
    public final static String LEFT_Orientation = "Left";
    public final static String RIGHT_Orientation = "Right";

    public int geCoordonnée_X();

    public int geCoordonnée_Y();

    public String RobotDirection();

}
