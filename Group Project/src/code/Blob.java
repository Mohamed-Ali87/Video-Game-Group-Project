package code;

public class Blob extends Sprite {
	
static String[] pose = {"UP", "DN", "LT", "RT"};
	
	public int health = 3;

    public Blob(int x, int y) {
        super("blob", pose, 3, 0, "png", 7, x, y, 100, 100);
        scale = 3;
        
        
    }

}
