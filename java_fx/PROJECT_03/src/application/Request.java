package application;

public class Request {
	
	int idRequest;
	String data;
	String type;
	String model;
	String describe;
	String fio;
	String phone;
	int Status_idStatus;
	int Employee_idEmployee;
	
	
	public int getIdRequest() {
		return idRequest;
	}
	public void setIdRequest(int idRequest) {
		this.idRequest = idRequest;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus_idStatus() {
		return Status_idStatus;
	}
	public void setStatus_idStatus(int status_idStatus) {
		Status_idStatus = status_idStatus;
	}
	public int getEmployee_idEmployee() {
		return Employee_idEmployee;
	}
	public void setEmployee_idEmployee(int employee_idEmployee) {
		Employee_idEmployee = employee_idEmployee;
	}
	public Request() {
		super();
		this.idRequest = idRequest;
		this.data = data;
		this.type = type;
		this.model = model;
		this.describe = describe;
		this.fio = fio;
		this.phone = phone;
		this.Status_idStatus = Status_idStatus;
		this.Employee_idEmployee = Employee_idEmployee;
	}

}
