
public class Camera 
{
	static double x = 0;
	static double y = 1350;
	static double z;
	//*/
	public static void goLT(double dx)
	{
		 x -= dx;
	}

	public static void goRT(double dx)
	{
		 x += dx;
	}
	//*/
	
	public static void goUP(double dy)
	{
		y -= dy;
	}
	
	public static void goDN(double dy)
	{
		y += dy;
	}
	
	public static void goOT(double dz)
	{
		z -= dz;
	}
	
	public static void goIN(double dz)
	{
		z += dz;
	}
}
