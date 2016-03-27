package Controler;

import elevator.ElevatorGUI;
import elevator.rmi.Elevator;
import elevator.rmi.GetAll;
import elevator.rmi.MakeAll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Michael on 14/03/2016.
 */
public class Connector extends Thread{

    private ArrayList<Worker> workers;

    private int nextWorker = 0;

    private Socket socket = null;

    private BufferedReader input;

    public Connector(String host, int port, ArrayList<Worker> w){
        try {
            socket = new Socket(InetAddress.getByName(host), Controler.outPort);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run(){
        readInput();
    }


    /**
     * "v " + velocity                                  ///  Velocity
     * "f " + (number + 1) + " " + position             ///  floor of the elevator (number + 1) is position
     * "p "+ (i + 1) + " "+ n                           ///  Button inside the elevator (i + 1) for the floor n
     * "p "+ (i + 1) + " " + Elevators.SPECIAL_FOR_STOP ///  Stop the aeroport (i+1)
     * "b "+ i + " -1"                                  ///  down for floor i
     * "b "+ i + " 1"                                   ///  up for floor i
     */



    /**
     * Reads elevator commands from the standard or the socket (if open) input stream
     * and executes over and over again until the input stream is closed or
     * the "quit" is read from the stream
     */
    public void readInput() {
        String msg = null;
        try {
            while ((msg = input.readLine()) != null) {
                if (msg.equals("")) continue;
                new Analyser(msg, workers).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
