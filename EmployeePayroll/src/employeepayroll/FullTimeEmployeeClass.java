package employeepayroll;

public class FullTimeEmployeeClass
{

    //Declare Variables
    private double bonus = 0;
    private double salary = 0;
    private double grossPay = 0;
//----------------------------------------------------------------------------//
    // default Constructor

    public FullTimeEmployeeClass()
    {

    }

//----------------------------------------------------------------------------// 
    //Calculate employees bonus
    public void calculateBonus()
    {
        this.bonus = 0.1 * this.salary;
    }
//----------------------------------------------------------------------------//
    //Calculate grossPay of full-time employee

    public void calculateGrossPay()
    {
        this.grossPay = getBonus() + getSalary();
    }
//----------------------------------------------------------------------------//
    //Setter

    public void setSalary(double income)
    {
        this.salary = income;
    }
//----------------------------------------------------------------------------//    
    //Getters

    public double getBonus()
    {
        return this.bonus;
    }

    public double getSalary()
    {
        return this.salary;
    }

    public double getFullGrossPay()
    {
        calculateGrossPay();
        return this.grossPay;
    }
//----------------------------------------------------------------------------//    
}
//-------------END OF FILE----------------------------------------------------//
