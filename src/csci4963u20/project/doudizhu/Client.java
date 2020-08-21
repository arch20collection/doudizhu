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
    MainBody frame;
    public Socket server;
    public Player player;
    public Deck currentDeck;
    public Deck latestDeck;
    public int[] cardsRemain;
    public String[] playerNames;
    
    /**
     * Default constructor from player with name
	 * @param p Player to be added
     */
    public Client(Player p, MainBody mainFrame) {
    	player = p;
    	currentDeck = new Deck();
    	frame = mainFrame;
    }
    
    /**
     * Send message to the server
     * @param Type type of the message
     * @param Content content of the message.
     */
    public void send(String Type, Object Content) {
        try{
        	if(Type.equals("sendDeck")) {
        		Deck sent = (Deck)Content;
        		this.latestDeck = sent;
        		Iterator<Card> itr = sent.getIterator();
        		while(itr.hasNext()) {
        			currentDeck.add(itr.next());
        		}
        		frame.ctb.send_button.setEnabled(false);
        		frame.ctb.skip_button.setEnabled(false);
        	}else if (Type.equals("skip")){
				frame.ctb.send_button.setEnabled(false);
				frame.ctb.skip_button.setEnabled(false);
			}
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
        	System.out.println("out shall not be null");
            in  = new ObjectInputStream(server.getInputStream());
            
            while(true) {
            	Message m = ((Message)in.readObject());
            	if(m.msgType.equals("assignID")) {
            		System.out.println("assigning Id");
            		this.player.id = ((int[]) m.content)[0];
            		send("playerName", this.player.name);
            	}
            	else if(m.msgType.equals("deals")) {
            		Deck received = (Deck)m.content;
            		this.player.deck = received;
            		if(received.size() == 20) {
            			frame.ctb.send_button.setEnabled(true);
                		frame.ctb.skip_button.setEnabled(true);
            		}
            	}
            	else if(m.msgType.equals("yourTerm")) {
            		frame.ctb.send_button.setEnabled(true);
            		frame.ctb.skip_button.setEnabled(true);
            	}
            	else if(m.msgType.equals("gameStart")) {
            		send("getDeck", null);
            	}
            	else if(m.msgType.equals("receiveDeck")) {
            		Deck received = (Deck)m.content;
            		System.out.println("Deck received!");
            		received.printDeck();
	            	if(received.size() != 0) {
	            		latestDeck = received;
	            		Iterator<Card> itr = received.getIterator();
	            		while(itr.hasNext()) {
	            			currentDeck.add(itr.next());
	            		}
	            		frame.current_deck_panel.updateDeck(received);
            		}
	            	send("getCardsRemain", null);
            	}
            	else if(m.msgType.equals("names")) {
            		playerNames = (String[]) m.content;
            	}
            	else if(m.msgType.equals("cardsRemain")) {
            		cardsRemain = (int[])m.content;
            	}
            	else if(m.msgType.equals("gameOver")) {
            		int winner = ((int[])m.content)[0];
            		//Tell client who the winner is...
            	}
            	else if(m.msgType.equals("resetGame")) {
            		currentDeck = new Deck();
            		latestDeck = new Deck();
            	}
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
