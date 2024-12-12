package employeepayroll;

public class PartTimeEmployeeClass
{

    //Declare variables and set as 0 to display default
    private int hours = 0;
    private double hourlyRate = 0;
    private double grossPay = 0;
//----------------------------------------------------------------------------// 
    //Default Constructor

    public PartTimeEmployeeClass()
    {

    }

//----------------------------------------------------------------------------// 
    //Calculate Gross Pay of part-time employee 
    private void calculateGrossPay()
    {
        this.grossPay = this.hours * this.hourlyRate;

    }
//----------------------------------------------------------------------------//
    //Setters

    public void setHours(int hour)
    {
        this.hours = hour;
    }

    public void setRate(double rate)
    {
        this.hourlyRate = rate;
    }
//----------------------------------------------------------------------------//
    //Getters

    public int getHours()
    {
        return this.hours;
    }

    public double getPartGrossPay()
    {
        calculateGrossPay();
        return this.grossPay;
    }

    public double getHourlyRate()
    {
        return this.hourlyRate;
    }

}
//-------------END OF FILE----------------------------------------------------//
