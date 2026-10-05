module com.aadarshdevi.jcbuilder {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.desktop;

    opens com.aadarshdevi.jcbuilder to javafx.fxml;
    exports com.aadarshdevi.jcbuilder;
}