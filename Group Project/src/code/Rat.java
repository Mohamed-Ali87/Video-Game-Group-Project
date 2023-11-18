import java.awt.*;

public class Rat extends Sprite
{
	Animation[] animation ;
	int energy;
	Rect health = new Rect(150,100,300,40,Color.GREEN);
	Image healthSymbol = Toolkit.getDefaultToolkit().getImage("rat_walkRT_4.png");

	
	final static int idleUP 	= 0;
	final static int idleRTUP 	= 1;
	final static int idleLTUP 	= 2;
	final static int idleDN 	= 3;
	final static int idleRTDN 	= 4;
	final static int idleLTDN 	= 5;
	final static int idleLT		= 6;
	final static int idleRT 	= 7;
	final static int walkUP 	= 8;
	final static int walkDN 	= 9;
	final static int walkRT 	= 10;
	final static int walkLT 	= 11;
	final static int walkLTUP 	= 12;
	final static int walkLTDN 	= 13;
	final static int walkRTUP 	= 14;
	final static int walkRTDN 	= 15;
	final static int jumpLT 	= 16;
	final static int jumpLTUP 	= 17;
	final static int jumpLTDN 	= 18;
	final static int jumpRT 	= 19;
	final static int jumpRTUP 	= 20;
	final static int jumpRTDN 	= 21;
	final static int jumpUP 	= 22;
	final static int jumpDN 	= 23;
	final static int die 		= 24;
	
	
	static int[] imagecount = {4, 4, 4, 4, 4, 4, 4, 4, 6, 6, 6, 6, 6, 6, 6, 6, 9, 9, 9, 9, 9, 9, 9, 9, 8};
	static String[] pose = {"idleUP","idleRTUP","idleLTUP", "idleDN", "idleRTDN", "idleLTDN", "idleLT", "idleRT",
							"walkUP", "walkDN", "walkRT", "walkLT", "walkLTUP", "walkLTDN", "walkRTUP", "walkRTDN",
							"jumpLT", "jumpLTUP", "jumpLTDN", "jumpRT", "jumpRTUP", "jumpRTDN", "jumpUP", "jumpDN",
							"die"};
	
	public int current_pose = idleRTDN;
	public final double dScale = 0.71;
	public int moveby = 10;
		
	public boolean dead = false;
	public boolean moving = false;
	public boolean jumping = false;
	public boolean oUP;
	public boolean oDN;
	public boolean oLT;
	public boolean oRT;
	public boolean oUPLT;
	public boolean oUPRT;
	public boolean oDNLT;
	public boolean oDNRT;
	
	
	public Rat (String name, 
	   		  
	   		   int x, int y, int w, int h)
	{
		super(name, pose, imagecount, x, y, w, h);
		
		animation = new Animation[pose.length];
		
		for (int i = 0; i < pose.length; i++)
		{
			animation[i] = new Animation(name + "_" + pose[i], imagecount[i], 6 );
		}
	}
	/*
	 	if(pressing[_W])  
		if(pressing[_S]) 
		if(pressing[_A]) 
		if(pressing[_D]) 
	 */
	
	public void goLT(int dx)
	{
		if (moving && oLT && !jumping)
		{
			vx = -dx;
			if (jumping)
				current_pose = jumpLT;
			else
				current_pose = walkLT;
		}
	}
	
	public void goLTDN(int d)
	{
		if (moving && oDNLT && !jumping)
		{
			vx = (int)(-d * dScale);
			vy =  (int)(d * dScale);
			if (jumping)
				current_pose = jumpLTDN;
			else
				current_pose = walkLTDN;
		}
	}
	
	public void goLTUP(int d)
	{
		if (moving && oUPLT && !jumping)
		{
			vx = (int)(-d * dScale);
			vy =  (int)(-d * dScale);
			if (jumping)
				current_pose = jumpLTUP;
			else
				current_pose = walkLTUP;
		}
	}
	
	public void goRT(int dx)
	{
		if (moving && oRT && !jumping)
		{
			vx = dx;
			if (jumping)
				current_pose = jumpRT;
			else
				current_pose = walkRT;
		}
	}
	
	public void goRTUP(int d)
	{
		if (moving && oUPRT && !jumping)
		{
			vx = (int)(d * dScale);
			vy =  (int)(-d * dScale);
			if (jumping)
				current_pose = jumpRTUP;
			else
				current_pose = walkRTUP;
		}
	}
	
	public void goRTDN(int d)
	{
		if (moving && oDNRT && !jumping)
		{
			vx = (int)(d * dScale);
			vy =  (int)(d * dScale);
			if (jumping)
				current_pose = jumpRTDN;
			else
				current_pose = walkRTDN;
		}
	}
	
	public void goUP(int dy)
	{
		if (moving && oUP && !jumping)
		{
		vy = -dy;
		if (jumping)
			current_pose = jumpUP;
		else
			current_pose = walkUP;
		}
	}
	
	public void goDN(int dy)
	{
		if (moving && oDN && !jumping)
		{
		vy = dy;
		if (jumping)
			current_pose = jumpDN;
		else
			current_pose = walkDN;
		}
	}
	
	public void idle()
	{
		if (!moving)
		{
			if (oLT) current_pose = idleLT;
			if (oDNLT) current_pose = idleLTDN;
			if (oUPLT) current_pose = idleLTUP;
			if (oRT) current_pose = idleRT;
			if (oDNRT) current_pose = idleRTDN;
			if (oUPRT) current_pose = idleRTUP;
			if (oUP) current_pose = idleUP;
			if (oDN) current_pose = idleDN;
			
		}
	}
	
	public void hit()
	{
		health.w -= 3;
	}
	
	public void dead()
	{
		if (health.w <= 0) 
		{
			dead = true;
			current_pose = die;
		}
		else dead = false;
	}
	public void move()
	{
		x += vx;
		y += vy;
	}
	
	public void draw ( Graphics pen )
	{
		
		
		idle();
		goLT(moveby);
		goLTDN(moveby);
		goLTUP(moveby);
		goRT(moveby);
		goRTDN(moveby);
		goRTUP(moveby);
		goDN(moveby);
		goUP(moveby);
		pen.drawImage(animation[current_pose].getCurrentImage(), (int)x, (int)y, (int)w, (int)h, null);
		//hit();
		//dead();
		
		
		pen.setColor(Color.RED);
		pen.fillRect((int)health.x, (int)health.y, (int)health.w, (int)health.h);
		health.draw(pen);
		
		
		if ( dead ) pen.drawImage(animation[die].getCurrentImage(), 100, 100, 60, 60, null);
		else pen.drawImage(healthSymbol, 100, 100, 60, 60, null);
		
		
		
//		pen.drawRect((int)x + 40, (int)y + 20, (int)w - 40, (int)h - 50);
		moving = false;
	}
	
}
