package com.digital.academy.MyFisrtSpringWebApp.Service;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.digital.academy.MyFisrtSpringWebApp.Entity.Person;

@Service
@Transactional
@Component
public interface PersonRepo extends CrudRepository<Person,Integer>{
	

}
