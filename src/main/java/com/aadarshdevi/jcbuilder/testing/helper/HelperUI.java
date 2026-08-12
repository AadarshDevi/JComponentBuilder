package com.aadarshdevi.jcbuilder.testing.helper;

import com.aadarshdevi.jcbuilder.testing.Inspector;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class HelperUI {

    public static final double NODE_HEIGHT = 30.0;

    public static Label label(String header, double prefWidth) {
        Label label = new Label(header);
        label.setText(header);
        label.setPrefWidth(prefWidth * 3 / 5);
        label.setPrefHeight(NODE_HEIGHT);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setMinWidth(prefWidth * 2 / 5);
        return label;
    }

    public static void setSize(Region region, Inspector inspector) {
        GridPane.setHgrow(region, Priority.NEVER);
        GridPane.setVgrow(region, Priority.NEVER);
        region.setPrefHeight(NODE_HEIGHT);


        
        region.setMinSize(region.getPrefWidth(), region.getPrefHeight());
    }
}
