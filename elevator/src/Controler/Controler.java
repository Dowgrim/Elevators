package Controler;

import elevator.rmi.Elevator;
import elevator.rmi.Elevators;
import elevator.rmi.MakeAll;

import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Michael on 23/02/2016.
 */
public class Controler {

    public static int outPort = 4711;
    public static int inPort = 4712;

    private Connector connector;
    private ArrayList<Worker> workers = new ArrayList<Worker>();


    public Controler(String host, int port) {
        try {
            MakeAll.init(host, inPort);
            for(int i = 0; i < MakeAll.getNumberOfElevators(); i++) {
                workers.add(new Worker(MakeAll.getElevator(i+1)));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        connector = new Connector(host, port, workers);

    }





}

