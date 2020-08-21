package csci4963u20.project.doudizhu;

public class ServerTest {
	public static void main(String[] arg) {
    	Server s = new Server(8848);
    	Player a = new Player("Alice");
    	Player b = new Player("Bob");
    	Player c = new Player("Charlie");
    	/*Client p1 = new Client(a);
    	Client p2 = new Client(b);
    	Client p3 = new Client(c);
    	s.start();
    	p1.start();
    	p2.start();
    	p3.start();
    	try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    	p1.send("ready", null);
    	p2.send("ready", null);
    	p3.send("ready", null);
    	try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    	System.out.println("Name: " + p1.player.name + " " + "Id: " + p1.player.id);
    	System.out.println("Name: " + p2.player.name + " " + "Id: " + p2.player.id);
    	System.out.println("Name: " + p3.player.name + " " + "Id: " + p3.player.id);
    	System.out.println("Server: all Player is:");
    	for(Player p : s.group) {
    		System.out.println("Name: " + p.name + " " + "Id: " + p.id + " Deck: ");
    		p.deck.printDeck();
    	}
    	Deck temp = new Deck();
    	temp.add(new Card(3, "3"));
    	p1.send("sendDeck", temp);*/
    }
}
