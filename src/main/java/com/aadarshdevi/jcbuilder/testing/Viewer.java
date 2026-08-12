package com.aadarshdevi.jcbuilder.testing;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public abstract class Viewer extends Stage {

    protected final Inspector inspector;
    private Node node;

    public Viewer(Node node) {
        this.node = node;
        super();

        setTitle("Node: " + this.node.getClass().getSimpleName());
        setMinHeight(560.0);
        setMinWidth(420.0);

        BorderPane holder = new BorderPane(this.node);
        holder.setPrefSize(420.0, 560.0);
        holder.setMinWidth(400.0);

        inspector = new Inspector();
        inspector.setPrefWidth(holder.getPrefWidth() - 10);
        inspector.setNode(this.node);

        holder.setBottom(inspector);

        Scene scene = new Scene(holder);
        setScene(scene);
    }

    public void setNode(Node node) {
        this.node = node;
        inspector.setNode(node);
        inspector.update();
    }
}
