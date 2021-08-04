package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ResourceNotFoundException;
import com.entity.Coder;
import com.repository.CoderRepo;

@Service
public class CoderServiceImpl implements CoderService{
	
	@Autowired
	CoderRepo repo;

	public List<Coder> getCoders() 
	{
		List<Coder> lc=repo.findAll();
	return lc;
	}

	@Override
	public Coder getCoderById(int cid) {
		Coder c=repo.findById(cid).orElseThrow();
		return c;
	}

	@Override
	public Coder addCoder(Coder coder)
	{
		Coder c = repo.save(coder);
		return c;
	}

	public Coder updateCoder(Coder coder) throws Exception
	{
		int id=coder.getCid();
		Supplier<Exception> s1 = ()->new ResourceNotFoundException("Coder id is not present in the database"); 
		Coder c=repo.findById(id).orElseThrow(s1);
		c.setCname(coder.getCname());
		c.setTech(coder.getTech());
		repo.save(c);
		return c;	
	}
	
	public String deleteCoder(Coder coder)
	{
		repo.delete(coder);
		return "deleted";	
	}
	
	public String deleteCoderById(int cid) {
		repo.deleteById(cid);
		return "Deleted";
	}
	
	public Coder getCoderByCname(String cname) {
		Coder c = repo.findByCname(cname);
		return c;
	}

	public List<Coder> findByTechSorted(String tech) 
	{
		List<Coder> lc=repo.findByTechSorted(tech);
	return lc;
	}
}
