/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcp_deadlock_3;
/**
 *
 * @author Pfleger C.
 */
public class PCP_Deadlock_3 {

    public static final int MAX = 100;
    public static int count = 10;
    public static Consumer cons = new Consumer();
    public static Producer prod = new Producer();
    
    public static void main(String[] args) {
        prod.start();
        cons.start();
    }
    
    public static void insert_item(){
        count++;
        System.out.println("(+)" + count);
    }

    public static void remove(){
        count--;
        System.out.println("(-)" + count);
    }
    
    public static int getCount(){
        return count;
    }
}
