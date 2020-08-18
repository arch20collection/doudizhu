package csci4963u20.project.doudizhu;

import java.io.*;
import java.net.*;

public class Server extends Thread{
	public ServerSocket serverSocket;
	public ObjectInputStream in1 = null;
    public ObjectOutputStream out1 = null;
    public ObjectInputStream in2 = null;
    public ObjectOutputStream out2 = null;
    public ObjectInputStream in3 = null;
    public ObjectOutputStream out3 = null;
    public Socket playerSock1 = null;
    public Socket playerSock2 = null;
    public Socket playerSock3 = null;
    public Player[] group;
    public int readyPlayer = 0;
    public int currentPlayer;
    public int port;
    public int[] cardRemain;
    private Deck fullDeck;
    private Deck[] splitDeck;
    private int lord;
    Player player1;
    Player player2;
    Player player3;
    
    /**
     * Default constructor from port
     * @param port port number
     */
    public Server (int port) {
        this.port = port;
        System.out.println("[Server] Starting...");
        fullDeck = Deck.generateFullDeck();
        fullDeck.shuffle();
        splitDeck = fullDeck.dealFullDeck();
        fullDeck.printDeck();
        lord = 0;
        currentPlayer = lord;
        cardRemain = new int[3];
        group = new Player[3];
        player1 = new Player(0);
        player2 = new Player(1);
        player3 = new Player(2);
        group[0] = player1;
        group[1] = player2;
        group[2] = player3;
    }
    
    /**
     * Reset the game
     */
    void reset() {
        System.out.println("[Server] Reset the game.");
        readyPlayer = 0;
        currentPlayer = lord;
        fullDeck.shuffle();
        splitDeck = fullDeck.deal();
        fullDeck.printDeck();
        cardRemain = new int[3];
        boardcast("resetGame", null);
    }
    
    /**
     * Send message from server
     * @param client client to receive the message
     * @param type message type
     * @param content message content
     */
    void send(int client, String type, Object content) {

        Message m = new Message(-1,client,type,content);

        try{
            if(client == 0) {
                out1.writeObject(m);
            }
            else if(client == 1) {
                out2.writeObject(m);
            }
            else {
            	out3.writeObject(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Send message from server
     * @param client client to receive the message
     * @param type message type
     * @param content message content
     */
    void sendOther(int client, String type, Object content) {

        Message m = new Message(-1,client,type,content);

        try{
            if(client == 0) {
                out2.writeObject(m);
                out3.writeObject(m);
            }
            else if(client == 1) {
            	out1.writeObject(m);
                out3.writeObject(m);
            }
            else {
            	out1.writeObject(m);
                out2.writeObject(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Send message from server
     * @param type message type
     * @param content message content
     */
    void broadcast(String type, Object content) {

        Message m = new Message(-1,-1,type,content);

        try{
            out2.writeObject(m);
            out3.writeObject(m);
        	out1.writeObject(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Process messages
     * @param inputObj Message to be processed
     */
    public void processMessage(Message inputObj) {
    	int player = inputObj.from;
    	
    	if(inputObj.msgType.equals("getDeck")) {
    		if(player == lord) {
    			send(player, "deals", splitDeck[0]);
    			group[player].deck = splitDeck[0];
    			cardRemain[player] = 20;
    			splitDeck[0] = null;
    		}
    		else {
    			if(splitDeck[1] != null) {
    				send(player, "deals", splitDeck[1]);
    				group[player].deck = splitDeck[1];
    				splitDeck[1] = null;
    			}
    			else {
    				send(player, "deals", splitDeck[2]);
    				group[player].deck = splitDeck[2];
    				splitDeck[2] = null;
    			}
    			cardRemain[player] = 17;
    		}
    	}
    	else if(inputObj.msgType.equals("playerName")) {
    		group[player].name = (String)inputObj.content;
    	}
    	else if(inputObj.msgType.equals("getPlayersName")){
    		String[] names = new String[3];
    		for(int i = 0; i < group.length; i++) {
    			names[i] = group[i].name;
    		}
    		send(player, "names", names);
    	}
    	else if (inputObj.msgType.equals("sendDeck")) {
    		sendOther(player, "receiveDeck", inputObj.content);
    		cardRemain[player] -= ((Deck)inputObj.content).size();
    		if(currentPlayer == 2) {
    			currentPlayer = 0;
    		}
    		else {
    			currentPlayer++;
    		}
    		send(currentPlayer, "yourTerm", null);
    	}
    	else if (inputObj.msgType.equals("getCardsRemain")) {
    		int[] data = cardRemain.clone();
    		send(player, "cardsRemain", data);
    	}
    	else if (inputObj.msgType.equals("win")) {
//    		sendOther(player, "gameOver", )
    		reset();
    	}
    	else if (inputObj.msgType.equals("ready")) {
    		readyPlayer++;
    		if(readyPlayer == 3) {
    			broadcast("gameStart", null);
    		}
    	}
    }
    
    public void run() {
    	try {
    		serverSocket = new ServerSocket(this.port);
    		
    		playerSock1 = serverSocket.accept();
    		playerSock2 = serverSocket.accept();
    		playerSock3 = serverSocket.accept();
    		
    		out1 = new ObjectOutputStream(playerSock1.getOutputStream());
            in1 = new ObjectInputStream(playerSock1.getInputStream());
            
            out2 = new ObjectOutputStream(playerSock2.getOutputStream());
            in2 = new ObjectInputStream(playerSock2.getInputStream());
            
            out3 = new ObjectOutputStream(playerSock3.getOutputStream());
            in3 = new ObjectInputStream(playerSock3.getInputStream());
            
            int fId[] = new int[1];
            fId[0] = 0;
            send(0, "assignID", fId);
            
            int sId[] = new int[1];
            sId[0] = 1;
            send(1, "assignID", sId);
            
            int tId[] = new int[1];
            tId[0] = 2;
            send(2, "assignID", tId);
            
            InputThread client1InputThread = new InputThread(this,in1);
            InputThread client2InputThread = new InputThread(this,in2);
            InputThread client3InputThread = new InputThread(this,in3);

            client1InputThread.start();
            client2InputThread.start();
            client3InputThread.start();
            
    	}catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public static void main(String[] arg) {
    	Server s = new Server(8848);
    }
    
    
}
