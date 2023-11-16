import java.awt.*;

public class ImageLayer 
{
	double x;
	double y;
//	double z;
	
	Image image;
	int repeats;
	
	public ImageLayer(String name, double x,double y,  int repeats)
	{
		image = Toolkit.getDefaultToolkit().getImage(name);
		
		this.x = x;
		this.y = y;
//		this.z = z;
		
		this.repeats = repeats;
	}
	
	public void moveBy(int dx, int dy)
	{
		x += dx;
		y += dy;
	}
	
	public  void draw(Graphics pen)
	{
		int w = image.getWidth(null);
		int h = image.getHeight(null);
		
		for (int i = 0; i < repeats; i++)
		{
		pen.drawImage(image, (int)(x + i*w - Camera.x ), (int)(y - Camera.y ), null );
		}
	}
}
