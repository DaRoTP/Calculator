package sample;

public class Calculus {

    //--------- VARIABLES
    private double arg_1;
    private double arg_2;
    private double result;
    private String operator;

    //--------- GETTERS & SETTERS
//ARGUMENT 1
    public double getArg_1() { return arg_1; }
    public void setArg_1(double arg_1) { this.arg_1 = arg_1; }
//ARGUMENT 2
    public double getArg_2() { return arg_2; }
    public void setArg_2(double arg_2) { this.arg_2 = arg_2; }
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
        }
        return  0;
    }
}
