package com.aadarshdevi.jcbuilder.testing;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputFieldManagement extends GridPane {

    private static final double NODE_HEIGHT = 30;
    private Node node;

    public InputFieldManagement() {
//        setBackground(new Background(new BackgroundFill(
//                Paint.valueOf("#6ea0dd"),
//                new CornerRadii(0),
//                new Insets(5)
//        )));
        prefWidth(Double.MAX_VALUE);
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(10));
    }

    private TextField getTextProperty(StringProperty text) {
        TextField textField = new TextField();
        textField.setPrefHeight(NODE_HEIGHT);
        textField.setPrefWidth(getPrefWidth() * 2 / 5);
        textField.textProperty().bindBidirectional(text);
//        textField.setBackground(new Background(new BackgroundFill(
//                Paint.valueOf("#ddb56e"),
//                new CornerRadii(0),
//                new Insets(0)
//        )));
        return textField;
    }

    public void setNode(Node node) {

        switch (node) {
            case Button button -> {
                button.setPrefSize(60, 25);
                add(getLabel("Text"), 0, 0);
                add(getTextProperty(button.textProperty()), 1, 0);
                add(getLabel("Width"), 0, 1);
                add(getSizeSpinner(button.prefWidthProperty(), button.prefHeightProperty()), 1, 1);
            }
            default -> {
                throw new IllegalStateException("Unexpected value: " + node);
            }
        }
    }

    private Label getLabel(String header) {
        Label label = new Label(header);
        label.setText(header);
        label.setPrefWidth(getPrefWidth() * 3 / 5);
        label.setPrefHeight(NODE_HEIGHT);
//        label.setBackground(new Background(new BackgroundFill(
//                Paint.valueOf("#81dd6e"),
//                new CornerRadii(0),
//                new Insets(0)
//        )));
        return label;
    }

    public GridPane getSizeSpinner(DoubleProperty widthProperty, DoubleProperty heightProperty) {
        GridPane gridPane = new GridPane(0, 0);
        gridPane.setPrefWidth(getPrefWidth() * 2 / 5);
        Spinner<Double> widthSpinner;
        Spinner<Double> heightSpinner;
        widthSpinner = new Spinner<Double>(Double.MIN_VALUE, Double.MAX_VALUE, widthProperty.getValue(), 1);
        widthSpinner.setPrefHeight(NODE_HEIGHT);
        widthSpinner.setEditable(true);
        widthProperty.bind(
                Bindings.createDoubleBinding(
                        widthSpinner::getValue,
                        widthSpinner.valueProperty()
                )
        );
        gridPane.add(widthSpinner, 0, 0);

        heightSpinner = new Spinner<Double>(Double.MIN_VALUE, Double.MAX_VALUE, heightProperty.getValue(), 1);
        heightSpinner.getValueFactory().setValue(heightProperty.getValue());
        heightSpinner.setPrefHeight(NODE_HEIGHT);
        heightSpinner.setEditable(true);
        heightProperty.bind(
                Bindings.createDoubleBinding(
                        heightSpinner::getValue,
                        heightSpinner.valueProperty()
                )
        );
        gridPane.add(heightSpinner, 1, 0);

        return gridPane;
    }
}
