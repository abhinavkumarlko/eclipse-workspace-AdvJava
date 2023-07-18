package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Emp;
import com.example.demo.services.EmpService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class EmpController {
	
	@Autowired
	EmpService eservice;
	
	public List<Emp> getAll()
	{
		return eservice.getAll();
	}
	
	@PostMapping("/savemp")
	public Emp save(@RequestBody Emp e) {
		return eservice.saveEmp(e);
	}
	

	//key-value pairs
	@GetMapping("/getemp")
	public Emp getOne(@RequestParam("eno")int empid) {
		return eservice.getEmp(empid);
		}
	
	//only value, giving some name from our end
	@GetMapping("/getoneemp/{eid}")
	public Emp getOneEmp(@PathVariable("eid")int empid)
	{
		return eservice.getEmp(empid);
	}
	
	@GetMapping("/getempsbydept")
	public List<Emp>getEmps(@RequestParam("dno")int deptno)
	{
		return eservice.getEmps(deptno);
	}
	
	@GetMapping("/updatesal")
	public int updateSal(@RequestParam("eid")int empid,@RequestParam("sal")float salary)
	{
		return eservice.updatesal(empid,salary);
	}
	
	

	

}
