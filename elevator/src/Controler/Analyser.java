package Controler;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by Michael on 27/03/2016.
 */
public class Analyser extends Thread {

    private ArrayList<Worker> workers;

    private String msg;

    public Analyser(String msg, ArrayList<Worker> w){
        this.msg = msg;
        workers = w;
    }

    @Override
    public void run(){
        analyse();
    }

    private void analyse(){

        StringTokenizer tokenizer;
        String[] tokens = new String[3];

        int elevator = 0, value = 0;

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
                elevator = Integer.parseInt(tokens[1])-1;
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
            workers.get(elevator).setActualFloor(value).start();
            return;
        }
        if (tokens[0].equalsIgnoreCase("p") && tokens[1] != null && tokens[2] != null) {
            System.out.println("Elevator " + tokens[1] + "want to go to the floor " + tokens[2]);
            workers.get(elevator).setButtonNumber(value).start();
            return;
        }
        if (tokens[0].equalsIgnoreCase("b") && tokens[1] != null && tokens[2] != null) {
            System.out.println("An user want to go " + (tokens[2]=="1"?"up":"down") + " from the floor " + tokens[1]);
            determine(elevator, value);
            return;
        }
    }

    /**
     * determine the elevator to use
     * @param floor
     * @param destination
     */
    public void determine(int floor, int destination){

    }
}
