package com.aadarshdevi.jcbuilder;

import com.aadarshdevi.jcbuilder.testing.viewer.control.ControlViewer;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Button button = new Button("Button");
        ControlViewer viewer = new ControlViewer(button);
        viewer.show();
    }
}