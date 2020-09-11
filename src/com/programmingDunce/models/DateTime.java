package com.programmingDunce.models;

/**
 * Extends the Date class to hold hours, minutes, and seconds
 *
 * Introduced in Video 3
 */
public class DateTime extends Date
{
    /**
     * Just store the basic attributes in bytes as none of them will go above 60 (let alone 255)
     */
    byte hours, minutes, seconds;

    /**
     * Sets a basic DateTime Object
     */
    public DateTime()
    {
        super();
        hours = minutes = seconds = 0;
    }

    /**
     * Retrieves the hours set
     * @return the hours of this object
     */
    public byte getHours()
    {
        return hours;
    }

    /**
     * Retrieves the minutes set
     * @return the minutes of this object
     */
    public byte getMinutes()
    {
        return minutes;
    }

    /**
     * Retrieves the seconds set
     * @return the seconds of this object
     */
    public byte getSeconds()
    {
        return seconds;
    }

    /**
     * Sets the current hours
     * @param hours
     */
    public void setHours(byte hours)
    {
        if (hours < 24 && hours >= 0) this.hours = hours;
    }

    /**
     * Sets the current minutes
     * @param minutes
     */
    public void setMinutes(byte minutes)
    {
        if(minutes < 60 && minutes >= 0) this.minutes = minutes;
    }

    /**
     * Sets the current seconds
     * @param seconds
     */
    public void setSeconds(byte seconds)
    {
        if(seconds < 60 && seconds >= 0) this.seconds = seconds;
    }

    /**
     * Reports the DateTime in String form
     * @return String representation of the DateTime object
     */
    @Override
    public String toString()
    {
        String strMinute = (minutes < 10) ? String.format("0%d", minutes) : String.format("%d", minutes);
        String strSecond = (seconds < 10) ? String.format("0%d", seconds) : String.format("%d", seconds);
        return super.toString() + " Time: " + hours + ":" + strMinute + ":" + strSecond;
    }
}
