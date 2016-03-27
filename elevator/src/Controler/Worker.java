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

    public Worker(){

    }

    @Override
    public void run(){

    }





    private void answer() {
    }

    public Worker setActualFloor(int aF) {
        actualFloor = aF;
        return this;
    }

    public Worker setButtonNumber(int buttonNumber) {
        this.buttonNumber = buttonNumber;
        return this;
    }
}
