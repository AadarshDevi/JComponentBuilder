package com.aadarshdevi.jcbuilder.testing;

import com.aadarshdevi.jcbuilder.testing.helper.HelperUI;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

//abstract
public class Inspector extends GridPane implements InspectorInterface {

    protected Mode mode = Mode.SIMPLE;

    public Inspector() {
    }

    public Inspector(Mode mode) {
        this.mode = mode;
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
        Label label = HelperUI.label(header, getPrefWidth());
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

    public void update() {
    }

    public void transfer() {

    }

    private void basicMode() {
    }

    private void advancedMode() {
    }

    public enum Mode {
        SIMPLE,
        ADVANCED
    }
}
