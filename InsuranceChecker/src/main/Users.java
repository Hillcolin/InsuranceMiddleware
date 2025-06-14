package main;

import java.util.Date;

public class Users {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPolicyExpiry() {
		return PolicyExpiry;
	}
	public void setPolicyExpiry(Date policyExpiry) {
		PolicyExpiry = policyExpiry;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	private int id;
	private String name;
	private Date PolicyExpiry;
	private Date createdAt;
	
}
