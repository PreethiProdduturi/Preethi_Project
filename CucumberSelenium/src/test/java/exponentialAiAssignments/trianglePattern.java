package exponentialAiAssignments;

import java.util.Scanner;

public class trianglePattern {
	public static void main(String []args){
        
        int level = 0;
        Scanner s= new Scanner(System.in);
        System.out.println("enter number of levels");
        level=s.nextInt();
        int space = level-1;  
         for (int i= 0;i<level;i++)  
         {  
             for (int j=0;j<space;j++)  
                 System.out.print(" ");  
             for (int j=0;j<=i;j++) 
                 System.out.print("* ");  
           System.out.println();  
             space--;  
         }  
          }
}
