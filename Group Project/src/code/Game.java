package code;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Game extends GameBase
{
	
	Rect ship = new Rect(700, 500, 30,30);
	Rect bullet = new Rect((int)ship.x+10, (int)ship.y-10, 10, 10);
	boolean bool = false;
	Rect[] bullets = new Rect[100000];
	Rect[] Lbullets = new Rect[100000];
	
	
	int counter =0;
	public void initialize()
	{		
		for(int i = 0; i < bullets.length; i++)
		{
		   bullets[i] = new Rect((int)ship.x+10, (int)ship.y-10, 10, 10);
        }
		
		for(int i = 0; i < Lbullets.length; i++)
		{
		   Lbullets[i] = new Rect((int)ship.x+30, (int)ship.y+10, 10, 10);
        }
	}
	
	public void inGameLoop()
	{
		
		
		ship.physicsOFF();
		ship.move();
			
		// Respond to user input
	
		if(pressing[_W]) ship.goUP(10); 
		if(pressing[_S]) ship.goDN(10); 
		if(pressing[_A]) ship.goLT(10);
		if(pressing[_D]) ship.goRT(10); 
		

		if(pressing[SPACE]) {
			bullets[counter].setVelocity(0,   -20);
			bullets[counter].move();
			
			//bullets[counter] = new Rect(700, 200, 30,30);
			//counter++;
			
			
		}
		if(pressing[SPACE]) {
			Lbullets[counter].setVelocity(20,   0);
			Lbullets[counter].move();
			
			//bullets[counter] = new Rect(700, 200, 30,30);
			//counter++;
			
			
		}
		
		
		

	}
	
	public void paint(Graphics pen)
	{
		ship.draw(pen);
		//bullet.draw(pen);
		for(int i = 0; i < bullets.length; i++)
		{
		   bullets[i].draw(pen);
        }
		
		for(int i = 0; i < Lbullets.length; i++)
		{
		   Lbullets[i].draw(pen);
        }
	    
	}
	
	/*public  void keyPressed(KeyEvent e)
	{		
		pressing[e.getKeyCode()] = true;
		
		if(pressing[SPACE]) counter++;
	}*/
	
	

}