package Controler;

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

    private Connector connector;
    private ArrayList<Worker> workers;


    public Controler(String host, int port) {
        connector = new Connector(host, port, workers);

    }





}

