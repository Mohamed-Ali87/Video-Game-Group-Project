package code;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

import javax.swing.Timer;

public class Game extends GameBase
{
	//note: make a class of entities and give each entity its own cooldown timer and fireBullet method
	//player's fireBullet method will involve input,
	//AI fireBullet method will shoot based on player's location
	
	Rect c     		   = new Rect(100, 100, 35, 35);
	double speed 	   = 5;
	
	Rect[]bullet       = new Rect[12];
	int bulletVelocity = 5;
	int i              = 0;
	int bW	 		   = 10;
	int bH			   = 10;
	
	Timer shotCooldown;
	int   cooldownTime;	
	
	public void initialize()
	{		
		cooldownTime = 400;
		
		shotCooldown = new Timer(cooldownTime, new ActionListener() 
		{
            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	shotCooldown.stop(); //cooldown ends after the above specified time
            }
        });
	}
	
	private void fireBullet(Rect r) 
	{
		if (i >= bullet.length) i = 0;
		
		if (pressing[RT]) 
        {
            bullet[i] = new Rect((int) r.x + (int)r.w, (int) r.y + (int)(r.h * .5 - bH * .5), bW, bH);
            bullet[i].setVelocity(bulletVelocity, (int) (r.vy * 0.8));
        }

        if (pressing[LT]) 
        {
            bullet[i] = new Rect((int) r.x - bW, (int) r.y + (int)(r.h * .5 - bH * .5), bW, bH);
            bullet[i].setVelocity(-bulletVelocity, (int) (r.vy * 0.8));
        }

        if (pressing[DN]) 
        {
            bullet[i] = new Rect((int) r.x + (int)(r.w * .5 - bW * .5), (int) r.y + (int)r.h, bW, bH);
            bullet[i].setVelocity((int) (r.vx * 0.8), bulletVelocity);
        }

        if (pressing[UP]) 
        {
            bullet[i] = new Rect((int) r.x + (int)(r.w * .5 - bW * .5), (int) r.y - bH, bW, bH);
            bullet[i].setVelocity((int) (r.vx * 0.8), -bulletVelocity);
        }
        i++;
    }
	
	public void inGameLoop()
	{	
		if (pressing[_W]) c.goUP(speed);
		if (pressing[_S]) c.goDN(speed);
		if (pressing[_A]) c.goLT(speed);
		if (pressing[_D]) c.goRT(speed);
        
		c.applyFriction();
		c.move();
		
		if (pressing[RT] || pressing[LT] || pressing[DN] || pressing[UP]) //shoot keys
        {
        	if (!shotCooldown.isRunning()) 				//if you aren't on cooldown
        	{
                fireBullet(c); 							//shoots a bullet instantly
                shotCooldown.start(); 					//cooldown activates before next bullet can shoot
        	}
        }
		
        for (int k = 0; k < bullet.length; k++) if (bullet[k] != null) bullet[k].move();
	}
	
	public void paint(Graphics pen)
	{
	   c.draw(pen);
	   
	   for (int j = 0; j < bullet.length; j++) if (bullet[j] != null) bullet[j].draw(pen);
	}

}