package com.aadarshdevi.jcbuilder.testing.viewer.control;

import com.aadarshdevi.jcbuilder.testing.Viewer;
import javafx.scene.control.Control;

public class ControlViewer extends Viewer {

    public Control control;

    public ControlViewer(Control control) {
        super(control);
        this.control = control;
    }
}
