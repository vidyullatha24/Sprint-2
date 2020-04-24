package com.cg.sprint.fms.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Flight 
{
    @Id
    @Column(name="flight_no")
    String flightNo;
    @Column(name="flight_company")
    String companyName;
    @Column(name="weight")
    double weightAllowed;
    @Column(name="flight_rows")
    int rows;
    @Column(name="flight_cols")
    int columns;
    public Flight() { }
	public Flight(String flightNo, String companyName, double weightAllowed, int rows, int columns) 
	{
		this.flightNo = flightNo;		this.companyName = companyName;		this.weightAllowed = weightAllowed;
		this.rows = rows;		this.columns = columns;
	}
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public double getWeightAllowed() {
		return weightAllowed;
	}
	public void setWeightAllowed(double weightAllowed) {
		this.weightAllowed = weightAllowed;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getColumns() {
		return columns;
	}
	public void setColumns(int columns) {
		this.columns = columns;
	}
}
