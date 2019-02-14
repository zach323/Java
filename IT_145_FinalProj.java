/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it_145_finalproj;

import java.util.Scanner;

/**
 *
 * @author zrebstock
 */
public class IT_145_FinalProj {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AnimalFile A_monitor = new AnimalFile("C:\\Users\\zrebstock\\Documents\\Zach\\animals.txt"); //create monitor for Animal files. NOTE: PASS YOUR FILE PATH HERE
        HabitatFile H_monitor = new HabitatFile("C:\\Users\\zrebstock\\Documents\\Zach\\habitats.txt"); //create monitor for Habitat files. NOTE: PASS YOUR FILE PATH HERE
        System.out.println("Enter \"habitat\" or \"animal\" to monitor or enter \"q\" to quit");
        String userInput = ""; //for inputting habitat file or animal file
        String fileInput = ""; //for selecting specific options from files
        Scanner scnr = new Scanner(System.in);

        System.out.println("\n\nDo you want to monitor an animal or habitat?");

        while (!userInput.equals("q")) {

            userInput = scnr.nextLine().toLowerCase();

            if (userInput.equals("animal")) { //read animals file from methods and allow user to select individual animals
                System.out.println("Current animals available for monitoring\n");
                A_monitor.readAnimalFileHeaders(); //read animal types in file
                System.out.println("\n******Select option by entering animal type. Example: enter \"lion\" to print lion info. Press any key to exit back to main menu******");
                fileInput = scnr.nextLine(); //new String input (so as not to not change the behavior of this loop with "userInput")
                A_monitor.readAnimalFileContents(fileInput.toLowerCase()); //pass user's menuInput into method and display animal information for their animal choice
                System.out.println("\n\nDo you want to monitor an animal or habitat?"); //back to main menu; prompt for habitat or animal or quit options
                System.out.println("Enter \"habitat\" or \"animal\" to monitor or enter \"q\" to quit");

            } else if (userInput.equals("habitat")) { // Display list of habitat options as read from files (same behavior as above statements, just calling another method.  
                System.out.println("Current habitats available for monitoring\n");
                H_monitor.readHabitatlFileHeaders();
                System.out.println("\n******Select option by entering habitat type. Example: enter \"penguin\" to print penguin habitat info. Press any key to exit back to main menu******");
                fileInput = scnr.nextLine(); //new String input (so as not to not change the behavior of this loop with "userInput")
                H_monitor.readHabitatFileContents(fileInput.toLowerCase());
                System.out.println("\n\nDo you want to monitor an animal or habitat?"); //back to main menu; prompt for habitat or animal or quit options
                System.out.println("Enter \"habitat\" or \"animal\" to monitor or enter \"q\" to quit");

            } else if (!userInput.equals("q")) { //if user enters anything but "q", "animal" or "habitat" an error message displays and prompts them for input again

                System.out.println("Invalid input. Try again!");

            }

        }

    }

}
