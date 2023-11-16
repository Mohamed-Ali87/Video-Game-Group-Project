
public class StackArr 
{
	private int A [];
	private int top = -1;	// top = -1 means the stack is empty
	
// 1) parameterized constructor for size of the stack/array, but not for variable top -----------------------------------------------	
	public StackArr(int size)					
	{
		A = new int[size];
	}
	
// 2) should the stack/array be too small, we double its size ----------------------------------------------------------------------
	public void resize()	// We use it inside the method "push"				
	{
		int [] B = new int[2*A.length];    
		for (int i = 0; i < A.length; i++)	// better then using .. i <= top ..
		{
			B[i] = A[i];
		}
		A = B;
	}
	
// 3) adds an item on top of the stack -----------------------------------------------------------------------------------------------	
	public void push(int item)				
	{
		top++;
		if (top == A.length) resize();  // Utilizes "resize" if the array/stack is full
		A[top] = item;
	}
	
// 4) --takes the top item out of the stack	------------------------------------------------------------------------------------------
	public void pop()						
	{
		top --;
	}
	
// 5) gives the value of the top element from the stack ------------------------------------------------------------------------------
	public int top()						
	{
		return A[top];
	}
	
// 6) Returns true if the stack is empty and returns false if stack is nor empty	--------------------------------------------------
	public boolean isEmpty()				
	{										
		return top == -1;
	}
// 7) Prints the content of the Stack-------------------------------------------------------------------------------------------------	
	public void printStackArr()
	{
		for (int i = 0; i <= top; i++) System.out.print(A[i] + "  ");
		System.out.println();
	}
// 8) Returns the length/size of the Stack Array--------------------------------------------------------------------------------------
	public int getSizeOfArray()
	{
		return A.length;
	}
// 9) Returns the index of top IN CASE WE POPED TOO MANY TIMES
	public int getTopIndexCneck()
	{
		return this.top;
	}
	
//---------------------MAIN FOR TESTING-----------------------------------------------------------------------------------------------
	
	public static void main (String [] args)
	{
		StackArr s = new StackArr(5);
		s.push(11);
		s.push(22);
		s.push(33);
		s.printStackArr();
		System.out.println();
		s.push(44);
		System.out.println("The size of the Stack Array is " + s.getSizeOfArray() + ".");
		System.out.println();
		s.push(55);
		System.out.println("The size of the Stack Array is " + s.getSizeOfArray() + ".");
		System.out.println();
		s.push(66);
		System.out.println("The size of the Stack Array is " + s.getSizeOfArray() + ".");
		System.out.println();
		s.printStackArr();
		System.out.println();
		System.out.println("The top of the Stack is " + s.top() + ".");
		System.out.println();
		s.pop();
		s.pop();
		s.printStackArr();
		System.out.println();
		System.out.println("The top of the Stack is " + s.top() + ".");
		System.out.println();
		System.out.println("The size of the Stack Array is " + s.getSizeOfArray() + ".");
		System.out.println();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		if (s.isEmpty()) System.out.println("The Stack is empty."); 
		else System.out.println("The Stack is NOT empty.");
		System.out.println();
		System.out.println("The index of the top element is " + s.getTopIndexCneck() + ".");
		System.out.println();
		s.pop();
		s.pop();
		if (s.isEmpty()) System.out.println("The Stack is empty."); 
		else System.out.println("The Stack is NOT empty.");
		System.out.println();
		System.out.println("The index of the top element is " + s.getTopIndexCneck() + ".");
		System.out.println();
	}	
}
