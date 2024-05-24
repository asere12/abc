module PROJECT_03 {
	requires javafx.controls;
	requires javafx.fxml;
	requires mysql.connector.j;
	requires spring.jdbc;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
