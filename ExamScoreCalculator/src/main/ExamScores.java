package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Umar Rehman
 */
public final class ExamScores {

    /**
     * @param args the command line arguments
     */
    private File inputFile;
    private ArrayList<Integer> scores;
    private ArrayList<Integer> asscendingValues;
    private int TOTAL = 0;
    private String valuesString="";
    
    public ExamScores(String filePath) {
        scores = new ArrayList<>();
        asscendingValues = new ArrayList<>();
        String token;
        try {
            inputFile = new File(filePath);
            Scanner reader = new Scanner(inputFile);
            // reading scores from Exam_Scores.txt file 
            while (reader.hasNextLine()) {
                token=reader.next();
                if(Pattern.matches("[0-9]+", token)){
                    scores.add(Integer.parseInt(token));
                }
                
            }
            // displaying the Scores
            scores.forEach(action -> {
                valuesString+=action+" , ";
            });
            // removing last common from string
            valuesString=valuesString.substring(0, valuesString.length()-1);
            System.out.println("The Scores read from File are");
            System.out.println(valuesString);
            getTotal(); // getting the total of array values 
            getAverage(); // getting the average of array values
            getLargeValue(); // getting the large value of arraay 
            getSmallestValue(); // getting the smallest value from array 
            getMiddleValue(); // getting the middle value of array
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getTotal() {
        try {
            TOTAL = 0;
            scores.forEach(value -> {
                TOTAL += value;
            });
            System.out.println("Total Of Array value is  " + TOTAL);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void getAverage() {
        try {
            TOTAL = 0;
            scores.forEach(value -> {
                TOTAL += value;
            });
            System.out.println("Average Of Array value is  " + (float) (TOTAL / scores.size()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void getLargeValue() {
        try {
            Object values[] = scores.toArray();
            int largeValue = 0;
            largeValue = (int) values[0];
            for (int i = 1; i < scores.size(); i++) {
                if ((int) values[i] > largeValue) {
                    largeValue = (int) values[i];
                }
            }
            System.out.println("The largest value in Array Is  " + largeValue);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void getSmallestValue() {
        try {
            Object values[] = scores.toArray();
            int smallest = 0;
            smallest = (int) values[0];
            for (int i = 1; i < scores.size(); i++) {
                if ((int) values[i] < smallest) {
                    smallest = (int) values[i];
                }
            }
            System.out.println("The Smallest value in Array Is  " + smallest);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void getMiddleValue() {
        int[] values = new int[scores.size()];
        int middleValue=0;
        try {
            for (int i = 0; i < scores.size(); i++) {
                values[i] = scores.get(i);
            }
            Arrays.sort(values);
            if (scores.size() % 2 == 1) {
                middleValue = values[(scores.size() + 1) / 2 - 1];
            } else {
                middleValue = (values[scores.size() / 2 - 1] + values[scores.size() / 2]) / 2;
            }
            System.out.println("The Middle Value Of Array is  :" + middleValue);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        if (args.length > 0) {
            System.out.println(args[0]);
            new ExamScores(args[0]);
        }else{
            System.err.println("Need a Exam_Scores.txt file path");
        }
            
    }

}
