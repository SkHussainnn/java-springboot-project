/**
 * 
 */
package com.meportal.service;

import java.util.List;

import com.meportal.bean.DoctorBean;


public interface MedilabDoctorService {

	public DoctorBean save(DoctorBean deptBean);
	public List<DoctorBean> findAll();
	public DoctorBean findById(int id);
	public DoctorBean findByName(String name);
	public List<DoctorBean> delete(int id);
	public List<DoctorBean> delete(DoctorBean deptBean);
	public DoctorBean update(DoctorBean deptBean);
	
}
