package com.programmingDunce.models;

/**
 * Holds Day month and year information.
 *
 * Introduced in video 2
 *
 * Implemented the Comparable Interface for video 5
 */
public class Date implements Comparable<Date>
{
    /**
     * Bytes used to store month and day as that is all that is needed
     */
    private byte month, day;
    /**
     * Use a short for the year. It will be a long time before we would need an int
     */
    private short year;

    /**
     * Demonstrate the use of the static keyword by creating a basic Date
     */
    public static final Date EPOCH = new Date();

    /**
     * Default constructor, that sets it to the Epoch time
     */
    public Date()
    {
        month = 1;
        day = 1;
        year = 1970;
    }

    /**
     * Retrieves the current month
     * @return byte - the month set
     */
    public byte getMonth(){
        return month;
    }

    /**
     * Retrieves the current day
     * @return byte - the day set
     */
    public byte getDay()
    {
        return day;
    }
    /**
     * Retrieves the current Year
     * @return short - the year set
     */
    public short getYear()
    {
        return year;
    }

    /**
     * Sets the year. One of the simplest set methods in this class as there are no known restrictions
     * @param year - the year to set it to
     */
    public void setYear(short year)
    {
        this.year = year;
    }

    /**
     * Sets the month of the Date, using a String representation
     * @param month the month in string form
     */
    public void setMonth(String month)
    {
        switch(month.toLowerCase())
        {
            case "january":
                setMonth((byte)1);
                break;
            case "february":
                setMonth((byte)2);
                break;
            case "march":
                setMonth((byte)3);
                break;
            case "april":
                setMonth((byte)4);
                break;
            case "may":
                setMonth((byte)5);
                break;
            case "june":
                setMonth((byte)6);
                break;
            case "july":
                setMonth((byte)7);
                break;
            case "august":
                setMonth((byte)8);
                break;
            case "september":
                setMonth((byte)9);
                break;
            case "october":
                setMonth((byte)10);
                break;
            case "november":
                setMonth((byte)11);
                break;
            case "december":
                setMonth((byte)12);
                break;
        }
    }

    /**
     * Sets the month of the Date, using a byte representation
     * @param month the month in byte form
     */
    public void setMonth(byte month)
    {
        // If "month" is out of bounds, don't even consider it
        if(month == 0 || month > 12)
            return;

        // if the month is february
        if(month == 2)
        {
            if(day <= 28 || (day == 29 && (year % 4) == 0))
                this.month = month;
            return;
        }

        // if the day is 31, than certain months can be applied
        if(day == 31)
        {
            switch(month)
            {
                case 1: // January
                case 3: // March
                case 5: // May
                case 7: // July
                case 8: // August
                case 10: // October
                case 12: // December
                    this.month = month;
            }
            return;
        }

        // Otherwise, set the month (Date should be no higher than 30 at this point
        this.month = month;
    }

    /**
     * Sets the day of the Date
     * @param day - the day to set
     */
    public void setDay(byte day)
    {
        // if Day is 0, return without setting
        if(day == 0)
            return;

        byte max = 0;

        // need to set the max the date can be based off of the month
        switch(month)
        {
            // Months with 31 days
            case 1: // January
            case 3: // March
            case 5: // May
            case 7: // July
            case 8: // August
            case 10: // October
            case 12: // December
                max = 31;
                break;
                // Months with 30 days
            case 4: // April
            case 6: // June
            case 9: // September
            case 11: // November
                max = 30;
                break;
            // February
            case 2:
                if(year % 4 == 0)
                    max = 29; // Leap year
                else
                    max = 28; // Every other year
        }

        if(day > max)
            return;
        this.day = day;
    }

    /**
     * Returns a String Representation of this object
     * from Object.toString
     * @return String representation
     */
    @Override
    public String toString()
    {
        String month = "";
        switch(this.month)
        {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
        }

        return "Date: " + day + "." + month + "." + year;
    }

    /**
     * Assesses whether this Date is equal to that of another Date
     * @param o the object to compare this to
     * @return boolean explaining whether o is "equal" to this date or not
     */
    @Override
    public boolean equals(Object o)
    {
        // If param is not a Date, assume not equals
        if (o instanceof Date)
        {
            // Make the cast, now that we know it is safe
            Date dateObj = (Date)o;

            // Report whether the fields are equal
            return dateObj.day == this.day &&
                    dateObj.month == this.month &&
                    dateObj.year == this.year;
        }
        return false;
    }

    /**
     * Compares this date to another
     * Implements Comparable (video 5)
     * @param d the date to compare this to
     * @return int representing the compare result
     */
    public int compareTo(Date d)
    {
        int ret = year - d.year;

        if(ret == 0) // if years are equal, look to the month
            ret = month - d.month;

        if (ret == 0) // If months are equal, lok to the day
            ret = day - d.day;

        if(ret != 0)
            return (ret / Math.abs(ret)); // Normalize return value, but not if it's zero
        return ret;
    }
}
