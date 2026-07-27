package com.aadarshdevi.jcbuilder.lib.javauimanager;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.nio.file.Path;

public class Configuration {

    public static Node loadNode(Node node) {
        return switch (node) {
            case Control control -> loadControl(control);
            case Pane pane -> loadPane(pane);
            default -> throw new IllegalStateException("Unexpected value: " + node);
        };
    }

    public static Pane loadPane(Pane pane) {
        return switch (pane) {
            case BorderPane borderPane -> loadBorderPane(borderPane);
            case VBox vBox -> loadVBox(vBox);
            case HBox hBox -> loadHBox(hBox);
            default -> throw new IllegalStateException("Unexpected value: " + pane);
        };
    }

    public static Control loadControl(Control control) {
        return switch (control) {
            case Button button -> loadButton(button);
            case Label label -> loadLabel(label);
            default -> throw new IllegalStateException("Unexpected value: " + control);
        };
    }

    public static BorderPane loadBorderPane(BorderPane borderPane) {
        return null;
    }

    public static VBox loadVBox(VBox vBox) {
        return null;
    }

    public static HBox loadHBox(HBox hbox) {
        return null;
    }

    public static Button loadButton(Button button) {
        return null;
    }

    public static Label loadLabel(Label label) {
        return null;
    }

    public static Node loadConfig(File file) {
        return null;
    }

    public static Node loadConfig(Path path) {
        return null;
    }

    public static Node loadConfig(String string) {
        return null;
    }
}
