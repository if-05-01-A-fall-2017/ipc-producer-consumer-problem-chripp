/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcp_deadlock_1;

import static pcp_deadlock_1.PCP_Deadlock_1.*;
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
            System.out.println("Prod:Awake");
            if (count >= MAX) {
                System.out.println("Prod:Asleep");
                try {
                    synchronized(this){ wait(); }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            insert_item();
            if (count >= 1) {
               synchronized(cons){ cons.notify();}
            }
        }
    }
}
