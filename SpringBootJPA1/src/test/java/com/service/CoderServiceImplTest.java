package com.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entity.Coder;
import com.repository.CoderRepo;

@SpringBootTest
class CoderServiceImplTest {
	
	@Autowired
	CoderServiceImpl coderservice;
	
	@MockBean
	CoderRepo repo;

	@Test
	void testGetCoders() {
		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Manu");
		c1.setTech("Java");
		
		Coder c2 = new Coder();
		c2.setCid(2);
		c2.setCname("Rithu");
		c2.setTech("JPA");
		
		List<Coder> lc1 = new ArrayList<>();
		lc1.add(c1);
		lc1.add(c2);
		
		Mockito.when(repo.findAll()).thenReturn(lc1);
		
		assertThat(coderservice.getCoders()).isEqualTo(lc1);
		
	}

	@Test
	void testGetCoderById() {
		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Manu");
		c1.setTech("Java");
		
		Optional<Coder> c2 = Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		
		assertThat(coderservice.getCoderById(1)).isEqualTo(c1);	
	}

	@Test
	void testAddCoder() {
		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Manu");
		c1.setTech("Java");
		
		Mockito.when(repo.save(c1)).thenReturn(c1);
		
		assertThat(coderservice.addCoder(c1)).isEqualTo(c1);
	}

	@Test
	void testUpdateCoder() throws Exception {
		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Manu");
		c1.setTech("Java");
		
		Optional<Coder> c2 = Optional.of(c1);
		Mockito.when(repo.findById(1)).thenReturn(c2);
		Mockito.when(repo.save(c1)).thenReturn(c1);
		c1.setCname("Priya");
		c1.setTech("Java");
		
		assertThat(coderservice.updateCoder(c1)).isEqualTo(c1);
	}

	@Test
	void testDeleteCoder() {
		Coder c1 = new Coder();
		c1.setCid(1);
		c1.setCname("Manu");
		c1.setTech("Java");
		
		Optional<Coder> c2 = Optional.of(c1);
		
		Mockito.when(repo.findById(1)).thenReturn(c2);
		Mockito.when(repo.existsById(c1.getCid())).thenReturn(false);
		assertFalse(repo.existsById(c1.getCid()));
	}

	/*
	@Test
	void testDeleteCoderById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCoderByCname() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByTechSorted() {
		fail("Not yet implemented");
	}
    */
}
