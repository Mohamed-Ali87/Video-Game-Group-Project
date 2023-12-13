package code;

public class Bat extends Sprite {
	
static String[] pose = {"UP", "DN", "LT", "RT"};
	
	public int health = 3;

    public Bat(int x, int y) {
        super("bat", pose, 2, 0, "png", 7, x, y, 100, 100);
        scale = 3;
        
        
    }

}
