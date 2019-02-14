package it_145_finalproj;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zrebstock
 */
import java.io.*;
import java.util.Scanner;

public class AnimalFile {

    private String filePath = "";

    public AnimalFile(String file) { //constructor
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

    public void readAnimalFileHeaders() {
        String line = "";
        int lineNum = 0;
        String file = filePath; //file to be opened and passed into openFile()
        FileInputStream FIS = openFile(file); //open file and pass file path
        Scanner scnr = new Scanner(FIS); //use scanner to read file contents

        //print content headers (i.e. "Animal - Lion")
        while (lineNum <= 23) {

            scnr.nextLine();
            lineNum++;
            if (lineNum == 5) { //print 5th line in file for Lion
                line = scnr.nextLine();
                System.out.println(line);
                lineNum++; //increment line num counter
            } else if (lineNum == 11) { //print 11th line in file for Tiger
                line = scnr.nextLine();
                System.out.println(line);
                lineNum++; //increment line num counter
            } else if (lineNum == 17) { //print 17th line in file for Bear
                line = scnr.nextLine();
                System.out.println(line);
                lineNum++; //increment line num counter
            } else if (lineNum == 23) { //print 23rd line in file for Giraffe
                line = scnr.nextLine();
                System.out.println(line);
                lineNum++; //increment line num counter
            }

        }
        try {
            FIS.close(); //close files
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    public void readAnimalFileContents(String animal) {
        String line = "";
        int lineNum = 0;
        String file = filePath;
        FileInputStream FIS = openFile(file);
        Scanner scnr = new Scanner(FIS);

        System.out.println("********Printing animal info********");

        switch (animal) { //use switch to validate input passed from main by user

            case "lion":
                while ((scnr.hasNextLine())) { //while file has lines

                    line = scnr.nextLine();
                    lineNum++; //this number keeps track of what line we are on, so we know which line to read based off known line numbers in the file.
                    if (lineNum >= 5 && lineNum <= 9) {
                        if (line.startsWith("*")) { //if beginning of line has an asterisk...
                            line = line.replace("*****", "!!ALERT!!"); //change asterisk to !!ALERT!!
                            System.out.println(line); //print modified ALERT and line
                        } else {
                            System.out.println(line); //else if no alerts found, print normal line
                        }

                    }
                }
                break;
            case "tiger": //See comments on lines 87 - 101 for details. Same code, different lines in file being read
                while ((scnr.hasNextLine())) {

                    line = scnr.nextLine();
                    lineNum++;
                    if (lineNum >= 11 && lineNum <= 16) {

                        if (line.startsWith("*")) {
                            line = line.replace("*****", "!!ALERT!!");
                            System.out.println(line);
                        } else {
                            System.out.println(line);
                        }
                    }

                }
                break;
            case "bear": //See comments on lines 87 - 101 for details. Same code, different lines in file being read
                while ((scnr.hasNextLine())) {

                    line = scnr.nextLine();
                    lineNum++;
                    if (lineNum >= 17 && lineNum <= 22) {
                        if (line.startsWith("*")) {
                            line = line.replace("*****", "!!ALERT!!");
                            System.out.println(line);
                        } else {
                            System.out.println(line);
                        }

                    }

                }
                break;
            case "giraffe": //See comments on lines 87 - 101 for details. Same code, different lines in file being read
                while ((scnr.hasNextLine())) {

                    line = scnr.nextLine();
                    lineNum++;
                    if (lineNum >= 23 && lineNum <= 28) {

                        if (line.startsWith("*")) {
                            line = line.replace("*****", "!!ALERT!!");
                            System.out.println(line);
                        } else {
                            System.out.println(line);
                        }

                    }

                }
                break;
            default: //this executes if user input does not match any of the switch conditions. Exits back to main loop to unlock file.
                System.out.println("Invalid input. Try again!");
        }
        try {
            FIS.close(); //close files
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
