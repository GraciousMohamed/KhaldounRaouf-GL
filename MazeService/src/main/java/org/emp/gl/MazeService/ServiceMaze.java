/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.MazeService;

import org.emp.gl.timerservice.Observer;



/**
 *
 * @author raouf
 */
public interface ServiceMaze extends Observer   {
    public boolean isObstacle(int i ,int j);
   
}
