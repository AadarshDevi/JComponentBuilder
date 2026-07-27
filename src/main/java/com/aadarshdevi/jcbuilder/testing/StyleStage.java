package com.aadarshdevi.jcbuilder.testing;

import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;

public class StyleStage extends Stage {

    @Setter
    @Getter
    private Control control;

    public StyleStage(Control control) {
        this.control = control;
        super();
        setTitle("Control: " + this.control.getClass().getSimpleName());
        BorderPane controller = new BorderPane(this.control);
        setMinHeight(560.0);
        setMinWidth(420.0);
        BorderPane cage = new BorderPane(controller);
        cage.setPrefSize(420.0, 560.0);
        cage.setMinWidth(400.0);
        InputFieldManagement ifm = new InputFieldManagement();
        ifm.setPrefWidth(cage.getPrefWidth() - 10);
        ifm.setNode(this.control);
        cage.setBottom(ifm);
        Scene scene = new Scene(cage);
        setScene(scene);
    }

}
