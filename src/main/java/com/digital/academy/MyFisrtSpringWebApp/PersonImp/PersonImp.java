package com.digital.academy.MyFisrtSpringWebApp.PersonImp;


import java.util.ArrayList;
//import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import com.digital.academy.MyFisrtSpringWebApp.Entity.Person;
import com.digital.academy.MyFisrtSpringWebApp.PersonInter.PersonInter;
import com.digital.academy.MyFisrtSpringWebApp.Service.PersonRepo;

import java.util.List;

//import java.util.List;
import java.util.Optional;

@Component
public class PersonImp implements PersonInter {

	@Autowired
	Person person;
	
	@Autowired
	PersonRepo persoRepo;
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> ResponseEntity<T> saveData(String name, String surname, String gender) {
		
		person.setName(name);
		person.setSurname(surname);
		person.setGender(gender);
		
		persoRepo.save(person);
		
		return new ResponseEntity<T>((T) "Successfully Saved", HttpStatus.OK);
	}

	@Override
	public ArrayList<Person> listPerson() {
		
		return (ArrayList<Person>) persoRepo.findAll();
	}

	@Override
	public Optional<Person> search(int id) {
		
		return persoRepo.findById(id);
		
	}
	
	@SuppressWarnings("unchecked")
	public <T> ResponseEntity<T> deletePerson(int id) {
		
		List<Person> list = new ArrayList<Person>();
		
		list = (List<Person>) persoRepo.findAll();
		
		for(Person person: list) {
			
			if(person.getId() == id) {
				
				persoRepo.deleteById(id);
				
				return new ResponseEntity<T>((T) "Delete Success", HttpStatus.OK);
				
			}
			
		}
		
		return new ResponseEntity<T>((T) "Delete Failed", HttpStatus.OK);
		
	}
	
    public String updateUser(int id,String name,String surname,String gender) {
    	
    	List<Person> list = new ArrayList<Person>();
    	
    	list = (List<Person>) persoRepo.findAll();
    	
    	
       for(Person person: list) {
			
			if(person.getId() == id) {
				
				person.setName(name);
				person.setSurname(surname);
				person.setGender(gender);
				persoRepo.save(person);
				
			}
			
		}
    	
    	
    	return " ";
    	
	}
	
}
