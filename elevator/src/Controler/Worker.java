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
        //always be handeling moement from floors
        //if floors is empty, wait for floors to not be empty
        //have to listen for new floors being added dynamically 
    }

    public Worker setActualFloor(int aF) {
        actualFloor = aF;
        return this;
    }

    public Worker setButtonNumber(int buttonNumber) {
        this.buttonNumber = buttonNumber;
        return this;
    }

    void addFloor(int x)
    {
        if(floors.size() == 0)
        {
            if(x - actualFloor > 0)
                dir = 1;
            if(x - actualFloor < 0)
                dir = -1;
            else
            {
                return; //do nothing 
            }
            floors.add(x);
        }   
        else
        {
            for (int i = 0; i < floors.size(); i++)
            {
                if(dir == 1) //if it is going up
                {
                    if(floors.get(i) < x) continue; //floor is higher than this 
                    if(floors.get(i) == x) return; //already have the floor in the list
                    add(i, x) 
                }
                else if (dir == -1) //if it is going down
                {
                    if(floors.get(i) > x) continue; //floor is lower than this 
                    if(floors.get(i) == x) return; //already have the floor in the list
                    floors.add(i, x) 
                }
            }             
        } 

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
