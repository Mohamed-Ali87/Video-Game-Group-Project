package code;

public class Vire extends Sprite {
	
static String[] pose = {"UP", "DN", "LT", "RT"};
	
	public int health = 3;

    public Vire(int x, int y) {
        super("vire", pose, 2, 0, "png", 7, x, y, 100, 100);
        scale = 3;
        
        
    }

}
