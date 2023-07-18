package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Emp;
import com.example.demo.repositories.EmpRepository;

@Service
public class EmpService {
	
	@Autowired
	EmpRepository erepo;
	
	public List<Emp> getAll()
	{
		return erepo.findAll();
	}
	
	public Emp getEmp(int empid) {
		
		Optional<Emp> oemp=erepo.findById(empid);
		Emp e=null;
		
		try {
			e=oemp.get();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return e;
		
		//return erepo.findById(empid).get()
		
	}
	
	public Emp saveEmp(Emp e) {
		return erepo.save(e);
	}
	
	public List<Emp>getEmps(int deptno){
		return erepo.getEmpsFromDept(deptno);
	}
	
	public int updatesal(int empid,float sal) {
		
		return erepo.updateSal(empid,sal);
	}

}
