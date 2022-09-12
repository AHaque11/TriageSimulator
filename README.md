# TriageSimulator

This program organizes a list of patients based on triage codes and outputs the patient list in the order of priority. 

The program reads a text file with patient first and last names, followed by the triage code that corresponds to their injury/condition (an example is in this repository called "patient_list.txt"). The main program reads each line of information from the file and uses the class TriageSimulator to place each patient into one of four linked queues based on the level of priority. 

The main program then calls the remove function to print the names in the output window. The names are removed starting from the levelOne queue, and then from levelTwo, levelThree, and levelFour until each queue is empty.
