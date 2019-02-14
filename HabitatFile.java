/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it_145_finalproj;

/**
 *
 * @author zrebstock
 */
import java.io.*;
import java.util.Scanner;

public class HabitatFile {

    private String filePath = "";

    public HabitatFile(String file) {
        filePath = file;

    }

    public FileInputStream openFile(String fileName) { //method opens a file and returns a FileInputStream that other methods can use to read file

        FileInputStream FIS = null;
        try {
            FIS = new FileInputStream(fileName);

        } catch (Exception e) {
            System.out.println(e); //print error if file not found

        }

        return FIS; //return the FileInputStream for other methods to use

    }

    public void readHabitatlFileHeaders() {
        String line = "";
        int lineNum = 0;
        String file = filePath;
        FileInputStream FIS = openFile(file); //FIS memory allocated to call method to perform file opening...returns a 
        Scanner scnr = new Scanner(FIS); //scanner to read file input stream

        while (lineNum <= 17) {

            scnr.nextLine(); //skips through lines
            lineNum++; //coindident accumulator so we know which line number the previous nextLine() is on

            //resd available animals based off how many lines there are in file, and finding out where the "Animal - ... " starts for each line
            //I had to count the number of lines in the file to figure out which lines each animal type was on. Kind of a manual process and doesn't make the code dynamic or adaptable.
            if (lineNum == 4) {//print lion

                line = scnr.nextLine();
                System.out.println(line);
                lineNum++;
            } else if (lineNum == 9) { //print Penguin
                line = scnr.nextLine();
                System.out.println(line);
                lineNum++;
            } else if (lineNum == 14) { //print Bird
                line = scnr.nextLine();
                System.out.println(line);
                lineNum++;
            } else if (lineNum == 19) { //print Aquarium
                line = scnr.nextLine();
                System.out.println(line);
                lineNum++;
            }

        }
        try {
            FIS.close(); //close files
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    public void readHabitatFileContents(String habitat) {
        String line = "";
        int lineNum = 0;
        String file = filePath;
        FileInputStream FIS = openFile(file); //call method to open file
        Scanner scnr = new Scanner(FIS); //use scanner to read file contents

        System.out.println("********Printing habitat info********");

        switch (habitat) { //use switch to read specific number of lines for each animal based on argument passed into method

            case "penguin":
                while ((scnr.hasNextLine())) { //if file has lines

                    line = scnr.nextLine(); //set lines = to nextLine()
                    lineNum++; //line Number tracker so we know which line we are on
                    if (lineNum >= 4 && lineNum <= 8) { //print these lines
                        if (line.startsWith("*")) { //if line has asterisks, print an error to zookeeper
                            line = line.replace("*****", "!!ALERT!!"); //remove asterisk and replace with alert tags
                            System.out.println(line); //print modified alert line
                        } else {
                            System.out.println(line);
                        }

                    }
                }
                break;
            case "bird":
                while ((scnr.hasNextLine())) { //uses same behavior as first switch condition, different lines

                    line = scnr.nextLine();
                    lineNum++;
                    if (lineNum >= 9 && lineNum <= 13) {

                        if (line.startsWith("*")) {
                            line = line.replace("*****", "!!ALERT!!");
                            System.out.println(line);
                        } else {
                            System.out.println(line);
                        }
                    }

                }
                break;
            case "aquarium":
                while ((scnr.hasNextLine())) { //uses same behavior as first switch condition, different lines

                    line = scnr.nextLine();
                    lineNum++;
                    if (lineNum >= 14 && lineNum <= 18) {
                        if (line.startsWith("*")) {
                            line = line.replace("*****", "!!ALERT!!");
                            System.out.println(line);
                        } else {
                            System.out.println(line);
                        }

                    }

                }
                break;

            default: //if user's passed input doesn't match anything, print error and exit method
                System.out.println("Invalid input. Try again!");
        }
        try {
            FIS.close(); //close files
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

}
