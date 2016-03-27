package Controler;

import elevator.rmi.Elevator;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Michael on 14/03/2016.
 */
public class Worker extends Thread {

    private String msg;

    private String cmd = "";

    private int elevator = 0;

    private int value = 0;

    public Worker(String msg){
        this.msg = msg;
    }

    @Override
    public void run(){
        analyse();
        answer();
    }



    private void analyse(){

    StringTokenizer tokenizer;
    String[] tokens = new String[3];

    tokenizer = new StringTokenizer(msg);
    tokens[0] = tokenizer.nextToken();
    if (tokens[0].equalsIgnoreCase("q") || tokens[0].equalsIgnoreCase("quit")) {
        System.out.println("Bye, bye");
        System.exit(0);
    }
    tokens[1] = tokens[2] = null;
    if (tokenizer.hasMoreTokens()) {
        try {
            tokens[1] = tokenizer.nextToken();
            elevator = Integer.parseInt(tokens[1]);
        } catch (NumberFormatException e) {
            System.err.println("Illegal command: " + msg);
            return;
        }
    }
    if (tokenizer.hasMoreTokens()) {
        try {
            tokens[2] = tokenizer.nextToken();
            value = Integer.parseInt(tokens[2]);
        } catch (NumberFormatException e) {
            System.err.println("Illegal command: " + msg);
            return;
        }
    }
    if (tokens[0].equalsIgnoreCase("v") && tokens[1] != null) {
        System.out.println("Velocity is :" + tokens[1]);
        return;
    }
    if (tokens[0].equalsIgnoreCase("f") && tokens[1] != null && tokens[2] != null) {
        System.out.println("The elevator " + tokens[1] + " is on the flor " + tokens[2]);
        return;
    }
    if (tokens[0].equalsIgnoreCase("p") && tokens[1] != null && tokens[2] != null) {
        System.out.println("Elevator " + tokens[1] + "want to go to the floor " + tokens[2]);
        return;
    }
    if (tokens[0].equalsIgnoreCase("b") && tokens[1] != null && tokens[2] != null) {
        System.out.println("An user want to go " + (tokens[2]=="1"?"up":"down") + " from the floor " + tokens[1]);
        return;
    }
}

    private void answer() {
    }

    public Worker setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
