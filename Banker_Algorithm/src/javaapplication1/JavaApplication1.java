/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author zyad
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        int numberOfResources , numberOfProcesses;
        Scanner input = new Scanner(System.in);
        System.out.println("enter number of resources");
        numberOfResources = input.nextInt();
        System.out.println("enter number of processes");
        numberOfProcesses = input.nextInt();

        int[] available = new int[numberOfResources];
        int[][] max = new int[numberOfProcesses][numberOfResources];
        int[][] need = new int[numberOfProcesses][numberOfResources];
        int[][] allocation = new int[numberOfProcesses][numberOfResources];

        //initializing the four arrays
        //available
        System.out.println("enter the number of available instances of each resource ");
        for (int i = 0; i < numberOfResources ; i++) {
            available[i] = input.nextInt();
        }
        //max
        System.out.println("enter the number of max needed resources for each process  ");
        for (int i = 0; i < numberOfProcesses ; i++) {
            for (int j = 0; j < numberOfResources ; j++) {
                max[i][j] = input.nextInt();
            }
        }
        //allocation
        System.out.println("enter the number of allocated resources for each process  ");
        for (int i = 0; i < numberOfProcesses ; i++) {
            for (int j = 0; j < numberOfResources ; j++) {
                allocation[i][j] = input.nextInt();
            }
        }
        //need
        for (int i = 0; i < numberOfProcesses ; i++) {
            for (int j = 0; j < numberOfResources ; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }

        // this is a test, if the output is 1 then its safe, if 0  its not safe
        System.out.println(CheckSafety.safetyAlgorithm(available , max , need , allocation , numberOfProcesses , numberOfResources));
    int choose;  

do{
      for(int i=0;i<numberOfProcesses;i++){
          System.out.print("p"+i+"  ");
      for(int j=0;j<numberOfResources;j++){
      
          System.out.print(allocation[i][j]+" ");
      
      }
          System.out.print("  ");
            for(int j=0;j<numberOfResources;j++){
      
          System.out.print(need[i][j]+" ");
      
      }
      
          System.out.println(" ");
      }   
       
      for(int i=0;i<available.length;i++){
          System.out.print(available[i]+"  ");
      }
      
      System.out.println("  ");
      
     System.out.println("choose operation \n"
             + "1. request resources \n"
             + "2. release resources \n"
             + "3. Quit \n");

        
         choose=input.nextInt();
         if(choose==3){break;}
         System.out.println("number of process");  
        int process=input.nextInt();
      
        System.out.println("enter amount of eache resource");
            int[] resource = new int[numberOfResources];
            for(int i=0;i<numberOfResources;i++){
            resource[i]=input.nextInt();
            }
            

      MangeProcess.mange(choose, process, resource, available, max, need, allocation, numberOfProcesses, numberOfResources);
}while(true);    
    }
    
}
    
/*
3 3 2

7 5 3
3 2 2
9 0 2
2 2 2
4 3 3
 
 0 1 0
 2 0 0 
 3 0 2 
 2 1 1 
 0 0 2

 
 
*/