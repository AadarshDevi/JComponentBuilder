module com.aadarshdevi.jcbuilder.jcbuilder {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.aadarshdevi.jcbuilder.jcbuilder to javafx.fxml;
	exports com.aadarshdevi.jcbuilder.jcbuilder;
}