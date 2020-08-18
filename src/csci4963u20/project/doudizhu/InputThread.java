package csci4963u20.project.doudizhu;

import java.io.*;

public class InputThread extends Thread {
	public ObjectInputStream in;
    public Server server;

    /**
     * Default constructor from server and input stream
     * @param s server
     * @param inputStream input stream
     */
    public InputThread(Server s, ObjectInputStream inputStream) {
        in = inputStream;
        server = s;
    }

    /**
     * Run the thread
     */
    public void run() {
        try{
            while(true) {
                Message inputObj = (Message)(in.readObject());
                System.out.println("[Server] Receive: FROM: " + inputObj.from + " TO: " + inputObj.to + " TYPE: " + inputObj.msgType);
                server.processMessage(inputObj);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
