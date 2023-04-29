package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.app.StringOperation;

@RestController
public class ServiceController{
	@RequestMapping(value="/stringOperation",method=RequestMethod.POST,consumes = "application/json")	
	public String stringOperration(@RequestBody StringOperation so){	
		return so.stringOperations();
	}
}
