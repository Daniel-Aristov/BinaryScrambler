package ru.aristov.binaryscrambler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("scrambler-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Scrambler");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static String arrayToString(int[] arr) {
        String result = "";
        for (int j : arr) {
            result += j;
        }
        return result;
    }
}