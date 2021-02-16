 
/**
 * The ClockDisplay class implements a digital clock display for a meridian clock
 * 
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Wayne
 * @version 2020 02 15
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    public boolean get24HourDisplay()
    {   int hour = 0;
        boolean military = false;
        if(hours.getValue() > 12){
        military = true;
            hour = hours.getValue() % 12;
        
        setTime(hour,minutes.getValue());
        
        
    }
    return military;
}
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
             if(get24HourDisplay()){
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue()+ "PM";
    }
    else{
        displayString = hours.getDisplayValue() + ":" + 
                        minutes.getDisplayValue()+ "AM";
}
    }
}
