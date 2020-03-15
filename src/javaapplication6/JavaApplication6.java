package javaapplication6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
import javax.print.DocFlavor;

public class JavaApplication6 {

    static String readFile(String address) {
        try {
            File myObj = new File(address);
            Scanner myReader = new Scanner(myObj);
            String lines = "";
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();

                lines = lines + "\n\r" + data;
            }
            myReader.close();
            return lines.toLowerCase();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred." + " " + "\n\r" + e);
            return null;
        }
    }

    static boolean matchText(String reg, String input) {
        try {
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(input);
            return m.find();
            
        } catch (Exception e) {
            System.out.println("An error occurred." + " " + "\n\r" + e);
            return false;
        }
    }

    static void find(String directory, String reg) {
        try {
            File dir = new File(directory);
            for (File name : dir.listFiles()) {

                System.out.println(name);
                System.out.println(matchText(reg, readFile(name.getAbsolutePath())));
            }

        } catch (Exception e) {
            System.out.println("An error occurred." + " " + "\n\r" + e);
        }
    }

    static String makeregx(String searchText) {
        try {
            String reg = "";
            String[] sp = searchText.toLowerCase().split(" ");
            for (String item : sp) {
                switch (item) {
                    case "or":
                        reg = reg + "|";
                        break;
                    case "and":
                        reg = reg + "\\s*";
                        break;
                    case "":
                        continue;
                    default:
                        reg = reg + "(" + item + ")";
                        break;
                }
            }
          
            return reg;
        } catch (Exception e) {
            System.out.println("An error occurred." + " " + "\n\r" + e);
            return null;
        }
    }

    public static void main(String[] args) {
        try {
             System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\"+"Welcome"+"////////////////"+"\n\r");
            Scanner in = new Scanner(System.in);
            System.out.println("\\\\Please enter directory address : ");
            String address, searchText;
            address = in.nextLine();
            System.out.println("\\\\Please enter your keywords : ");
            searchText = in.nextLine();
            find(address, makeregx(searchText));
        } catch (Exception e) {
            System.out.println("An error occurred." + " " + "\n\r" + e);
        }

    }

}
