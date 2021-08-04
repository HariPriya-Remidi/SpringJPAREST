package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Coder;
import com.service.CoderServiceImpl;

@RestController
@RequestMapping("/api")
public class HomeRestController {
	
	@Autowired
	CoderServiceImpl coderservice;
	
	@RequestMapping("/helloRest")
	public String hello() {
		
	 return "Welcome to Spring Controller";
	}
	
	@GetMapping("/getCoder1")
	public ResponseEntity<List<Coder>> getCoder()
	{
		List<Coder> lc1=coderservice.getCoders();
		ResponseEntity<List<Coder>> re=new ResponseEntity<List<Coder>>(lc1,HttpStatus.OK);
		return re;
	}
    
	@GetMapping("/getCoder1/{cid}")
	public ResponseEntity<Coder> getCoderById(@PathVariable int cid)
	{
	 Coder c1=coderservice.getCoderById(cid);
	 ResponseEntity<Coder> re = new ResponseEntity<Coder>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addCoder1")
	public ResponseEntity<Coder> addCoder(@RequestBody  Coder coder)
	{
		Coder c1=coderservice.addCoder(coder);
		ResponseEntity<Coder> re = new ResponseEntity<Coder>(c1,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateCoder1")
	public ResponseEntity<Coder> updateCoder(@RequestBody  Coder coder) throws Exception
	{
		Coder c1=coderservice.updateCoder(coder);
		ResponseEntity<Coder> re=new ResponseEntity<Coder>(c1,HttpStatus.OK);
		return re;
	}

	@DeleteMapping(path="/deleteCoder1")
	public ResponseEntity<String> deleteCoder(@RequestBody  Coder coder)
	{
		String msg=coderservice.deleteCoder(coder);
		ResponseEntity<String> re=new ResponseEntity<String>(msg,HttpStatus.OK);
		return re;
	}	
	
	@DeleteMapping(path="/deleteCoder1/{cid}")
	public ResponseEntity<String> deleteCoderById(@PathVariable  int cid)
	{
		String msg=coderservice.deleteCoderById(cid);
		ResponseEntity<String> re = new ResponseEntity<String>(msg,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getCoder/{cname}")
	public ResponseEntity<Coder> getCoderByCname(@PathVariable String cname)
	{
		Coder c = coderservice.getCoderByCname(cname);
		ResponseEntity<Coder> re = new ResponseEntity<Coder>(c,HttpStatus.OK);
		return re;
	}

	@GetMapping("/getCoders/{tech}")
	public ResponseEntity<List<Coder>> findByTechSorted(String tech) 
	{
		List<Coder> lc=coderservice.findByTechSorted(tech);
		ResponseEntity<List<Coder>> re=new ResponseEntity<List<Coder>>(lc,HttpStatus.OK);
		return re;
	}
}

