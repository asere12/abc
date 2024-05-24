package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.x.protobuf.MysqlxExpr.Operator;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginController {
	

    @FXML
    private Button btn_enter;

    @FXML
    private TextField textfiled_1;

    @FXML
    private TextField textfiled_2;
    
	MysqlDataSource dataSource;
	JdbcTemplate jb;

    @FXML
    void can_i_enter(MouseEvent event) throws IOException  {
    	
		dataSource = new MysqlDataSource();
		dataSource.setServerName("localhost");
		dataSource.setPort(3306);
		dataSource.setDatabaseName("mydb");
		dataSource.setUser("root");
		dataSource.setPassword("H2G90@7A");
    	jb = new JdbcTemplate(dataSource);
    	
    	ResultSet x;
    	var result = jb.query("Select Role_idRole from Enter where login='"+textfiled_1.getText()+"'and password = '"+textfiled_2.getText()+"'", (resultSet, rowNum) -> {return resultSet.getString("Role_idRole");});
    	if (textfiled_1.getText().isEmpty() && textfiled_2.getText().isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Логин и пароль не должны быть пустыми");
			alert.showAndWait();
    	} else if (result.size() == 0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Неверный логин или пароль");
			alert.showAndWait();
    	} else if (result.get(0).equals("1")) {
    		Pane root=null;
    		root = (Pane)FXMLLoader.load(getClass().getResource("Operator.fxml"));
    		Stage stage = (Stage) btn_enter.getScene().getWindow();
    		stage.setTitle("Панель оператора");
    		stage.setScene(new Scene(root));	
    	} else if (result.get(0).equals("2")) {
    		// Открывает панель оператора
    		System.out.print("Открывает панель оператора");
    	}
    }

}
