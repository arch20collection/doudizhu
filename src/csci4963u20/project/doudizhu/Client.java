package csci4963u20.project.doudizhu;

import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;
import java.util.*;

public class Client extends Thread{
	// input stream
    private ObjectInputStream in = null;
    // output stream
    private ObjectOutputStream out = null;
    public Socket server;
    private Player player;
    private Deck currentDeck;
    
    /**
     * Default constructor from player with name
     * @param f MainFrame of the client
     * @param id id of the client
     */
    public Client(Player p) {
    	player = p;
    	currentDeck = new Deck();
    }
    
    /**
     * Send message to the server
     * @param Type type of the message
     * @param Content content of the message.
     */
    public void send(String Type, Object Content) {
        try{
            Message m = new Message(this.player.id,-1,Type,Content);

            out.writeObject(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Run the client
     */
    public void run(){
        try {
        	server = new Socket(Application.serverHost, Application.serverPort);
        	out = new ObjectOutputStream(server.getOutputStream());
            in  = new ObjectInputStream(server.getInputStream());
            
            while(true) {
            	Message m = ((Message)in.readObject());
            	if(m.msgType.equals("assignID")) {
            		this.player.id = ((int[]) m.content)[0];
            		send("playerName", this.player.name);
            	}
            	else if(m.msgType.equals("deals")) {
            		this.player.deck = ((Deck)m.content);
            	}
            	else if(m.msgType.equals("yourTerm")) {
            		//Ready to play
            	}
            	else if(m.msgType.equals("gameStart")) {
            		send("getDeck", null);
            	}
            	else if(m.msgType.equals("receiveDeck")) {
            		Deck received = (Deck)m.content;
            		Iterator<Card> itr = received.getIterator();
            		while(itr.hasNext()) {
            			currentDeck.add(itr.next());
            		}
            	}
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
