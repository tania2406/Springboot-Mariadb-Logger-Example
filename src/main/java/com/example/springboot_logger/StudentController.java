package com.example.springboot_logger;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@Autowired
	StudentRepository aerepo;
	@RequestMapping("/test")
	public String test()
	{
		org.slf4j.Logger logger=LoggerFactory.getLogger(StudentController.class);
				logger.trace("A Trace Message");
		logger.debug("A Debug Message");
		logger.info("An INFO Message");
		logger.warn("A warn Message");
		logger.error("An Error Message");
				
		return "this is test for logger";
		
	}
	@PostMapping("/save")
	public String save(@RequestBody Student std)
	{
		aerepo.save(std);
		return "data has been saved";
	}
	@GetMapping("/all")
	public List<Student>allData()
	{
		return aerepo.findAll();
	}
}
