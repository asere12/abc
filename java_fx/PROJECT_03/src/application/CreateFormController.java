package application;

import java.io.IOException;
import java.sql.ResultSet;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CreateFormController {

    @FXML
    private Button btn_back;

    @FXML
    private Button btn_confirm;

    @FXML
    private TextField textfiled_1;

    @FXML
    private TextField textfiled_2;

    @FXML
    private TextField textfiled_3;

    @FXML
    private TextField textfiled_4;

    @FXML
    private TextField textfiled_5;

    @FXML
    private TextField textfiled_6;

    @FXML
    private TextField textfiled_7;

    @FXML
    private TextField textfiled_8;

    @FXML
    private TextField textfiled_9;
    
	MysqlDataSource dataSource;
	JdbcTemplate jb;

    @FXML
    void add_item(MouseEvent event) {
    	dataSource = new MysqlDataSource();
		dataSource.setServerName("localhost");
		dataSource.setPort(3306);
		dataSource.setDatabaseName("mydb");
		dataSource.setUser("root");
		dataSource.setPassword("H2G90@7A");
    	jb = new JdbcTemplate(dataSource);
    	ResultSet x;
	//	try {
			jb.update("insert into request(idRequest,data,type,model,describe,fio,phone,Status_idStatus,Employee_idEmployee) values (?,?,?,?,?,?,?,?,?)", textfiled_1.getText(),textfiled_2.getText(),textfiled_3.getText(),textfiled_4.getText(),textfiled_5.getText(),textfiled_6.getText(),textfiled_7.getText(),textfiled_8.getText(),textfiled_9.getText());
	//	} catch(Exception e) {
		//	e.printStackTrace();
		//	Alert alert = new Alert(AlertType.ERROR);
		//	alert.setContentText("Ошибка запроса!");
	//		alert.showAndWait();
	//	}
    }

    @FXML
    void back(MouseEvent event) throws IOException {
		Pane root=null;
		root = (Pane)FXMLLoader.load(getClass().getResource("Operator.fxml"));
		Stage stage = (Stage) btn_back.getScene().getWindow();
		stage.setTitle("Панель оператора");
		stage.setScene(new Scene(root));
    }

}
