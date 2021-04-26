/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.ArrayList;

/**
 *
 * @author zyad
 */
public class CheckSafety {
    
    
    public static int safetyAlgorithm(int[] available , int[][] max , int[][] need , int[][] allocation
    ,int numberOfProcesses , int numberOfResources){

        ArrayList<Integer> sequenceOfProcesses = new ArrayList<>();

        int[] work = new int[numberOfResources];
        for (int i = 0; i < numberOfResources ; i++) {
            work[i] = available[i];
        }

        boolean[] finish = new boolean[numberOfProcesses];
        //initializing finish (for processes) to false
        for (int i = 0; i < numberOfProcesses ; i++) {
            finish[i] = false;
        }

        //checking whether this current state is safe or not
        int loops = numberOfProcesses;
        while (loops != 0) {
            for (int i = 0; i < numberOfProcesses; i++) {
                for (int j = 0; j < numberOfResources; j++) {
                    if (need[i][j] <= work[j] && !finish[i]) {
                        if (j == numberOfResources-1){
                            finish[i] = true;
                        }
                    } else {

                        break;
                    }

                }
                if (finish[i] && !sequenceOfProcesses.contains(i)) { // process[i] is finished (true)
                    for (int j = 0; j < numberOfResources; j++) {
                        work[j] += allocation[i][j];

                    }
                    sequenceOfProcesses.add(i);
                }

            }

            loops--;

        }
        // checking if all processes in the sequence or not
        // and if so (finish for all i < numberOfProcesses)
        // then all processes have done their work and we are in a safe state
        if (sequenceOfProcesses.size() == numberOfProcesses)
            return 1;

	
	
		return 0;
	

}
    
    
    
    
}
