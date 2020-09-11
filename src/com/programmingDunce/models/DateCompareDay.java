package com.programmingDunce.models;

import java.util.Comparator;
/**
 * Compares the Date Class by Day
 */
public class DateCompareDay implements Comparator<Date>
{
    /**
     * Compares the Dates by Day
     * @param d1 the first Date object
     * @param d2 the second Date object
     * @return how these items compare
     */
    public int compare(Date d1, Date d2)
    {
        // We're supposed to return negative if the first object is "less than"
        // the second object and vice versa.
        return d1.getDay() - d2.getDay();
    }
}
