package Controler;

import elevator.rmi.Elevator;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Michael on 14/03/2016.
 */
public class Worker extends Thread {

    private Elevator elevator;

    private int actualFloor;
    
    private int buttonNumber;
    private int value = 0;

    private ArrayList<Integer> floors = new ArrayList<Integer>; 
    private int hreq;
    private int lreq; 
    private int dir; 

    public Worker(){

    }

    @Override
    public void run()
    {

    }


    private void answer() 
    {
        //SOMEWHERE, add requests into sorted array list
    }

    public Worker setActualFloor(int aF) {
        actualFloor = aF;
        return this;
    }

    public Worker setButtonNumber(int buttonNumber) {
        this.buttonNumber = buttonNumber;
        return this;
    }

    int getDir ()
    {
        return dir;
    }

    int getFloor()
    {
        return actualFloor;
    }


}
