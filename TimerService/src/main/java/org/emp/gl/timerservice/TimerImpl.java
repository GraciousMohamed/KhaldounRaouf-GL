/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timerservice;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author raouf
 */
public class TimerImpl implements TimerService{
	private static TimerImpl INSTANCE ;
	public TimerImpl () {
		TimerTask t = new TimerTask() {			
			@Override
			public void run() {
				notifier();
			}
		}; 
		
		Timer tt = new Timer() ;
		tt.scheduleAtFixedRate(t, 0, 1000);
	}
	// singltone:  
	static public TimerImpl GET_INSTANCE () {
            if(INSTANCE == null)
                INSTANCE = new TimerImpl();
	return INSTANCE ;
	}
	
	
	
	Set<Observer> observers = new HashSet<>();

        @Override
	public void addListener (Observer n) {
		observers.add(n) ;
	}
	
        @Override
	public void removeListener (Observer n) {
		observers.remove(n) ;
	}
	
	void notifier () {
		for (Observer e: observers) {
			e.OneSecondElapsed();
		}
	}
}
