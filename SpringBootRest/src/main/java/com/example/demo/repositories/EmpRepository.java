package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Emp;

@Repository
@Transactional
public interface EmpRepository extends JpaRepository<Emp,Integer>{
	
	@Query("select e from Emp e where e.deptno=:dno")
	public List<Emp>getEmpsFromDept(int dno);
	
	//executeUpdate
	@Modifying
	@Query("update Emp e set e.salary=?2 where e.empid=?1")
	public int updateSal(int eid,float sal); 
	

	@Procedure(procedureName = "GET_BY_SAL_RANGE")
	public List<Emp> getBySalRange(float min,float max);
	

}
