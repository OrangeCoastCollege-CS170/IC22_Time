package edu.orangecoastcollege.sbadajoz.ic22;


import java.util.Scanner;

/*
Badajoz, Seve
CS A170
November 18, 2016

IC22
*/
public class Time {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userIn;
        String[] time;
        while(true) {
            System.out.println("\nPlease enter a time (type exit to exit): ");
            userIn = input.nextLine();
            if(userIn.toLowerCase().equals("exit")) break;
            time = userIn.split("[: ]");
            try {
                if (Integer.valueOf(time[0]) < 1 || Integer.valueOf(time[0]) > 12) throw new InvalidHourException("Please enter an hour between the hours 1 and 12");
                try {
                    if (Integer.valueOf(time[1]) < 1 || Integer.valueOf(time[1]) > 60) throw new InvalidMinuteException("Please enter a minute between the minutes 1 and 60");
                    try {
                        if(!(time[2].equals("AM") || time[2].equals("PM"))) throw new InvalidMeridiemException("Please enter a correct Meridiem(AM or PM)");
                        System.out.println("User entered a valid time");
                    } catch(InvalidMeridiemException s) {
                        System.out.println(s.getMessage());                    }
                } catch(InvalidMinuteException s) {
                    System.out.println(s.getMessage());
                }
            } catch(InvalidHourException s) {
                System.out.println(s.getMessage());            }



        }
    }
}
