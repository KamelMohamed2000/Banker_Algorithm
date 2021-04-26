/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author zyad
 */
public class MangeProcess {
    
   public static void  mange(int num,int process,int values[],int[] available , int[][] max , int[][] need , int[][] allocation
    ,int numberOfProcesses , int numberOfResources){
    
    
      if(num==1){
        request(process, values, available, max, need, allocation, numberOfProcesses, numberOfResources);
        }
    
      if(num==2) {
    
          relese(process, values, available, need, allocation);
       }
    
    }
    
    public static void request(int process,int values[],int[] available , int[][] max , int[][] need , int[][] allocation
    ,int numberOfProcesses , int numberOfResources){
        
    int countAVA=0,countNeed=0;
   
    for(int i=0;i<numberOfResources;i++){
    if(values[i]<=available[i]){
    countAVA++;
    }
    
    if(values[i]<=need[process-1][i]){
    countNeed++;
    }
    }
    
    
    if(countAVA==numberOfResources&&countNeed==numberOfResources){
    
        for(int i=0;i<numberOfResources;i++){
    
           available[i]-=values[i];
           allocation[process-1][i]+=values[i];
           need[process-1][i]-=values[i];
        }
    
          if(CheckSafety.safetyAlgorithm(available, max, need, allocation, numberOfProcesses, numberOfResources)==0){
   
            for(int i=0;i<numberOfResources;i++){
    
               available[i]+=values[i];
               allocation[process-1][i]-=values[i];
               need[process-1][i]+=values[i];
            }
   
            System.out.println("request is unsafe");
       
           }
          
          else{System.out.println("request performed");}
    
    }
    else{System.out.println("the resources are not available");}
    
    }
    
   
    public static void relese(int process,int values[],int ava[],int[][] need,int[][] allocation){
         int count=0;
         for(int i=0;i<values.length;i++){
                if(values[i]<=allocation[process-1][i]){
                                count++;
                        }
         }

        if(count==values.length){
    
       for(int i=0;i<values.length;i++){
              ava[i]=ava[i]+values[i];
              allocation[process-1][i]=allocation[process-1][i]-values[i];
              need[process-1][i]=need[process-1][i]+values[i];

       }
                          
        }}
}