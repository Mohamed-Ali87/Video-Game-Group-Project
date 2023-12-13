package code;

public class Snake extends Sprite {
	
	static String[] pose = {"UP", "DN", "LT", "RT"};
	
	public int health = 3;

    public Snake(int x, int y) {
        super("snake", pose, 2, 0, "png", 7, x, y, 100, 100);
        scale = 3;
        
        
    }

}
