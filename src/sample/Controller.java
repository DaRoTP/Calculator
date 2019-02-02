package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;

public class Controller implements EventHandler<javafx.event.ActionEvent> {

                //<!===== BUTTONS =====!>
    // STAGE CONTROL
    @FXML private Button exit;
    @FXML private Button minimize;
    @FXML private Button maximize;

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

    //CALCULATOR FUNCTIONS
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
    @FXML private Button fact;



    @Override
    public void handle(javafx.event.ActionEvent event) {
        //DIGITS
        if(event.getSource() == one)
            System.out.println("one");
        if(event.getSource() == two)
            System.out.println("one");
        if(event.getSource() == three)
            System.out.println("one");
        if(event.getSource() == four)
            System.out.println("one");
        if(event.getSource() == five)
            System.out.println("one");
        if(event.getSource() == six)
            System.out.println("one");
        if(event.getSource() == seven)
            System.out.println("one");
        if(event.getSource() == eight)
            System.out.println("one");
        if(event.getSource() == nine)
            System.out.println("one");
        if(event.getSource() == zero)
            System.out.println("one");

        //SIGNS
        if(event.getSource() == plus)
            System.out.println("one");
        if(event.getSource() == minus)
            System.out.println("one");
        if(event.getSource() == mult)
            System.out.println("one");
        if(event.getSource() == div)
            System.out.println("one");
        if(event.getSource() == mod)
            System.out.println("one");
        if(event.getSource() == root)
            System.out.println("one");
        if(event.getSource() == equals)
            System.out.println("one");
        if(event.getSource() == sqr)
            System.out.println("one");
        if(event.getSource() == root)
            System.out.println("one");
        if(event.getSource() == neg)
            System.out.println("one");
        if(event.getSource() == fact)
            System.out.println("one");
        if(event.getSource() == coma)
            System.out.println("one");

        //CONTROLS
        if(event.getSource() == c)
            System.out.println("one");
        if(event.getSource() == ce)
            System.out.println("one");
        if(event.getSource() == del)
            System.out.println("one");


    }
}
