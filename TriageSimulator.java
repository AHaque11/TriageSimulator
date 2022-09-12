// Arefa Haque
// CIS 2353
// Spring 2022
// Prof. John P. Baugh
package project4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class TriageSimulator {
    
    LinkedQueue<String> levelOne = new LinkedQueue<>();
    LinkedQueue<String> levelTwo = new LinkedQueue<>();
    LinkedQueue<String> levelThree = new LinkedQueue<>();



    public void add(String lineFromFile){
        Scanner lineReader = new Scanner(lineFromFile);
        
        String fName = "";
        String lName = "";
        String triageCode = "";
        
        while(lineReader.hasNext()){
            fName = lineReader.next();
            lName = lineReader.next();
            triageCode = lineReader.next();
        }
        
        String patientName = fName + " " + lName;

        switch (triageCode) {
            case "AL":
            case "HA":
            case "ST":
                levelOne.enQueue(patientName);
                break;
            case "BL":
            case "SF":
            case "IW":
            case "KS":
            case "OT":
                levelTwo.enQueue(patientName);
                break;
            default:
                levelThree.enQueue(patientName);
                break;
        }
    }
    
    public void remove(){
        if(!levelOne.isEmpty()){
            
            System.out.println("\t" + levelOne.deQueue());           
        }
        else if(!levelTwo.isEmpty()){
            
            System.out.println("\t" + levelTwo.deQueue());            
        }
        else{
            
            System.out.println("\t" + levelThree.deQueue());           
        }
        
    }
    
    public Boolean isEmpty(){
        return (levelOne.isEmpty() && levelTwo.isEmpty() 
                && levelThree.isEmpty());
    }
    
}
