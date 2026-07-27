module com.aadarshdevi.jcbuilder {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.aadarshdevi.jcbuilder to javafx.fxml;
    exports com.aadarshdevi.jcbuilder;
}