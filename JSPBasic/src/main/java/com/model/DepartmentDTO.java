package com.model;

public class DepartmentDTO {
	
	// DAO DTO 합쳐서 model이라 한다
	//DTO = VO 클래스는 데이터를 옮기기 위한 클래스이며, 테이블별 1개씩 만든다
	// 관련변수를 테이블과 동일한 이름으로 선언하고, getter setter를 만들어준다
	
	private int departmentId; // 데이터에서 언더바를 없앤 후 카멜 표기법으로 
	private String departmentName;
	private int managerId;
	private int locationId;
	
	//생성자는, 기본 생성자 랑 멤버변수를 초기화하는 생성자 2개 만들기
	public DepartmentDTO() {
	
}

	public DepartmentDTO(int departmentID, String departmentName, int managerId, int locationId) {
		super();
		this.departmentId = departmentID;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.locationId = locationId;
	}

	//getter setter
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentID) {
		this.departmentId = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	
	
}