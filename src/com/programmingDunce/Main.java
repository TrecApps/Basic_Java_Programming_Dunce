package com.programmingDunce;

import com.programmingDunce.models.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * Main Class for Demonstrating Java concepts
 */
public class Main {

    /**
     * the main method, the entry point of all Java programs
     * @param args the arguments provided to a Java program
     */
    public static void main(String[] args) {

        // Start of video 2 Content
        // We basically use a custom Date class and create instances of it
        Date date = new Date();

        System.out.println("Date created: " + date);

        // Set Date to February
        date.setMonth((byte)2);
        System.out.println("Date set to February: " + date);

        // Attempt to set day to 30th
        date.setDay((byte)30);
        System.out.println("Date set to February 30th: " + date);

        // Attempt to set Month to July
        date.setMonth((byte)7);
        System.out.println("Date set to July: " + date);

        // Attempt to set day to 30th
        date.setDay((byte)30);
        System.out.println("Date set to July 30th: " + date);


        // Start of Video 3 Content
        // Here we start to use subclasses

        Date tDate = new DateTime();

        tDate.setMonth((byte)9);
        tDate.setDay((byte)23);
        tDate.setYear((short)1993);

        System.out.println("Setting a Date variable with a DateTime object: " + tDate);

        DateTime time = new DateTime();

        time.setHours((byte)52);
        System.out.println("Attempted to set a time to 52 hours! Result: " + time);

        time.setHours((byte) 13);
        System.out.println("Attempted to set a time to 52 hours! Result: " + time);


        // Start of video 4 content
        // We explore the prospect of null and throwing exceptions (and errors)

        createNullException(time);
        createNullException(null);

        createException(time);
        createException(null);

        // This method has been commented out because it is a perpetual recursive method
        // meaning it will eventually cause a StackOverFlowError to be thrown.
        // Uncomment this code if you want your program to crash here
        // createStackOverflow(0);

        // Start of video 5 content
        // Here, we explore comparing objects, by assessing equality and by comparing them.
        System.out.println("\n\n\n");

        demoEqOpOnDates();

        System.out.println("\n\n\n");

        demoEqMethodOnDates();
    }

    /**
     * Demonstrates comparing two seperate objects using the equality operator
     * We expect them to be unequal despite having the same field values
     */
    static void demoEqOpOnDates()
    {
        Date d1 = new Date();
        Date d2 = new Date();

        d1.setDay((byte)23);
        d2.setDay((byte)23);

        d1.setMonth((byte)3);
        d2.setMonth((byte)3);

        d1.setYear((short)1999);
        d2.setYear((short)1999);

        if(d1 == d2)
            System.out.println("The two dates are equal!");
        else
            System.out.println("The two dates are NOT equal!");
    }

    /**
     * Demonstrates comparing two objects using the equals method introduced
     * by the Object class. Overridden by "our" date class, the equals method
     * should return true, when the fields are equal
     */
    static void demoEqMethodOnDates()
    {
        Date d1 = new Date();
        Date d2 = new Date();

        d1.setDay((byte)23);
        d2.setDay((byte)23);

        d1.setMonth((byte)3);
        d2.setMonth((byte)3);

        d1.setYear((short)1999);
        d2.setYear((short)1999);

        if(d1.equals(d2))
            System.out.println("The two dates are equal!");
        else
            System.out.println("The two dates are NOT equal!");
    }

    /**
     * Demonstrates the response to a NullPointerException, which can be thrown if the
     * parameter is null.
     * @param d - the date object to call methods on
     */
    static void createNullException(Date d)
    {
        try
        {
            // Here we don't do a NULL check
            var day = d.getDay();   // if d is null, we'll get a "NullPointerException
            d.setDay(day);
        }
        catch(NullPointerException e)
        {
            System.out.println("Null Pointer Exception caught");
        }
        catch(Exception e) // A Null pointer exception is an exception, but would be caught by the first catch block
        {
            System.out.println("Exception Caught");
        }
        finally
        {
            System.out.println("Finally Block Running!");
        }
    }

    /**
     * Demonstrates the response to a NullPointerException, which can be thrown if the
     * parameter is null. This method catches the NullPointerException as a regular Exception
     * @param d - the date object to call methods on
     */
    static void createException(Date d)
    {
        try
        {
            // Here we don't do a NULL check
            var day = d.getDay();
            d.setDay(day);
        }
        catch(Exception e) // A Null pointer exception is an exception, but would be caught by the first catch block
        {
            System.out.println("Exception Caught");
        }
        // catch(NullPointerException e)
        // {
        //    System.out.println("Null Pointer Exception caught");
        // }
        finally
        {
            System.out.println("Finally Block Running!");
        }
    }

    /**
     * Perpetually recursive method.
     * WARNING: Calling this method WILL create a StackOverFlowError
     * @param s - some number to process
     */
    static void createStackOverflow(int s)
    {
        System.out.println("Call " + s);
        int e = 9;
        createStackOverflow(s+1);
    }

    /**
     * Demonstrates Sorting using Comparable and Comparators
     * @param dates list of dates to sort.
     */
    static void streamSort(Date dates[])
    {
        Object[] natural = Arrays.stream(dates).sorted().toArray();

        Object[] byYear = Arrays.stream(dates).sorted(new DateCompareYear()).toArray();
        Object[] byMonth = Arrays.stream(dates).sorted(new DateCompareMonth()).toArray();
        Object[] byDay = Arrays.stream(dates).sorted(new DateCompareDay()).toArray();

    }
}
