/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcp_deadlock_3;

import static pcp_deadlock_3.PCP_Deadlock_3.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pfleger C.
 */
public class Producer extends Thread {
    
    @Override
    public void run(){
        while (true) {
            synchronized(PCP_Deadlock_3.class) {
                if (getCount() >= MAX) {
                    try {
                        synchronized(this){ wait(); }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            synchronized(PCP_Deadlock_3.class) {
                PCP_Deadlock_3.insert_item();
            };
            synchronized(PCP_Deadlock_3.class) {
                if (getCount() >= 1) {
                    synchronized(cons){ cons.notify();}
                }
            };
        }
    }
}
