
package Triage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class TriageSimulator {
    
    LinkedQueue<String> levelOne = new LinkedQueue<>();
    LinkedQueue<String> levelTwo = new LinkedQueue<>();
    LinkedQueue<String> levelThree = new LinkedQueue<>();
    LinkedQueue<String> levelFour = new LinkedQueue<>();



    public void add(String lineFromFile){
        Scanner lineReader = new Scanner(lineFromFile);
        
        String fName = "";
        String lName = "";
        String triageCode = "";
        
        while(lineReader.hasNext()){ //For each line:
            fName = lineReader.next();  //read first name
            lName = lineReader.next();  //read last name
            triageCode = lineReader.next(); //read triage code
        }
        
        String patientName = fName + " " + lName; //Combine first & last name
        
        //Place each patient in the appropriate queue based on triage code
        switch (triageCode) {
            case "CA": //Cardiac arrest
            case "SZ": //Seizure
            case "RD": //Respiratory distress
            case "MT": //Major trauma
                levelOne.enQueue(patientName);
                break;
            case "ST": //Stroke
            case "HI": //Head injury
            case "AS": //Asthma
            case "BB": //Broken bone
                levelTwo.enQueue(patientName);
                break;
            case "IN": //Infection
            case "LC": //Laceration
                levelThree.enQueue(patientName);
                break;
            default:   //All other codes
                levelFour.enQueue(patientName);
                break;
        }
    }
    
    public void remove(){ //Remove names from each queue until empty, in order
        if(!levelOne.isEmpty()){
            
            System.out.println("\t" + levelOne.deQueue());           
        }
        else if(!levelTwo.isEmpty()){
            
            System.out.println("\t" + levelTwo.deQueue());            
        }
        else if(!levelThree.isEmpty()){
            
            System.out.println("\t" + levelThree.deQueue());            
        }
        else{
            
            System.out.println("\t" + levelFour.deQueue());           
        }
        
    }
    
    public Boolean isEmpty(){
        return (levelOne.isEmpty() && levelTwo.isEmpty() 
                && levelThree.isEmpty() && levelFour.isEmpty());
    }
    
}
