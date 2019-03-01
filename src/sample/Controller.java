package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class Controller implements EventHandler<javafx.event.ActionEvent> {

                //<!===== BUTTONS =====!>

    //CALCULATOR NUMBERS
    @FXML private Button one;
    @FXML private Button two;
    @FXML private Button three;
    @FXML private Button four;
    @FXML private Button five;
    @FXML private Button six;
    @FXML private Button seven;
    @FXML private Button eight;
    @FXML private Button nine;
    @FXML private Button zero;
    @FXML private Button coma;

    //CALCULATOR OPERATORS
    @FXML private Button plus;
    @FXML private Button minus;
    @FXML private Button mult;
    @FXML private Button div;
    @FXML private Button mod;
    @FXML private Button equals;
    @FXML private Button root;
    @FXML private Button sqr;
    @FXML private Button neg;
    @FXML private Button del;
    @FXML private Button c;
    @FXML private Button ce;
    @FXML private Button open_par;
    @FXML private Button close_par;

    //MEMORY BUTTONS
    @FXML private Button MR;
    @FXML private Button MC;
    @FXML private Button M_minus;
    @FXML private Button M_plus;


    //LABELS
    @FXML private Label history_Label;
    @FXML private Label result_Label;

    //VARIABLES
    private Calculus Calculator = new Calculus();
    private String Number = "";

    private void Check_calculate()
    {
        if(Calculator.getArg_1() == 0)
        {
            Calculator.setArg_1(Double.parseDouble(Number));
            Number="0";
        }
        else
        {
            Calculator.setArg_2(Double.parseDouble(Number));
            Number="0";
        }

        if(Calculator.getArg_1() != 0 && Calculator.getArg_2() != 0)
        {
            Calculator.setResult(Calculator.calculate(Calculator.getArg_1(),Calculator.getArg_2(),Calculator.getOperator()));
            if(Calculator.getResult()%1 == 0)
                result_Label.setText(Integer.toString((int) Calculator.getResult()));
            else
                result_Label.setText(Double.toString(Calculator.getResult()));
            Calculator.setArg_1(Calculator.getResult());
            Calculator.setArg_2(0);
        }
    }

    private static String removeLastChar(String str) {
        String new_stirng = "";
        if(str.length() != 0)
            new_stirng = str.substring(0, str.length() - 1);
        return new_stirng;
    }


    @Override
    public void handle(javafx.event.ActionEvent event) {
        //DIGITS

        if(event.getSource() == one)
        {
            if(Number == "0")
                    Number = "1";
            else
                Number +="1";
            result_Label.setText(Number);
        }
        if(event.getSource() == two)
        {
            if(Number == "0")
                Number = "2";
            else
            Number +="2";
            result_Label.setText(Number);
        }
        if(event.getSource() == three)
        {
            if(Number == "0")
                Number = "3";
            else
                Number +="3";
            result_Label.setText(Number);
        }
        if(event.getSource() == four)
        {
            if(Number == "0")
                Number = "4";
            else
                Number +="4";
            result_Label.setText(Number);
        }
        if(event.getSource() == five)
        {
            if(Number == "0")
                Number = "5";
            else
                Number +="5";
            result_Label.setText(Number);
        }
        if(event.getSource() == six)
        {
            if(Number == "0")
                Number = "6";
            else
                Number +="6";
            result_Label.setText(Number);
        }
        if(event.getSource() == seven)
        {
            if(Number == "0")
                Number = "7";
            else
                Number +="7";
            result_Label.setText(Number);
        }
        if(event.getSource() == eight)
        {
            if(Number == "0")
                Number = "8";
            else
                Number +="8";
            result_Label.setText(Number);
        }
        if(event.getSource() == nine)
        {
            if(Number == "0")
                Number = "9";
            else
                Number +="9";
            result_Label.setText(Number);
        }
        if(event.getSource() == zero)
        {
            if(Number != "0")
                Number +="0";
            result_Label.setText(Number);
        }
        if(event.getSource() == coma)
        {
            Number +=".";
            result_Label.setText(Number);
        }


        //SIGNS
        if(event.getSource() == plus)
        {
            if(Calculator.getOperator() != "")
                Check_calculate();
            Calculator.setOperator("+");
            Check_calculate();
        }
        if(event.getSource() == minus)
        {
            if(Calculator.getOperator() != "")
                Check_calculate();
            Calculator.setOperator("-");
            Check_calculate();
        }
        if(event.getSource() == mult)
        {
            if(Calculator.getOperator() != "")
                Check_calculate();
            Calculator.setOperator("*");
            Check_calculate();
        }
        if(event.getSource() == div)
        {
            if(Calculator.getOperator() != "")
                Check_calculate();
            Calculator.setOperator("/");
            Check_calculate();
        }
        if(event.getSource() == mod)
        {
            if(Calculator.getOperator() != "")
                Check_calculate();
            Calculator.setOperator("%");
            Check_calculate();
        }
        if(event.getSource() == root)
        {
            Calculator.setOperator("sqrt");


        }
        if(event.getSource() == sqr)
        {
            Calculator.setOperator("sqr");
        }
        if(event.getSource() == neg)
        {
            Calculator.setOperator("+");
        }
        if(event.getSource() == open_par)
        {
            Calculator.setOperator("+");
        }
        if(event.getSource() == close_par)
        {
            Calculator.setOperator("+");
        }
        if(event.getSource() == equals)
        {
            if(Number != "")
                Check_calculate();
            Calculator.setArg_1(Calculator.getResult());
            Calculator.setArg_2(0);
            Calculator.setOperator("");
        }


        //CONTROLS
        if(event.getSource() == c)
        {
            Calculator.setOperator("");
            Calculator.setArg_1(0);
            Calculator.setArg_2(0);
            Number = "";
            result_Label.setText("0");
        }
        if(event.getSource() == ce)
        {
            Number = "";
            result_Label.setText(Number);
        }

        if(event.getSource() == del)
        {
            if(Number == "0")
            {
                Calculator.setArg_1(0);
                result_Label.setText("0");
            }
            Number = removeLastChar(Number);
            result_Label.setText(Number);
        }


        //MEMORY
        if(event.getSource() == MR)
            System.out.println("one");
        if(event.getSource() == MC)
            System.out.println("one");
        if(event.getSource() == M_minus)
            System.out.println("one");
        if(event.getSource() == M_plus)
            System.out.println("one");


    }
}
