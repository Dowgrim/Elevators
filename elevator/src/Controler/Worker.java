package Controler;

import elevator.rmi.Elevator;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Michael on 14/03/2016.
 */
public class Worker {

    private Elevator elevator;

    private int actualFloor = 0;

    private ArrayList<Integer> dests = new ArrayList<Integer>();
    private int hreq;
    private int lreq; 
    private int dir; 

    public Worker(Elevator elev){
        elevator = elev;
    }


    public void run()
    {
        try {
            if(dests.get(0) > actualFloor){
                elevator.up();
            }else{
                elevator.down();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void actualise() {
        if(actualFloor == dests.get(0)){
            try {
                elevator.stop();
                dests.remove(actualFloor);
                elevator.open();
                elevator.close();
                if(dests.get(0) != null){
                    if(dests.get(0) > actualFloor){
                        elevator.down();
                    }
                    else{
                        elevator.up();
                    }
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setActualFloor(int aF) {
        actualFloor = aF;
    }

    public int getLastDest(){
        return dests.get(dests.size()-1);
    }

    public void addFloor(int x)  {
        if(dests.size() == 0)
        {
            dests.add(x);
        }
        else
        {
            for (int i = 0; i < dests.size(); i++)
            {
                if(dir == 1) //if it is going up
                {
                    if(dests.get(i) < x) continue; //floor is higher than this
                    if(dests.get(i) == x) return; //already have the floor in the list
                    dests.add(i, x);
                }
                else if (dir == -1) //if it is going down
                {
                    if(dests.get(i) > x) continue; //floor is lower than this
                    if(dests.get(i) == x) return; //already have the floor in the list
                    dests.add(i, x) ;
                }
            }
        }
        run();
    }

    public int getFloor() {
        return actualFloor;
    }

    public int getDistance(int floor, int dir){
        int res = Math.abs(actualFloor - dests.get(0));
        int i;
        for(i = 1; i < dests.size(); i++){
            if((floor > dests.get(i-1) && floor < dests.get(i)) || (floor < dests.get(i-1) && floor > dests.get(i))) {
                if(dir == ((dests.get(i-1) - dests.get(i) > 0)?1:-1)){
                    break;
                }else {
                    continue;
                }
            }else {
                res += Math.abs(dests.get(i - 1) - dests.get(i));
            }
        }
        res += Math.abs(dests.get(i-1) - floor);
        return res;
    }



}
