/**
 * 
 */
package com.meportal.bean;

import java.io.Serializable;


public class DepartmentBean implements Serializable {
	private static final long serialVersionUID = -1839672696590120994L;
	private int deptId;
	private String name;
	private String description;
	private String status;
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
