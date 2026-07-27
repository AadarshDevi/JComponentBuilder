package com.aadarshdevi.jcbuilder.testing;

import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StyleStage extends Stage {

    private final Control control;

    public StyleStage(Control control) {
        this.control = control;
        super();
        setTitle("Control: " + control.getClass().getSimpleName());
        BorderPane controller = new BorderPane(control);
        BorderPane cage = new BorderPane(controller);
        cage.setPrefSize(480.0, 560.0);
        InputFieldManagement ifm = new InputFieldManagement();
        ifm.setPrefWidth(cage.getPrefWidth() - 10);
        ifm.setNode(control);
        cage.setBottom(ifm);
        Scene scene = new Scene(cage);
        setScene(scene);
    }

    public void setControl() {

    }


    public void setButton() {
        setControl();
    }

    public void setBackground() {

    }


}
