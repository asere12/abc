package application;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mysql.cj.jdbc.MysqlDataSource;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class OperatorController implements Initializable {

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_del;

    @FXML
    private TableColumn<Request, Integer> item1;

    @FXML
    private TableColumn<Request, String> item2;

    @FXML
    private TableColumn<Request, String> item3;

    @FXML
    private TableColumn<Request, String> item4;

    @FXML
    private TableColumn<Request, String> item5;

    @FXML
    private TableColumn<Request, String> item6;

    @FXML
    private TableColumn<Request, String> item7;

    @FXML
    private TableColumn<Request, Integer> item8;

    @FXML
    private TableColumn<Request, Integer> item9;

    @FXML
    private TableView<Request> table;
    
	MysqlDataSource dataSource;
	JdbcTemplate jb;

    @FXML
    void add_item(MouseEvent event) throws IOException {
		Pane root=null;
		root = (Pane)FXMLLoader.load(getClass().getResource("CreateForm.fxml"));
		Stage stage = (Stage) btn_add.getScene().getWindow();
		stage.setTitle("Панель cоздания заказа");
		stage.setScene(new Scene(root));
    }

    @FXML
    void del_item(MouseEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dataSource = new MysqlDataSource();
		dataSource.setServerName("localhost");
		dataSource.setPort(3306);
		dataSource.setDatabaseName("mydb");
		dataSource.setUser("root");
		dataSource.setPassword("H2G90@7A");
    	jb = new JdbcTemplate(dataSource);
    	ResultSet x;
    	List<Request> requests = jb.query("select * from request",
				(resultSet ,rowNum) -> {
					Request zav = new Request();
					zav.setIdRequest(resultSet.getInt("idRequest"));
					zav.setData(resultSet.getString("data"));
					zav.setType(resultSet.getString("type"));
					zav.setModel(resultSet.getString("model"));
					zav.setDescribe(resultSet.getString("describe"));
					zav.setFio(resultSet.getString("fio"));
					zav.setPhone(resultSet.getString("phone"));
					zav.setStatus_idStatus(resultSet.getInt("Status_idStatus"));
					zav.setEmployee_idEmployee(resultSet.getInt("Employee_idEmployee"));
					return zav;
		});
    	ObservableList<Request> observableRequests = FXCollections.observableArrayList(requests);
		item1.setCellValueFactory(new PropertyValueFactory<Request, Integer>("idRequest"));
		item2.setCellValueFactory(new PropertyValueFactory<Request, String>("data"));
		item3.setCellValueFactory(new PropertyValueFactory<Request, String>("type"));
		item4.setCellValueFactory(new PropertyValueFactory<Request, String>("model"));
		item5.setCellValueFactory(new PropertyValueFactory<Request, String>("describe"));
		item6.setCellValueFactory(new PropertyValueFactory<Request, String>("fio"));
		item7.setCellValueFactory(new PropertyValueFactory<Request, String>("phone"));
		item8.setCellValueFactory(new PropertyValueFactory<Request, Integer>("Status_idStatus"));
		item9.setCellValueFactory(new PropertyValueFactory<Request, Integer>("Employee_idEmployee"));
		table.setItems(observableRequests);
	}
   
}
