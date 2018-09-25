package com.digital.academy.MyFisrtSpringWebApp.EntryPoint;



import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digital.academy.MyFisrtSpringWebApp.Entity.Person;
import com.digital.academy.MyFisrtSpringWebApp.PersonImp.PersonImp;
import com.digital.academy.MyFisrtSpringWebApp.Service.PersonRepo;

@RestController
@RequestMapping("/access")
public class EntryPoint {

	@Autowired
	PersonRepo persoRepo;
	
	@Autowired
	PersonImp personImp;
	
	
	@PostMapping("/save")
	public <T> ResponseEntity<T> save(@RequestParam String name,@RequestParam String surname,@RequestParam String gender) {
		
		
		
		return personImp.saveData(name,surname,gender);
	}

	
	@GetMapping("/list")
	public ArrayList<Person> list() {
		
		return personImp.listPerson();
	}

	
	@GetMapping("/search")
	public Optional<Person> search(@RequestParam int id) {
		
		
		return personImp.search(id);
	}
	
	@GetMapping("/delete")
	public <T> ResponseEntity<T> delete(@RequestParam int Id) {
		
		return personImp.deletePerson(Id);
		
	}
	
	@PutMapping("/update")
	public String update(@RequestParam int id,@RequestParam String name,@RequestParam String surname,@RequestParam String gender) {
		
		return personImp.updateUser(id,name,surname,gender);
		
	}

}
