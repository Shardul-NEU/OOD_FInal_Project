module chess {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens sample to javafx.graphics, javafx.fxml;
}
