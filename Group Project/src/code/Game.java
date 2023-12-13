package code;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Game extends GameBase
{
	
	Image backgroundImage;
	Wall[] wall = new Wall[191];
	
	Rect rat = new Rect(300,300, 60, 60, Color.yellow);
	Snake snake = new Snake(500, 600);
	Bat bat = new Bat(2877,-4020);
	Bat bat1 = new Bat(2161,-3830);
	Bat bat2 = new Bat(3511,-3515);
	Vire vire = new Vire(2786,-3979);
	Vire vire1 = new Vire(2290,-3836);
	Vire vire2 = new Vire(3367,-3828);
	Blob blob = new Blob(800,800);

	
	
	public void initialize()
	{		
		backgroundImage = getImage(getDocumentBase(), "Final_Map.png");
		
		for(int i = 0; i < wall.length; i++)
		{
		   wall[i] = new Wall(1920 +60*i,  -4500, 150, 40);
        }
		
		//first room
		wall[0] = new Wall(881, 82, 150, 40); //up
		wall[1] = new Wall(92, 451, 63, 159);//left
		wall[2] = new Wall(1768, 448, 63, 160); //right
		
		//right1
		wall[3] = new Wall(2001, 448, 62, 165);
		
		//left1
		wall[4] = new Wall(-133, 452, 40, 168);
		
		//up1
		wall[5] = new Wall(890, -118, 150, 40);
		wall[6] = new Wall(887, -1012, 150, 40);
		
		//up2
		wall[7] = new Wall(891, -1207, 150, 40);
		wall[8] = new Wall(1787, -1707, 32, 156);
		
		//up2 right1
		wall[9] = new Wall(2803, -2097, 150, 40);
		wall[10] = new Wall(2017, -1705, 39, 153);
		
		//up3 right1
		wall[11] = new Wall(2806, -3141, 150, 40);
		wall[12] = new Wall(2018, -2790, 38, 160);
		wall[13] = new Wall(2804, -2284, 150, 40);
		wall[14] = new Wall(3707, -2778, 32, 161);
		
		//up3
		wall[15] = new Wall(1787, -2776, 33, 148);
		
		//up3 right 2
		wall[16] = new Wall(3931, -2793, 37, 170);
		
		//up4 right1
		wall[17] = new Wall(2803, -4251, 150, 40);
		wall[18] = new Wall(2802, -3360, 150, 40);
		
		//up5 right1
		wall[19] = new Wall(2804, -4435, 150, 40);
		wall[20] = new Wall(3706, -4955, 24, 167);
		
		//boss room
		wall[21] = new Wall(3912, -4967, 53, 190);
		wall[22] = new Wall(4714, -5338, 150, 40);
		
		//last room
		wall[23] = new Wall(4710, -5509, 185, 25);
		
		//********************************************************************************************************************************************************
	
		//Walls to handle collision
		
		
		//begining room
		wall[24] = new Wall(109, 60, 105, 100);
		wall[25] = new Wall(135, 582, 101, 325);
		wall[26] = new Wall(133, 184, 108, 293);
		wall[27] = new Wall(1682, 587, 116, 288);
		wall[28] = new Wall(363, 482, 105, 100);
		wall[29] = new Wall(1681, 186, 107, 291);
		wall[30] = new Wall(1029, 89, 650, 96);
		wall[31] = new Wall(242, 124, 649, 65);
		wall[32] = new Wall(237, 875, 1439, 51);
		wall[33] = new Wall(1443, 677, 105, 100);
		wall[34] = new Wall(1085, 678, 105, 100);
		wall[35] = new Wall(361, 677, 105, 100);
		wall[36] = new Wall(726, 679, 105, 100);
		wall[37] = new Wall(1445, 482, 105, 100);
		wall[38] = new Wall(1083, 485, 105, 100);
		wall[39] = new Wall(722, 484, 105, 100);
		wall[40] = new Wall(363, 287, 105, 100);
		wall[41] = new Wall(1439, 287, 105, 100);
		wall[42] = new Wall(721, 288, 105, 100);
		wall[43] = new Wall(1084, 283, 105, 100);
		
		//left1
		wall[44] = new Wall(-233, 295, 131, 187);
		wall[45] = new Wall(-592, 388, 118, 99);
		wall[46] = new Wall(-713, 482, 119, 103);
		wall[47] = new Wall(-229, 583, 123, 345);
		wall[48] = new Wall(-1545, 877, 1312, 50);
		wall[49] = new Wall(-1777, 95, 107, 788);
		wall[50] = new Wall(-1672, 88, 1321, 102);
		wall[51] = new Wall(-473, 287, 120, 100);
		wall[52] = new Wall(-473, 679, 122, 103);
		wall[53] = new Wall(-594, 776, 119, 101);
		wall[54] = new Wall(-353, 193, 118, 102);
		wall[55] = new Wall(-839, 579, 132, 102);
		wall[56] = new Wall(-952, 680, 124, 104);
		wall[57] = new Wall(-1670, 781, 123, 102);
		wall[58] = new Wall(-1551, 680, 115, 100);
		wall[59] = new Wall(-1428, 583, 119, 102);
		wall[60] = new Wall(-1310, 486, 118, 100);
		wall[61] = new Wall(-1187, 384, 116, 102);
		wall[62] = new Wall(-1547, 289, 117, 99);
		wall[63] = new Wall(-1429, 192, 122, 102);
		wall[64] = new Wall(-1071, 291, 114, 101);
		
		//rigt1
		wall[65] = new Wall(2041, 581, 117, 295);
		wall[66] = new Wall(2160, 879, 1459, 61);
		wall[67] = new Wall(2030, 188, 132, 296);
		wall[68] = new Wall(2162, 380, 1432, 109);
		wall[69] = new Wall(3596, 189, 150, 710);
		wall[70] = new Wall(2946, 67, 651, 123);
		wall[71] = new Wall(2162, 69, 649, 118);
		
		//up1
		wall[72] = new Wall(1035, -196, 531, 73);
		wall[73] = new Wall(370, -198, 536, 71);
		wall[74] = new Wall(376, -1004, 528, 119);
		wall[75] = new Wall(202, -782, 46, 490);
		wall[76] = new Wall(247, -303, 125, 110);
		wall[77] = new Wall(249, -884, 126, 103);
		wall[78] = new Wall(1561, -301, 126, 102);
		wall[79] = new Wall(1689, -781, 99, 484);
		wall[80] = new Wall(1574, -887, 114, 104);
		wall[81] = new Wall(1034, -1006, 535, 129);
		
		//up2
		wall[82] = new Wall(485, -1970, 236, 196);
		wall[83] = new Wall(1020, -1282, 672, 94);
		wall[84] = new Wall(218, -1672, 22, 435);
		wall[85] = new Wall(236, -1280, 658, 67);
		wall[86] = new Wall(1317, -1481, 122, 98);
		wall[87] = new Wall(473, -1481, 126, 104);
		wall[88] = new Wall(1681, -1576, 162, 313);
		wall[89] = new Wall(1440, -1970, 395, 291);
		wall[90] = new Wall(1198, -1970, 239, 197);
		wall[91] = new Wall(1078, -1971, 121, 98);
		wall[92] = new Wall(844, -2091, 234, 121);
		wall[93] = new Wall(724, -1970, 113, 96);
		wall[94] = new Wall(237, -1970, 248, 298);
		
		//up2 right1
		wall[95] = new Wall(2162, -2092, 652, 120);
		wall[96] = new Wall(2043, -1577, 114, 304);
		wall[97] = new Wall(2075, -1972, 83, 293);
		wall[98] = new Wall(2161, -1282, 1560, 69);
		wall[99] = new Wall(3595, -1971, 152, 685);
		wall[100] = new Wall(2948, -2091, 675, 120);
		
		//up3
		wall[101] = new Wall(1680, -2654, 89, 303);
		wall[102] = new Wall(1680, -3048, 159, 287);
		wall[103] = new Wall(243, -2363, 1448, 36);
		wall[104] = new Wall(220, -3051, 20, 699);
		wall[105] = new Wall(242, -3169, 1440, 123);
		
		//up3 right1
		wall[106] = new Wall(2158, -2355, 661, 103);
		wall[107] = new Wall(2944, -2356, 679, 101);
		wall[108] = new Wall(2030, -2650, 127, 307);
		wall[109] = new Wall(2940, -3156, 662, 109);
		wall[110] = new Wall(2029, -3047, 128, 295);
		wall[111] = new Wall(2521, -2553, 718, 104);
		wall[112] = new Wall(3237, -2846, 133, 398);
		wall[113] = new Wall(2517, -2947, 851, 101);
		wall[114] = new Wall(2398, -2947, 120, 500);
		wall[115] = new Wall(3599, -2650, 69, 296);
		wall[116] = new Wall(3600, -3048, 131, 297);
		wall[117] = new Wall(2162, -3165, 652, 118);
		
		//up4 right1
		wall[118] = new Wall(2162, -3731, 113, 314);
		wall[119] = new Wall(2278, -3535, 479, 117);
		wall[120] = new Wall(2140, -3842, 20, 120);
		wall[121] = new Wall(3597, -3843, 20, 120);
		wall[122] = new Wall(2278, -4125, 480, 97);
		wall[123] = new Wall(2641, -4027, 113, 389);
		wall[124] = new Wall(2400, -3926, 118, 392);
		wall[125] = new Wall(3001, -4123, 597, 98);
		wall[126] = new Wall(2161, -4245, 647, 118);
		wall[127] = new Wall(2949, -4246, 650, 121);
		wall[128] = new Wall(3480, -3729, 119, 194);
		wall[129] = new Wall(2760, -3724, 114, 83);
		wall[130] = new Wall(3243, -4020, 110, 378);
		wall[131] = new Wall(3483, -4023, 112, 189);
		wall[132] = new Wall(3121, -3531, 476, 94);
		wall[133] = new Wall(3005, -3830, 110, 390);
		wall[134] = new Wall(2879, -3926, 240, 94);
		wall[135] = new Wall(2161, -4125, 117, 294);
		
		//up3 right2
		wall[136] = new Wall(3933, -2757, 20, 120);
		wall[137] = new Wall(4553, -2556, 475, 88);
		wall[138] = new Wall(3951, -2657, 120, 200);
		wall[139] = new Wall(4073, -2655, 116, 192);
		wall[140] = new Wall(4434, -2656, 236, 95);
		wall[141] = new Wall(4315, -2758, 117, 193);
		wall[142] = new Wall(4676, -3174, 234, 122);
		wall[143] = new Wall(4672, -2363, 240, 82);
		wall[144] = new Wall(4070, -2456, 600, 93);
		wall[145] = new Wall(3958, -2953, 232, 195);
		wall[146] = new Wall(5509, -2762, 20, 120);
		wall[147] = new Wall(5395, -2657, 141, 192);
		wall[148] = new Wall(5395, -2952, 114, 193);
		wall[149] = new Wall(4914, -2460, 593, 96);
		wall[150] = new Wall(5154, -2754, 115, 95);
		wall[151] = new Wall(4913, -2657, 357, 92);
		wall[152] = new Wall(4915, -2852, 353, 95);
		wall[153] = new Wall(4317, -2852, 351, 94);
		wall[154] = new Wall(4555, -2955, 474, 101);
		wall[155] = new Wall(4914, -3050, 598, 98);
		wall[156] = new Wall(4072, -3049, 598, 92);
		
		//up5 right1
		wall[157] = new Wall(3600, -4816, 235, 295);
		wall[158] = new Wall(2139, -5216, 20, 709);
		wall[159] = new Wall(2158, -4522, 658, 106);
		wall[160] = new Wall(2941, -4522, 667, 108);
		wall[161] = new Wall(2164, -5333, 1435, 123);
		wall[162] = new Wall(3598, -5209, 201, 292);
		wall[163] = new Wall(2402, -4818, 113, 99);
		wall[164] = new Wall(3361, -4916, 118, 99);
		wall[165] = new Wall(3240, -4821, 117, 102);
		wall[166] = new Wall(2401, -5015, 120, 98);
		wall[167] = new Wall(2282, -4915, 118, 94);
		wall[168] = new Wall(3241, -5013, 116, 99);
		
		//boss room
		wall[169] = new Wall(3923, -4814, 148, 203);
		wall[170] = new Wall(3911, -5112, 168, 189);
		wall[171] = new Wall(5510, -5105, 108, 482);
		wall[172] = new Wall(4868, -5332, 607, 121);
		wall[173] = new Wall(4072, -4624, 120, 102);
		wall[174] = new Wall(4194, -5329, 529, 117);
		wall[175] = new Wall(4193, -4524, 1213, 71);
		wall[176] = new Wall(5392, -5210, 123, 103);
		wall[177] = new Wall(5392, -4622, 122, 103);
		wall[178] = new Wall(4071, -5210, 123, 97);
		
		//last room
		wall[179] = new Wall(4198, -5607, 1217, 106);
		wall[180] = new Wall(4080, -6191, 120, 591);
		wall[181] = new Wall(4081, -6292, 1335, 99);
		wall[182] = new Wall(5043, -6093, 232, 193);
		wall[183] = new Wall(4321, -6094, 236, 195);
		wall[184] = new Wall(4562, -6290, 118, 199);
		wall[185] = new Wall(4918, -6290, 118, 198);
		wall[186] = new Wall(5399, -6288, 117, 688);
		wall[187] = new Wall(5159, -5706, 121, 105);
		wall[188] = new Wall(4319, -5703, 118, 103);
		wall[189] = new Wall(4915, -5899, 123, 99);
		wall[190] = new Wall(4557, -5902, 119, 102);



	}
	
	public void inGameLoop()
	{
		rat.physicsOFF();
		
					
		// Respond to user input
	
		if(pressing[_W]) rat.goUP(10); 
		if(pressing[_S]) rat.goDN(10); 
		if(pressing[_A]) rat.goLT(10);
		if(pressing[_D]) rat.goRT(10); 
		
		snake.moveLeftRight(300, 300, 5);
		bat.moveLeftRight(700, 700, 5);
		bat1.moveLeftRight(0, 1400, 5);
		bat2.moveLeftRight(1400, 0, 5);
		vire.moveUpDown(300, 2);
		vire1.moveUpDown(200, 2);
		vire2.moveUpDown(300, 2);
		blob.chase(rat, 2);
		
		
		bat.move();
		bat1.move();
		bat2.move();
		snake.move();
		rat.move();
		vire.move();
		vire1.move();
		vire2.move();
		blob.move();
		
		for(int i = 24; i < wall.length; i++)
		{
			if(rat.overlaps(wall[i]))
			{
				rat.pushedOutOf(wall[i]);
			}
		}
		
        if(rat.overlaps(wall[0])) { 
			
			Camera.setLocation(0, -1080);
			
			rat.x = 937;
			rat.y = -200;
		}
        
        if(rat.overlaps(wall[1])) { 
			
			Camera.setLocation(-1920, 0);
			
			rat.x = -227;
			rat.y = 501;
		}
        
        if(rat.overlaps(wall[2])) { 
			
			Camera.setLocation(1920, 0);
			
			rat.x = 2107;
			rat.y = 499;
		}
        
        
        
        if(rat.overlaps(wall[3])) { 
			
			Camera.setLocation(0, 0);
			
			rat.x = 1683;
			rat.y = 496;
		}
        
        
        if(rat.overlaps(wall[4])) { 
			
			Camera.setLocation(0, 0);
			
			rat.x = 172;
			rat.y = 495;
		}
        
       if(rat.overlaps(wall[5])) { 
			
			Camera.setLocation(0, 0);
			
			rat.x = 914;
			rat.y = 150;
		}
       
       if(rat.overlaps(wall[6])) { 
			
			Camera.setLocation(0, -2160);
			
			rat.x = 916;
			rat.y = -1288;
		}
       
       if(rat.overlaps(wall[7])) { 
			
			Camera.setLocation(0, -1080);
			
			rat.x = 922;
			rat.y = -929;
		}
       
       if(rat.overlaps(wall[8])) { 
			
			Camera.setLocation(1920, -2160);
			
			rat.x = 2120;
			rat.y = -1669;
		}
		
       if(rat.overlaps(wall[9])) { 
			
			Camera.setLocation(1920, -3240);
			
			rat.x = 2830;
			rat.y = -2357;
		}
       
       if(rat.overlaps(wall[10])) { 
			
			Camera.setLocation(0, -2160);
			
			rat.x = 1677;
			rat.y = -1660;
		}
       
       if(rat.overlaps(wall[11])) { 
			
			Camera.setLocation(1920, -4320);
			
			rat.x = 2833;
			rat.y = -3442;
		}
       
       if(rat.overlaps(wall[12])) { 
			
			Camera.setLocation(0, -3240);
			
			rat.x = 1680;
			rat.y = -2752;
		}
       
       if(rat.overlaps(wall[13])) { 
			
			Camera.setLocation(1920, -2160);
			
			rat.x = 2843;
			rat.y = -2017;
		}
       
       if(rat.overlaps(wall[14])) { 
			
			Camera.setLocation(3840, -3240);
			
			rat.x = 4015;
			rat.y = -2749;
		}
       
       if(rat.overlaps(wall[15])) { 
			
			Camera.setLocation(1920, -3240);
			
			rat.x = 2100;
			rat.y = -2742;
		}

	
	
    if(rat.overlaps(wall[16])) { 
		
			Camera.setLocation(1920, -3240);
			
			rat.x = 3606;
			rat.y = -2738;
		}
    
    if(rat.overlaps(wall[17])) { 
		
			Camera.setLocation(1920, -5400);
			
			rat.x = 2834;
			rat.y = -4522;
		}
    
    if(rat.overlaps(wall[18])) { 
		
			Camera.setLocation(1920, -3240);
			
			rat.x = 2832;
			rat.y = -3083;
		}
    
    if(rat.overlaps(wall[19])) { 
		
			Camera.setLocation(1920, -4320);
			
			rat.x = 2832;
			rat.y = -4189;
		}
    
    if(rat.overlaps(wall[20])) { 
		
			Camera.setLocation(3840, -5400);
			
			rat.x = 4015;
			rat.y = -4910;
		}
    
    if(rat.overlaps(wall[21])) { 
		
			Camera.setLocation(1920, -5400);
			
			rat.x = 3609;
			rat.y = -4908;
		}
    
    if(rat.overlaps(wall[22])) { 
		
			Camera.setLocation(3840, -6480);
			
			rat.x = 4753;
			rat.y = -5599;
		}
    
    if(rat.overlaps(wall[23])) { 
		
			Camera.setLocation(3840, -5400);
			
			rat.x = 4745;
			rat.y = -5277;
		}

	}

	
	
	
	
	public void paint(Graphics pen)
	{
		pen.drawImage(backgroundImage, -1920 - Camera.x, -6480 - Camera.y, 7680, 7560, this);
		
		for(int i = 0; i < wall.length; i++ )
		{
		  // wall[i].draw(pen);
		  
		}
		
		bat.draw(pen);
		bat1.draw(pen);
		bat2.draw(pen);
		rat.draw(pen);
		snake.draw(pen);
		vire.draw(pen);
		vire1.draw(pen);
		vire2.draw(pen);
		blob.draw(pen);
	    
	}
	
	
	public void keyPressed(KeyEvent e)
	{		
		pressing[e.getKeyCode()] = true;
		
		int code = e.getExtendedKeyCode();
		
		if(code == UP) Camera.moveUp(1080); 
		if(code == DN) Camera.moveDown(1080);
		if(code == RT) Camera.moveRight(1920);
		if(code == LT) Camera.moveLeft(1920);
		repaint();
		
		
		
	}
	
	public void mouseDragged(MouseEvent e)
	{
		int nx = e.getX()+ Camera.x;
		int ny = e.getY() + Camera.y;
		
		int dx = nx - mx;
		int dy = ny - my;
		
		
		for(int i = 0; i < wall.length; i++)
		{
			if(wall[i].resizer.held)
			{
				wall[i].resizeBy(dx, dy);
			}
			else
			if(wall[i].held)
			{
				wall[i].moveBy(dx, dy);
			}
		}
		
		mx = nx;
		my = ny;	
		
		
	}
	
	
	public void mousePressed(MouseEvent e)
	{
		mx = e.getX() + Camera.x;
		my = e.getY() + Camera.y;
		
		for(int i = 0; i < wall.length; i++)
		{
			if(wall[i].contains(mx, my))
			{
				wall[i].grab();
			}
			
			if(wall[i].resizer.contains(mx,  my))
			{
				wall[i].resizer.grab();
			}
		}
		
		System.out.println(mx + "," + my);
		
	}
	
	public void mouseReleased(MouseEvent e)
	{
		
		for(int i = 0; i < wall.length; i++)
		{
			wall[i].drop();
			wall[i].resizer.drop();
		}	
	}
	
	
	
	public void keyTyped(KeyEvent e)
	{
		for(int i = 0; i < wall.length; i++)
		{
			System.out.println(wall[i].toString());
		}	
	}
	

}