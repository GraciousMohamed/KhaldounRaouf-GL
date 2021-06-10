/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timerservice;

/**
 *
 * @author raouf
 */
public interface TimerService {
    void addListener (Observer n);
    void removeListener (Observer n);
}
