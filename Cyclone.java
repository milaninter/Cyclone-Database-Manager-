import java.util.*; 

public class Cyclone {

    public static final int gMAX_CYCLONES = 50;

    public static final Scanner gConsole = new Scanner(System.in);

    public static int[] gWindSpeed = new int[gMAX_CYCLONES];

    public static int gDatabaseSize; 


 /* Ask for a valid database number that is not bigger than 50 and then assigns 
    it to the array which then displays the menu options*/
 public static void main(String[] args) { 
        System.out.println("Fall2023 - UTSA - CS1083 - Section 002 - Project 2 - Cyclone - written by Oscar MIlan" + "\n"); 
        System.out.print("Please, enter the number of cyclones in the database (Max 50): "); 
        gDatabaseSize = gConsole.nextInt(); 
        while ((0 >= gDatabaseSize) || (gDatabaseSize > gMAX_CYCLONES)) { 
            System.out.println(); 
            System.out.println("Invalid value, please, try again."); 
            System.out.print("Please, enter the number of cyclones in the database (Max 50): "); 
            gDatabaseSize = gConsole.nextInt(); 
        } 
 
        gWindSpeed = new int[gDatabaseSize]; 
        System.out.println(); 
        int choice; 
        do { 
            System.out.println(); 
            System.out.println("MAIN MENU"); 
            System.out.println("0 - Exit, 1 - Add/Update a cyclone, 2 - Summary, 3 - Clear Database, 4 - Show Cyclones, 5 - Swap Cyclones"); 
            System.out.print("Select an option : "); 
            choice = gConsole.nextInt(); 
 
            while (choice > 5 || choice < 0) { 
                System.out.println(); 
                System.out.println("Invalid value, please, try again." + "\n"); 
                System.out.println("MAIN MENU");
                System.out.println("0 - Exit, 1 - Add/Update a Cyclone, 2 - Summary, 3 - Clear database, 4 - Show cyclones, 5 - Swap Cyclones"); 
                System.out.print("Select an option : "); 
                choice = gConsole.nextInt(); 
            } 
 
            if (choice == 0) { 
                None(); 
            } else if (choice == 1) { 
                addUpdCyclone(); 
            } else if (choice == 2) { 
                summary(); 
            } else if (choice == 3) { 
                clearDatabase(); 
            } else if (choice == 4) { 
                showCyclones(); 
            } else if (choice == 5) { 
                swapCyclones(); 
            } 
        } while (choice != 0); 
        } 
 // Exits out the code and displays a farewell message
    public static void None(){ 
        System.out.println(); 
        System.out.print("Thank you for looking at the Cyclone dabase program!"); 
        System.exit(0); 
 
    } 
    // takes an input for the index which then assigns a value from 0-1000 based on the input
    public static void addUpdCyclone(){ 
        System.out.println(); 
        System.out.print("Enter the index (0 to "+ (gDatabaseSize-1)+ ") : "); 
        int index = gConsole.nextInt(); 
        while(index< 0|| index>(gDatabaseSize-1)){ 
            System.out.println(); 
            System.out.println("Invalid value, please, try again."); 
            System.out.print("Enter the index (0 to "+ (gDatabaseSize-1)+ ") : "); 
            index = gConsole.nextInt(); 
        } 
        System.out.println(); 
        System.out.println("The current wind speed of the cyclone at " + index + " is : "+ (gWindSpeed[index])); 
        System.out.print("Enter the new wind speed (0 - 1000) : "); 
        int windSpeed = gConsole.nextInt(); 
        while(windSpeed<0 || windSpeed>1000){ 
            System.out.println(); 
            System.out.println("Invalid value, please, try again."); 
            System.out.println("The current wind speed of the cyclone at " + index + " is : "+ (gWindSpeed[index])); 
            System.out.print("Enter the new wind speed (0 - 1000) : "); 
            windSpeed = gConsole.nextInt(); 
 
        } 
 
        gWindSpeed[index] = windSpeed; 
 
    } 
    // Calls the method that assigns each index to a category type
    public static void summary() { 
        int a = 0; 
        int b = 0; 
        int c = 0; 
        int d = 0; 
        int e = 0; 
        int f = 0; 
        int g = 0; 
 
        getCyclonesByClass(a,b,c,d,e,f,g); // Call the method to count cyclones by class 
 
 
    } 
 /* The method clearDb basically clears out the values assigned in the array that are input from the user */
    public static void clearDatabase(){ 
        for(int i = 0; i<gWindSpeed.length; ++i){ 
            gWindSpeed[i]=0; 
        } 
 
    } 
    // Prints out all the values assigned to each index based on the size of the array
    public static void showCyclones(){ 
        System.out.println(); 
        System.out.println("LIST OF Cyclones' Wind Speed"); 
 
        for(int i = 0; i <gWindSpeed.length; ++i ){ 
            System.out.println("Cyclone["+i+"] : "+ gWindSpeed[i]); 
        } 
    } 
    // Takes input of two indexes that are not the same and swaps them 
    public static void swapCyclones(){ 
        System.out.println(); 
        System.out.print("Enter the position from (0 to " + (gWindSpeed.length - 1) + ") :  "); 
        int idxFrom = gConsole.nextInt(); 
 
        while (idxFrom < 0 || idxFrom >= gWindSpeed.length) { 
 
            System.out.println(); 
            System.out.println("Invalid value, please, try again."); 
            System.out.print("Enter the position from (0 to " + (gWindSpeed.length - 1) + ") : "); 
            idxFrom = gConsole.nextInt(); 
        } 
 
        System.out.println(); 
        System.out.print("Enter the position to change to (0 to " + (gWindSpeed.length - 1) + ") that is not " + idxFrom + " : "); 
        int idxTo = gConsole.nextInt(); 
 
        while (idxTo == idxFrom || idxTo < 0 || idxTo >= gWindSpeed.length) { 
 
            System.out.println(); 
            System.out.println("Invalid value, please, try again."); 
            System.out.print("Enter the position to change to (0 to " + (gWindSpeed.length - 1) + ") that is not " + idxFrom + " : "); 
            idxTo = gConsole.nextInt(); 
        } 
 
        swapValues(idxFrom, idxTo); 
 
    } 
    // Perform the swap between the two elements
    public static void swapValues( int f, int t){  
        int temp = gWindSpeed[f]; 
        gWindSpeed[f] = gWindSpeed[t]; 
        gWindSpeed[t] = temp; 
    } 
 // Performs the task of looking through the array values and assigns them based on categories
    public static void getCyclonesByClass(int a, int b, int c, int d, int e, int f, int g){ 
         
 
        for (int i = 0; i < gWindSpeed.length; ++i) { 
            if (gWindSpeed[i] > 0 && gWindSpeed[i] <= 38) { 
                ++a; 
            } else if (gWindSpeed[i] >= 39 && gWindSpeed[i] <= 73) { 
                ++b; 
            } else if (gWindSpeed[i] >= 74 && gWindSpeed[i] <= 95) { 
                ++c; 
            } else if (gWindSpeed[i] >= 96 && gWindSpeed[i] <= 110) { 
                ++g; 
            } else if (gWindSpeed[i] >= 111 && gWindSpeed[i] <= 129) { 
                ++d; 
            } else if (gWindSpeed[i] >= 130 && gWindSpeed[i] <= 156) { 
                ++e; 
            } else if (gWindSpeed[i] >= 157 && gWindSpeed[i] <= 1000) { 
                ++f; 
            } 
        } 
        System.out.println(); 
        System.out.println("Cyclones' Classification Summary"); 
        System.out.println("Tropical Depression  : " + a); 
        System.out.println("Tropical Storm       : " + b); 
        System.out.println("Hurricane Category 1 : " + c); 
        System.out.println("Hurricane Category 2 : " + g); 
        System.out.println("Hurricane Category 3 : " + d); 
        System.out.println("Hurricane Category 4 : " + e); 
        System.out.println("Hurricane Category 5 : " + f); 
    } 
 
} 

 
  

