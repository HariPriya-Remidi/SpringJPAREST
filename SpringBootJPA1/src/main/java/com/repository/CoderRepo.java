package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.Coder;

@Repository
public interface CoderRepo extends JpaRepository<Coder, Integer>
{
 Coder findByCname(String cname);
 
 @Query("Select c from Coder c order by c.cname")
	List<Coder> findByTechSorted(String tech);

}
