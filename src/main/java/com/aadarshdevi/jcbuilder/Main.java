package com.aadarshdevi.jcbuilder;

import com.aadarshdevi.jcbuilder.testing.CustomStage;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Button button = new Button("Button");
        CustomStage cs = new CustomStage(button);
        cs.show();
    }
}