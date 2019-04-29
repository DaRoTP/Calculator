package controller;

import model.Calculus;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements EventHandler<javafx.event.ActionEvent>, Initializable {

                //<!===== BUTTONS =====!>

    //ADDITIONAL STUFF
    @FXML private ToggleButton Night_mode;
    @FXML private Button Extend;
    @FXML private Button Extend2;
    @FXML private AnchorPane anchor;
    @FXML private ChoiceBox<String> Theme_choice = new ChoiceBox<>();

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
    @FXML private Button pi;

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
    @FXML private Button factorial;
    @FXML private Button log;
    @FXML private Button onedivx;
    @FXML private Button xpowern;
    @FXML private Button sin;
    @FXML private Button cos;
    @FXML private Button tan;
    @FXML private Button ctg;
    @FXML private Button hex;
    @FXML private Button dec;
    @FXML private Button oct;
    @FXML private Button bin;

    //MEMORY BUTTONS
    @FXML private Button MR;
    @FXML private Button MC;
    @FXML private Button M_minus;
    @FXML private Button M_plus;

    //LABELS
    @FXML private Label memory_Label;
    @FXML private Label result_Label;
    @FXML private Label operator_Label;

    //IMAGES
    private Image lightbulb_on = new Image("view/images/light_bulb.png");
    private Image lightbulb_off = new Image("view/images/light_bulb_off.png");

    //IMAGEVIEW
    @FXML private ImageView light_bulb;
    //VARIABLES
    private Calculus Calculator = new Calculus();
    private String Number = "";

    //STYLE SHEETS
    private String Current_StyleSheet = "view/stylesheets/style.css";
    private String Theme_Default = "view/stylesheets/style.css";
    private String Theme_Dark = "view/stylesheets/style_2.css";
    private String Theme_Pink = "view/stylesheets/style_3.css";
    private String Theme_Red = "view/stylesheets/style_4.css";
    private String ThemeName_temp ="";


    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        Theme_choice.getItems().add("NIGHT MODE");
        Theme_choice.getItems().add("DEEP PINK");
        Theme_choice.getItems().add("FIERY RED");
        Theme_choice.getItems().add("DEFAULT");
        Theme_choice.getSelectionModel().select("DEFAULT");

        //Listen Fore Selection changes
        /*uses "change_themes" function, changes stylesheets to the one that is chosen*/
        Theme_choice.getSelectionModel().selectedItemProperty().addListener( (v,OldValue,NewValue) -> change_themes(NewValue));
    }

    //SCENE EXTENDED
    /* responsible for changing scenes from standardCalculator.xml to extendedCalculator.xml also applying all needed options like stylesheet*/
    public void ChangeScene_extended(ActionEvent event) throws IOException {
        Parent extended_calculator = FXMLLoader.load(getClass().getResource("/view/extendedCalculator.fxml"));
        Scene scene = new Scene(extended_calculator);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        scene.getStylesheets().clear();
        scene.getStylesheets().add(Current_StyleSheet);
    }

    //SCENE STANDARD
    /* responsible for changing scenes from extendedCalculator.xml to sample.xml also applying all needed options like stylesheet*/
    public void ChangeScene_standard(ActionEvent event) throws IOException {
        Parent extended_calculator1 = FXMLLoader.load(getClass().getResource("/view/standardCalculator.fxml"));
        Scene scene = new Scene(extended_calculator1);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        scene.getStylesheets().clear();
        scene.getStylesheets().add(Current_StyleSheet);
    }

    //CHANGE MODES
    /* changes mode to Night-Mode - changes stylesheet from Current to Dark Theme and vice versa*/ //*****STILL IS BUGGY - NEEDS FIXING
    @FXML
    public void change_modes(ActionEvent event)
    {
        Scene scene = anchor.getScene();
        if(Night_mode.isSelected())
        {
            scene.getStylesheets().removeAll("DEEP PINK","FIERY RED");
            Theme_choice.getSelectionModel().select("NIGHT MODE");
            Theme_choice.getSelectionModel().selectedItemProperty().addListener( (v,OldValue,NewValue) -> ThemeName_temp = OldValue);
            light_bulb.setImage(lightbulb_on);
        }
        else
        {
            scene.getStylesheets().removeAll("DEEP PINK","FIERY RED");
            Theme_choice.getSelectionModel().select(ThemeName_temp);
            light_bulb.setImage(lightbulb_off);
        }
    }

    //CHNAGE THEME
    /* changes stylesheets according to what the user has chosen in the choice-box
    * - removes a stylesheet that is currently applied on the scene and changes to the chosen one*/
    public void change_themes(String Theme_name)
    {
        Scene scene = anchor.getScene();
        switch(Theme_name)
        {
            case "NIGHT MODE":
            {
                scene.getStylesheets().remove(Current_StyleSheet);
                scene.getStylesheets().add(Theme_Dark);
                Current_StyleSheet = Theme_Dark;
            }
            break;
            case "DEEP PINK":
            {
                scene.getStylesheets().remove(Current_StyleSheet);
                scene.getStylesheets().add(Theme_Pink);
                Current_StyleSheet = Theme_Pink;
            }
            break;
            case "FIERY RED":
            {
                scene.getStylesheets().remove(Current_StyleSheet);
                scene.getStylesheets().add(Theme_Red);
                Current_StyleSheet = Theme_Red;
            }
            break;
            default:
            {
                scene.getStylesheets().remove(Current_StyleSheet);
                scene.getStylesheets().add(Theme_Default);
                Current_StyleSheet = Theme_Default;
            }
        }
    }

    //SOLVE PROBLEM
    /* function takes all the values from object of the class "Calculus" and resolves the problem accordingly*/
    private void solve()
    {
        //if argument 1 is already set - set argument 2
        if(Calculator.getArg_1() != 0 && Calculator.getArg_2() == 0)
        {
            if(Number == "")
            {
                if (Calculator.getOperator() == "/" || Calculator.getOperator() == "*" || Calculator.getOperator() == "xpowern")
                    Calculator.setArg_2(1);
                /* if operator  is % we add +1 to the argument_1 because if arg_1 = 22 then 22 % 23 = 22*/
                else if(Calculator.getOperator() == "%")
                    Calculator.setArg_2(Calculator.getArg_1()+1);
                else
                    Calculator.setArg_2(0);
            }
            else
                Calculator.setArg_2(Double.parseDouble(Number));

        }
        // if argument 1 has not been set yet - do these steps
        else if(Calculator.getArg_1() == 0)
        {
            /*checks if the string is empty, if yes then sets argument 1 to 0 if not then converts string to double
            and sets that value to argument 1*/
            if(Number == "")
                Calculator.setArg_1(0);
            else
                Calculator.setArg_1(Double.parseDouble(Number));

            /* cheks if the operator is div, multiply or x power n if yes then set argument 2 to one,
            because by default argument 2 is set to 0 and "number" / 0 = inf, "number" * 0 = 0 and "number"^0 = 1*/
            if (Calculator.getOperator() == "/" || Calculator.getOperator() == "*" || Calculator.getOperator() == "xpowern")
                Calculator.setArg_2(1);

            if(Calculator.getOperator() == "%")
                Calculator.setArg_2(Calculator.getArg_1()+1);
        }

        Number = ""; //reset Number to "" empty string
        Calculator.setArg_1(Calculator.calculate(Calculator.getArg_1(),Calculator.getArg_2(),Calculator.getOperator()));
        Calculator.setArg_2(0);

        /*checks if argument_1 (solution of the problem) has a decimal point if number = 22.0 then cast it to integer
         * to display it as 22 else if number = 22.2 then display it as it is 22.2 */
        if(Calculator.getArg_1() % 1 == 0)
            result_Label.setText(Integer.toString((int)Calculator.getArg_1()));
        else
            result_Label.setText(Double.toString(Calculator.getArg_1()));
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
        if(event.getSource() == pi)
        {
            Number = "3.14159265359";
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
            Calculator.setArg_2(0);

            /*checks if argument_1 (solution of the problem) has a decimal point if number = 22.0 then cast it to integer
             * to display it as 22 else if number = 22.2 then display it as it is 22.2 */
            if(Calculator.getArg_1() % 1 == 0)
                result_Label.setText(Integer.toString((int)Calculator.getArg_1()));
            else
            {
                result_Label.setText(Double.toString(Calculator.getArg_1()));
            }
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
        if(event.getSource() == factorial)
        {
            Calculator.setOperator("factorial");
            solve();
            operator_Label.setText("!n");
        }
        if(event.getSource() == log)
        {
            Calculator.setOperator("log");
            solve();
            operator_Label.setText("log");
        }
        if(event.getSource() == onedivx)
        {
            Calculator.setOperator("onedivx");
            solve();
            operator_Label.setText("1/x");
        }
        if(event.getSource() == xpowern)
        {
            Calculator.setOperator("xpowern");
            solve();
            operator_Label.setText("xⁿ");
        }
        if(event.getSource() == sin)
        {
            Calculator.setOperator("sin");
            solve();
            operator_Label.setText("sin");
        }
        if(event.getSource() == cos)
        {
            Calculator.setOperator("cos");
            solve();
            operator_Label.setText("cos");
        }
        if(event.getSource() == tan)
        {
            Calculator.setOperator("tan");
            solve();
            operator_Label.setText("tan");
        }
        if(event.getSource() == ctg)
        {
            Calculator.setOperator("ctg");
            solve();
            operator_Label.setText("ctg");
        }

        //CONVERT INTEGERS
        if(event.getSource() == hex)
        {
            operator_Label.setText("HEX");
            Calculator.setArg_1((Integer.parseInt(Number)));

            String hex = Integer.toHexString((int)Double.parseDouble(Number));
            result_Label.setText("0x"+hex);
        }
        if(event.getSource() == dec)
        {
            operator_Label.setText("DEC");
            Calculator.setArg_1((Integer.parseInt(Number)));

            result_Label.setText(Double.toString(Calculator.getArg_1()));
        }
        if(event.getSource() == oct)
        {
            operator_Label.setText("OCT");
            Calculator.setArg_1((Integer.parseInt(Number)));

            String oct = Integer.toOctalString((int)Double.parseDouble(Number));
            result_Label.setText(oct);
        }
        if(event.getSource() == bin)
        {
            operator_Label.setText("BIN");
            Calculator.setArg_1((Integer.parseInt(Number)));

            String bin = Integer.toBinaryString((int)Double.parseDouble(Number));
            result_Label.setText(bin);
        }


        //CONTROLS
        if(event.getSource() == c)
        {
            Calculator.setOperator("");
            Calculator.setArg_1(0);
            Calculator.setArg_2(0);
            operator_Label.setText("");
            Number = "0";
            result_Label.setText(Number);
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
        {
            Number = Double.toString(Calculator.getMArg_1());

            if(Calculator.getMArg_1() % 1 == 0)
                result_Label.setText(Integer.toString((int)Calculator.getMArg_1()));
            else
                result_Label.setText(Double.toString(Calculator.getMArg_1()));
        }
        if(event.getSource() == MC)
        {
            Calculator.setMArg_1(0);
            memory_Label.setText("0");
        }
        if(event.getSource() == M_minus)
        {
            if(Number == "")
                Calculator.setMArg_1(Calculator.getMArg_1()-Calculator.getArg_1());
            else
                Calculator.setMArg_1(Calculator.getMArg_1()-Double.parseDouble(Number));

            if(Calculator.getMArg_1() % 1 == 0)
                memory_Label.setText(Integer.toString((int)Calculator.getMArg_1()));
            else
                memory_Label.setText(Double.toString(Calculator.getMArg_1()));
        }
        if(event.getSource() == M_plus)
        {
            if(Number == "")
                Calculator.setMArg_1(Calculator.getMArg_1()+Calculator.getArg_1());
            else
                Calculator.setMArg_1(Calculator.getMArg_1()+Double.parseDouble(Number));


            if(Calculator.getMArg_1() % 1 == 0)
                memory_Label.setText(Integer.toString((int)Calculator.getMArg_1()));
            else
                memory_Label.setText(Double.toString(Calculator.getMArg_1()));
        }

    }
}
