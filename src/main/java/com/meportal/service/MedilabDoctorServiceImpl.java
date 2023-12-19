/**
 * 
 */
package com.meportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meportal.bean.DoctorBean;
import com.meportal.model.Address;
import com.meportal.model.Department;
import com.meportal.model.Doctor;
import com.meportal.repo.AddressRepo;
import com.meportal.repo.DepartmentRepo;
import com.meportal.repo.DoctorRepo;


@Service
public class MedilabDoctorServiceImpl implements MedilabDoctorService {

	@Autowired
	private DoctorRepo doctRepo;
	
	@Autowired
	private DepartmentRepo deptRepo;
	
	@Autowired
	private AddressRepo addrRepo;


	@Override
	public DoctorBean save(DoctorBean doctBean) {
		Doctor doctModel = new Doctor();
		Address addrModel = new Address();
		BeanUtils.copyProperties(doctBean, addrModel);
		BeanUtils.copyProperties(doctBean, doctModel);
		
		
		doctModel.setAddress(addrModel);
		
		Department deptModel = deptRepo.findDeptByName(doctBean.getDept());
		doctModel.setDept(deptModel);
		
		doctRepo.save(doctModel);

		BeanUtils.copyProperties(doctModel, doctBean);
		
		BeanUtils.copyProperties(addrModel, doctBean);		

		return doctBean;
	}


	@Override
	public List<DoctorBean> findAll() {
		List<Doctor> doctModelList = doctRepo.findAll();
		List<DoctorBean> doctBeanList = new ArrayList<>();
		if (doctModelList != null && doctModelList.size() > 0) {
			doctModelList.stream().forEach(doctModel -> {
				DoctorBean doctBean = new DoctorBean();
				BeanUtils.copyProperties(doctModel, doctBean);
				if(doctModel.getAddress() != null) {
					BeanUtils.copyProperties(doctModel.getAddress(), doctBean);
				}
				
				doctBeanList.add(doctBean);
			});
		}
		return doctBeanList;
	}


	@Override
	public DoctorBean findById(int id) {
		Optional<Doctor> doctOpt = doctRepo.findById(id);
		DoctorBean doctBean = new DoctorBean();
		Doctor doctModel = doctOpt.get();
		BeanUtils.copyProperties(doctModel, doctBean);
		if(doctModel.getAddress() != null) {
			BeanUtils.copyProperties(doctModel.getAddress(), doctBean);
		}
		if(doctModel.getDept() != null) {
			doctBean.setDept(doctModel.getDept().getName());
		}
		
		return doctBean;
	}


	@Override
	public DoctorBean findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<DoctorBean> delete(int id) {
		doctRepo.deleteById(id);
		return findAll();
	}


	@Override
	public List<DoctorBean> delete(DoctorBean deptBean) {
		Doctor Doctor = new Doctor();
		BeanUtils.copyProperties(deptBean, Doctor);
		doctRepo.delete(Doctor);
		return findAll();
	}


	@Override
	public DoctorBean update(DoctorBean doctBean) {
		Doctor doctModel = new Doctor();
		Address addrModel = addrRepo.findAddressByName(doctBean.getAddress());
		BeanUtils.copyProperties(doctBean, doctModel);
		
		BeanUtils.copyProperties(doctBean, addrModel);
		
		Department deptModel = deptRepo.findDeptByName(doctBean.getDept());
		doctModel.setDept(deptModel);
		doctModel.setAddress(addrModel);
		
		doctRepo.save(doctModel);
		doctBean.setDept(doctModel.getDept().getName());
		
		BeanUtils.copyProperties(doctModel, doctBean);
		BeanUtils.copyProperties(addrModel, doctBean);
		
		return doctBean;
	}
}
