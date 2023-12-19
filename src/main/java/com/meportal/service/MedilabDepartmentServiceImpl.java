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

import com.meportal.bean.DepartmentBean;
import com.meportal.model.Department;
import com.meportal.repo.DepartmentRepo;


@Service
public class MedilabDepartmentServiceImpl implements MedilabDepartmentService {

	@Autowired
	private DepartmentRepo deptRepo;

	@Override
	public DepartmentBean save(DepartmentBean deptBean) {
		Department deptModel = new Department();

		BeanUtils.copyProperties(deptBean, deptModel);
		deptRepo.save(deptModel);

		BeanUtils.copyProperties(deptModel, deptBean);

		return deptBean;
	}


	@Override
	public List<DepartmentBean> findAll() {
		List<Department> deptModelList = deptRepo.findAll();
		List<DepartmentBean> deptBeanList = new ArrayList<>();
		if (deptModelList != null && deptModelList.size() > 0) {
			deptModelList.stream().forEach(deptModel -> {
				DepartmentBean deptBean = new DepartmentBean();
				BeanUtils.copyProperties(deptModel, deptBean);
				deptBeanList.add(deptBean);
			});
		}
		return deptBeanList;
	}


	@Override
	public DepartmentBean findById(int id) {
		Optional<Department> deptOpt = deptRepo.findById(id);
		DepartmentBean deptBean = new DepartmentBean();
		Department deptModel = deptOpt.get();
		BeanUtils.copyProperties(deptModel, deptBean);
		return deptBean;
	}


	@Override
	public DepartmentBean findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<DepartmentBean> delete(int id) {
		deptRepo.deleteById(id);
		return findAll();
	}


	@Override
	public List<DepartmentBean> delete(DepartmentBean deptBean) {
		Department department = new Department();
		BeanUtils.copyProperties(deptBean, department);
		deptRepo.delete(department);
		return findAll();
	}


	@Override
	public DepartmentBean update(DepartmentBean deptBean) {
		Department deptModel = new Department();

		BeanUtils.copyProperties(deptBean, deptModel);
		deptRepo.save(deptModel);

		BeanUtils.copyProperties(deptModel, deptBean);
		
		return deptBean;
	}

}
