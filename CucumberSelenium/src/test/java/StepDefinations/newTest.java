package StepDefinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class newTest {
	
	public static boolean checkOrder(int[] number) {
		int i=0;
		// flag=true;
		for(i=0;i<number.length-1;i++) 
		{
		 if((number[i])>(number[i+1])) 
			return false;
		}
		return true;
	}
public static void main(String[] args) {
	//Scanner s = new Scanner(System.in);
	int[] temp= {1,2,2,7};
	boolean value= checkOrder(temp);
	
	System.out.println(value);
	
}
}
