package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;


public class Controller implements EventHandler<javafx.event.ActionEvent> {

                //<!===== BUTTONS =====!>

    //ADDITIONAL STUFF
    @FXML private ToggleButton Night_mode;
    @FXML private AnchorPane anchor;

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
    @FXML private Label operator_Label;

    //VARIABLES
    private Calculus Calculator = new Calculus();
    private String Number = "";
    private String History = "";

    //STYLE SHEETS
    private String Current_StyleSheet = "sample/style.css";
    private String Theme_Default = "sample/style.css";
    private String Theme_Dark = "sample/style_2.css";



    private void solve()
    {
        if(Calculator.getArg_1() != 0 && Calculator.getArg_2() == 0)
        {
            if(Number == "")
            {
                if (Calculator.getOperator() == "/" || Calculator.getOperator() == "*")
                    Calculator.setArg_2(1);
                else if(Calculator.getOperator() == "%")
                    Calculator.setArg_2(Calculator.getArg_1()+1);
                else
                    Calculator.setArg_2(0);
            }
            else
                Calculator.setArg_2(Double.parseDouble(Number));

            history_int_check();

        }
        else if(Calculator.getArg_1() == 0)
        {
            if(Number == "")
                Calculator.setArg_1(0);
            else
                Calculator.setArg_1(Double.parseDouble(Number));
            if (Calculator.getOperator() == "/" || Calculator.getOperator() == "*")
                Calculator.setArg_2(1);
            if(Calculator.getOperator() == "%")
                Calculator.setArg_2(Calculator.getArg_1()+1);
        }

        Number = "";
        Calculator.setArg_1(Calculator.calculate(Calculator.getArg_1(),Calculator.getArg_2(),Calculator.getOperator()));
        Calculator.setArg_2(0);
        if(Calculator.getArg_1() % 1 == 0)
            result_Label.setText(Integer.toString((int)Calculator.getArg_1()));
        else
            result_Label.setText(Double.toString(Calculator.getArg_1()));
        history_Label.setText(History);
    }

    private void history_int_check()
    {
        if(Calculator.getArg_1() % 1 == 0)
        {
            History = (int) Calculator.getArg_1() + Calculator.getOperator();
            if (Calculator.getArg_2() % 1 == 0)
                History += (int) Calculator.getArg_2();
            else
                History += Calculator.getArg_2();
        }
        else
        {
            History = Calculator.getArg_1() + Calculator.getOperator();
            if (Calculator.getArg_2() % 1 == 0)
                History += (int) Calculator.getArg_2();
            else
                History += Calculator.getArg_2();
        }
    }

    //REMOVE LAST CHARACTER FROM THE STRING
    private static String removeLastChar(String str)
    {
        String new_stirng = "";
        if(str.length() != 0)
            new_stirng = str.substring(0, str.length() - 1);
        return new_stirng;
    }
    //INSERT DIGIT INTO NUMEBR
    private void insert_digit(String digit)
    {
        if(Number == "0")
            Number = digit;
        else
            Number += digit;
    }

    @FXML
    public void change_modes(ActionEvent event)
    {
        Scene scene = (Scene)(anchor.getScene());
        if(Night_mode.isSelected())
        {
            scene.getStylesheets().remove(Current_StyleSheet);
            scene.getStylesheets().add(Theme_Dark);
            Current_StyleSheet = Theme_Dark;
            Night_mode.setStyle("-fx-background-color: #e7a937;");
        }
        else
        {
            scene.getStylesheets().remove(Current_StyleSheet);
            scene.getStylesheets().add(Theme_Default);
            Current_StyleSheet = Theme_Default;
            Night_mode.setStyle("-fx-background-color: #bdbdbd;");
        }

    }


    @Override
    public void handle(javafx.event.ActionEvent event) {
        //DIGITS
        if(event.getSource() == one)
        {
            insert_digit("1");
            result_Label.setText(Number);
        }
        if(event.getSource() == two)
        {
            insert_digit("2");
            result_Label.setText(Number);
        }
        if(event.getSource() == three)
        {
            insert_digit("3");
            result_Label.setText(Number);
        }
        if(event.getSource() == four)
        {
            insert_digit("4");
            result_Label.setText(Number);
        }
        if(event.getSource() == five)
        {
            insert_digit("5");
            result_Label.setText(Number);
        }
        if(event.getSource() == six)
        {
            insert_digit("6");
            result_Label.setText(Number);
        }
        if(event.getSource() == seven)
        {
            insert_digit("7");
            result_Label.setText(Number);
        }
        if(event.getSource() == eight)
        {
            insert_digit("8");
            result_Label.setText(Number);
        }
        if(event.getSource() == nine)
        {
            insert_digit("9");
            result_Label.setText(Number);
        }
        if(event.getSource() == zero)
        {
            insert_digit("0");
            result_Label.setText(Number);
        }
        if(event.getSource() == coma)
        {
            Number +=".";
            result_Label.setText(Number);
        }


        //SIGNS
        if(event.getSource() == equals)
        {
            if(Number == "")
                Calculator.setArg_2(0);
            else
                Calculator.setArg_2(Double.parseDouble(Number));
            Number = "";
            Calculator.setArg_1(Calculator.calculate(Calculator.getArg_1(),Calculator.getArg_2(),Calculator.getOperator()));

            history_int_check();

            Calculator.setArg_2(0);
            if(Calculator.getArg_1() % 1 == 0)
                result_Label.setText(Integer.toString((int)Calculator.getArg_1()));
            else
                result_Label.setText(Double.toString(Calculator.getArg_1()));
            history_Label.setText(History);
        }
        if(event.getSource() == plus)
        {
            Calculator.setOperator("+");
            solve();
            operator_Label.setText("+");
        }

        if(event.getSource() == minus)
        {
            Calculator.setOperator("-");
            solve();
            operator_Label.setText("-");
        }
        if(event.getSource() == mult)
        {
            Calculator.setOperator("*");
            solve();
            operator_Label.setText("*");
        }
        if(event.getSource() == div)
        {
            Calculator.setOperator("/");
            solve();
            operator_Label.setText("/");
        }
        if(event.getSource() == mod)
        {
            Calculator.setOperator("%");
            solve();
            operator_Label.setText("%");
        }
        if(event.getSource() == root)
        {
            Calculator.setOperator("sqrt");
            solve();
            operator_Label.setText("√");
        }
        if(event.getSource() == sqr)
        {
            Calculator.setOperator("sqr");
            solve();
            operator_Label.setText("X²");
        }
        if(event.getSource() == neg)
        {
            Calculator.setOperator("neg");
            solve();
            operator_Label.setText("+/-");
        }
        if(event.getSource() == open_par)
        {
            Calculator.setOperator("+");
        }
        if(event.getSource() == close_par)
        {
            Calculator.setOperator("+");
        }



        //CONTROLS
        if(event.getSource() == c)
        {
            Calculator.setOperator("");
            Calculator.setArg_1(0);
            Calculator.setArg_2(0);
            operator_Label.setText("");
            Number = "0";
            History = "0";
            result_Label.setText(Number);
            history_Label.setText(History);
        }
        if(event.getSource() == ce)
        {
            Number = "0";
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
