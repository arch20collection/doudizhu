package csci4963u20.project.doudizhu;

public class Card implements Comparable<Card>{
    private int value;
    private String name;

    public Card(int val, String n){
        this.value = val;
        this.name = n;
    }

    public int getValue(){
        return value;
    }

    public String getName(){
        return name;
    }
    
    public void printCard() 
    {
    	System.out.println("Card " + this.value + " " + this.name);
    }

    @Override
    public int compareTo(Card c){
        if(this.value != c.getValue()){
            return Integer.compare(this.value, c.getValue());
        }else{
            return this.name.compareTo(c.getName());
        }
    }

    @Override
    public boolean equals(Object o){
        if (o instanceof Card) {
            Card c = (Card) o;
            return ( this.value == c.getValue() && this.name.equals(c.getName()));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode(){
        return Integer.hashCode(value) + name.hashCode();
    }
}
