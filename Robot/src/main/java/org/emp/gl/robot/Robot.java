/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.robot;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.MazeService.ServiceMaze;
import org.emp.gl.timerservice.Observer;

/**
 *
 * @author raouf
 */
public class Robot implements RebotService {



    public int CC_X;
    public int CC_Y;
    String CurrentOrientation;
    private RobotState orientationState = new Up(this);

    public Robot(int x, int y, String startOrientation) {
        CC_X = x;
        CC_Y = y;
        CurrentOrientation = startOrientation;
    }

     @Override
    public int geCoordonnée_X() {
        return  CC_X;
    }

    @Override
    public int geCoordonnée_Y() {
        return  CC_Y;
    }
    
    @Override
    public void OneSecondElapsed() {

        if (!detectCollision()) {
            orientationState.Move();
        } else {
            System.out.println("Rebot Stopped  Orientation: " + CurrentOrientation);
        }
    }

    

    @Override
    public String RobotDirection() {
        return CurrentOrientation;
    }

    public void ChangeState(RobotState newState) {
        this.orientationState = newState;
    }

    @Override
    public void goUP() {
        orientationState.goUP();
    }

    @Override
    public void goDown() {
        orientationState.goDown();
    }

    @Override
    public void goLeft() {
        orientationState.goLeft();
    }

    @Override
    public void goRight() {
        orientationState.goRight();
    }

    boolean detectCollision() {
        ServiceMaze sm = Lookup.getLookup().get(ServiceMaze.class);
        if (sm.isObstacle(CC_X-1, CC_Y) && CurrentOrientation == Robot.LEFT_Orientation) {
            return true;
        }
        if (sm.isObstacle(CC_X+1, CC_Y) && CurrentOrientation == Robot.RIGHT_Orientation) {
            return true;
        }
        if (sm.isObstacle(CC_X, CC_Y-1) && CurrentOrientation == Robot.UP_Orientation) {
            return true;
        }
        if (sm.isObstacle(CC_X, CC_X+1) && CurrentOrientation == Robot.DOWN_Orientation) {
            return true;
        }
        return false;
    }

   

}
