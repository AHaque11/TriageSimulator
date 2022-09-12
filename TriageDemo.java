// Arefa Haque
// CIS 2353
// Spring 2022
// Prof. John P. Baugh
package project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TriageDemo {

    public static void main(String[] args) {
        
        TriageSimulator waitingRoom = new TriageSimulator();
        
        try{
            Scanner inFile = new Scanner(new File("patient_list.txt"));
            
            while(inFile.hasNextLine()){ 
                String fileLine = inFile.nextLine(); //Read one line at a time
                waitingRoom.add(fileLine); //Add info from each line to the queues
            }
            
            inFile.close();     
        }
        catch(FileNotFoundException ex){
            System.out.println("ERROR: Could not open file. Please reopen the "
                    + "program and try again.\n");
            System.exit(0);
        }
        
        
        System.out.println("\nTRIAGE ORDER: ");
        
        while(!waitingRoom.isEmpty()){
            waitingRoom.remove();
        }
        
        System.out.println("\n");
        
    }
}
