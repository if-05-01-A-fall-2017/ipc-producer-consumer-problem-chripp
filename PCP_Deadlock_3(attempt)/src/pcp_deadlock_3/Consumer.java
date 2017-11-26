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
public class Consumer extends Thread {
    
    @Override
    public void run(){
        while (true) {
            synchronized(PCP_Deadlock_3.class) {
                if (getCount() <= 0) {
                    try {
                        synchronized(this){ wait(); }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            };
            synchronized(PCP_Deadlock_3.class) {
                PCP_Deadlock_3.remove();
            };
            synchronized(PCP_Deadlock_3.class) {
                if (getCount() < MAX) {
                    synchronized(prod){ prod.notify();}
                }
            };
        } 
    }
}
