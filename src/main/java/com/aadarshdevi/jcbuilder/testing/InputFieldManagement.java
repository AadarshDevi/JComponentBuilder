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
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;

public class InputFieldManagement extends GridPane implements InputManager {

    private static final double NODE_HEIGHT = 30;

    public InputFieldManagement() {
        setBackground(new Background(new BackgroundFill(
                Paint.valueOf("#ddb56e"),
                new CornerRadii(0),
                new Insets(0)
        )));
        setVgap(5);
        prefWidth(Double.MAX_VALUE);
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(10));
        setMaxWidth(Double.MAX_VALUE);
        setMinSize(getPrefWidth(), getPrefHeight());
    }

    @Override
    public void setSize(Region region) {
        setHgrow(region, Priority.NEVER);
        setVgrow(region, Priority.NEVER);
        region.setPrefHeight(NODE_HEIGHT);
        region.setMinSize(region.getPrefWidth(), region.getPrefHeight());
    }

    @Override
    public TextField getTextProperty(StringProperty text) {
        TextField textField = new TextField();
        setSize(textField);
        textField.setPrefWidth(getPrefWidth() * 2 / 5);
        textField.textProperty().bindBidirectional(text);
        return textField;
    }

    @Override
    public void setNode(Node node) {
        getChildren().removeAll(getChildren());

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

    @Override
    public Label getLabel(String header) {
        Label label = new Label(header);
        label.setText(header);
        label.setPrefWidth(getPrefWidth() * 3 / 5);
        label.setPrefHeight(NODE_HEIGHT);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setMinWidth(getPrefWidth() * 2 / 5);
        setHgrow(label, Priority.ALWAYS);
        return label;
    }

    @Override
    public GridPane getSizeSpinner(DoubleProperty widthProperty, DoubleProperty heightProperty) {
        GridPane gridPane = new GridPane(0, 0);
        gridPane.setHgap(5);
        gridPane.setPrefWidth(getPrefWidth() * 2 / 5);
        setSize(gridPane);

        Spinner<Double> widthSpinner = getSpinner(widthProperty.getValue());
        widthProperty.bind(
                Bindings.createDoubleBinding(
                        widthSpinner::getValue,
                        widthSpinner.valueProperty()
                )
        );
        gridPane.add(widthSpinner, 0, 0);

        Spinner<Double> heightSpinner = getSpinner(heightProperty.getValue());
        heightProperty.bind(
                Bindings.createDoubleBinding(
                        heightSpinner::getValue,
                        heightSpinner.valueProperty()
                )
        );
        gridPane.add(heightSpinner, 1, 0);
        return gridPane;
    }

    @Override
    public Spinner<Double> getSpinner(double initialVal) {
        Spinner<Double> spinner = new Spinner<>(Double.MIN_VALUE, Double.MAX_VALUE, initialVal, 1);
        setSize(spinner);
        spinner.setEditable(true);
        return spinner;
    }
}
