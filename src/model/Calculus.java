package model;

public class Calculus {

    //--------- VARIABLES
    private double arg_1;
    private double arg_2;
    private double M_arg_1;
    private double result;
    private String operator;

    //--------- GETTERS & SETTERS
//ARGUMENT 1
    public double getArg_1() { return arg_1; }
    public void setArg_1(double arg_1) { this.arg_1 = arg_1; }
//ARGUMENT 2
    public double getArg_2() { return arg_2; }
    public void setArg_2(double arg_2) { this.arg_2 = arg_2; }
//M ARGUMENT 1
    public double getMArg_1() { return M_arg_1; }
    public void setMArg_1(double arg_1) { this.M_arg_1 = arg_1; }
//RESULT
    public double getResult() { return result; }
    public void setResult(double result) { this.result = result; }
//OPERATOR
    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }

    //CONSTRUCTOR
    public Calculus() {
        this.arg_1 = 0;
        this.arg_2 = 0;
        this.M_arg_1 = 0;
        this.result = 0;
        this.operator = "";
    }

    /* ta funckja bedzie aktywowana gdy 'user' nacisnie '='*/
    //--------- OPERATIONS
    public double calculate(double arg_1, double arg_2, String operator )
    {
        switch(operator)
        {
            case "+":
                    return arg_1+arg_2;
            case "-":
                    return arg_1-arg_2;
            case "*":
                    return arg_1*arg_2;
            case "/":
                return arg_1/arg_2;
            case "%":
                    return arg_1%arg_2;
            case "sqrt":
                    return Math.sqrt(arg_1);
            case "sqr":
                    return arg_1*arg_1;
            case "neg":
                    return arg_1*(-1);
            case "factorial":
            {
                int result = 1;
                for(int i = 1; i <= (int) arg_1; i++)
                    result *= i;
                return result;
            }
            case "log":
                return Math.log(arg_1);
            case "onedivx":
                return 1/arg_1;
            case "xpowern":
                return Math.pow(arg_1, arg_2);
            case "sin":
                return Math.sin(arg_1);
            case "cos":
                return Math.cos(arg_1);
            case "tan":
                return Math.tan(arg_1);
            case "ctg":
                return 1/Math.tan(arg_1);
        }
        return  0;
    }
}
