package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calculator");
        Scene scene = new Scene(root, 660, 850);
        scene.getStylesheets().addAll("sample/style.css");
        Image logo_icon = new Image("sample/resources/icon.png");
        primaryStage.getIcons().add(logo_icon);
        primaryStage.setMinWidth(520);
        primaryStage.setMinHeight(780);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
