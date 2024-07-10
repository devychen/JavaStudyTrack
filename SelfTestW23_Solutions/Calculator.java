public class Calculator
{
    
    private double result;
    
    public Calculator()
    {
        result = 0;
    }
    
    public Calculator(double aResult)
    {
        result = aResult;
    }
    
    public double getResult()
    {
        return result;
    }
    
    public void add(double x, double y)
    {
        result = x + y;
    }
    
    public void add(double x)
    {
        result += x;
    }
    
    public void subtract(double x, double y)
    {
        result = x - y;
    }
    
    public void subtract(double x)
    {
        result -= x;
    }
    
    public void mult(double x, double y)
    {
        result = x * y;
    }
    
    public void mult(double x)
    {
        result *= x;
    }
    
    public void div(double x, double y)
    {
        result = x / y;
    }
    
    public void div(double x)
    {
        result /= x;
    }
    
    public static void main(String[] args)
    {
        Calculator c = new Calculator();
        c.add(5, 10);
        System.out.println(c.getResult());
        c.mult(10);
        System.out.println(c.getResult());
        c.div(0);
        System.out.println(c.getResult());
    }
}