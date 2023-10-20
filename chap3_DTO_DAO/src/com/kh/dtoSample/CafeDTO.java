package com.kh.dtoSample;

// CafeDTO: ������ ���� ��ü
public class CafeDTO {
	// model sql �� ���Ŀ� ���� �����͸� ĸ��ȭ�ϰ� getter setter�� Ȱ���Ͽ� �����͸� �����ϰ� �������� ����
	// �ʵ� ������� �ۼ�
	private int cafeId;
	private String cafeName;
	private String address;
	private String phone_number;
	private String operatingHours;

	// ������ ����
	public CafeDTO() {

	}

	public CafeDTO(int cafeId, String cafeName, String address, String phone_number, String operatingHours) {
		super();
		this.cafeId = cafeId;
		this.cafeName = cafeName;
		this.address = address;
		this.phone_number = phone_number;
		this.operatingHours = operatingHours;
	}

	// getter setter �޼���
	public int getCafeId() {
		return cafeId;
	}

	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}

	public String getCafeName() {
		return cafeName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getOperatingHours() {
		return operatingHours;
	}

	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}
	
	
	// @Override�� Ȱ���� toString �޼��� �߰�
	@Override
	public String toString() {
		return "CafeDTO" + cafeId;
	}

}
