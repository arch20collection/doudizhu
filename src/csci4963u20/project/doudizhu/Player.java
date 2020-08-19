package csci4963u20.project.doudizhu;

import java.util.*;

public class Player {
    public String name;
    public Deck deck;
    public int id;

    /**
     * Default constructor
     * @param n name of the player
     * @param d deck of the player
     */
    public Player(String n, Deck d){
        name = n;
        deck = d;
    }
    
    /**
     * Constructor that only have name
     * @param n name of the player
     */
    public Player(String n){
        name = n;
    }
    
    /**
     * Constructor that only have id
     * @param id id of the player
     */
    public Player(int id){
        this.id = id;
    }

}
