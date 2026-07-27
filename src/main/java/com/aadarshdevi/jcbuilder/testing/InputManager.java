package com.aadarshdevi.jcbuilder.testing;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public interface InputManager {

    /**
     * sets the Input Field to the required size
     *
     * @param region obj that will have its size set
     */
    void setSize(Region region);

    void setNode(Node node);

    /**
     * Creates a Customized Label
     *
     * @param header label text
     * @return label with mods
     */
    Label getLabel(String header);

    GridPane getSizeSpinner(DoubleProperty widthProperty, DoubleProperty heightProperty);

    Spinner<Double> getSpinner(double initialVal);

    TextField getTextProperty(StringProperty text);
}
