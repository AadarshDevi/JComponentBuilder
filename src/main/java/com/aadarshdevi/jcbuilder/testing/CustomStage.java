package com.aadarshdevi.jcbuilder.testing;

import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CustomStage extends Stage {
    public CustomStage(Control control) {
        super();
        setTitle("Control: " + control.getClass().getSimpleName());
        BorderPane controller = new BorderPane(control);
        BorderPane cage = new BorderPane(controller);
        cage.setPrefSize(480.0, 560.0);
        Scene scene = new Scene(cage);
        setScene(scene);
//        initStyle(StageStyle.UNDECORATED); // removed when scene can move window
    }
}
