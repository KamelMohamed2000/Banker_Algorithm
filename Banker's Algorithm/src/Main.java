import java.util.ArrayList;
import java.util.Scanner;

public class Main {

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





    public static void main(String[] args){

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
        System.out.println(safetyAlgorithm(available , max , need , allocation , numberOfProcesses , numberOfResources));







    }


}
