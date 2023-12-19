/**
 * 
 */
package com.meportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meportal.model.Doctor;


public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

}
