/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.launcher;

import java.awt.EventQueue;
import javax.swing.SwingUtilities;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.gui1.Maze;
import org.emp.gl.robot.Robot;
import org.emp.gl.timerservice.TimerImpl;
import org.emp.gl.timerservice.TimerService;
import org.emp.gl.MazeService.ServiceMaze;
import org.emp.gl.robot.RebotService;
import org.emp.gl.timerservice.Observer;

/**
 *
 * @author raouf
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    static {

    }

    public static void main(String[] args) {
        Lookup.getLookup().register(TimerService.class, new TimerImpl());
        Lookup.getLookup().register(RebotService.class, new Robot(1, 5, Robot.UP_Orientation));
        Lookup.getLookup().register(ServiceMaze.class, new Maze());

        RebotService r = Lookup.getLookup().get(RebotService.class);

        Lookup.getLookup().get(TimerService.class).addListener((Observer) r);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                
                Maze view = new Maze();
                view.setVisible(true);
                Lookup.getLookup().get(TimerService.class).addListener((Observer) view);

            }
        });

      

    }

}
