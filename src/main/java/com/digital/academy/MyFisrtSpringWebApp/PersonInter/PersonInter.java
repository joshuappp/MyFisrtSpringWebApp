package com.digital.academy.MyFisrtSpringWebApp.PersonInter;





import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.digital.academy.MyFisrtSpringWebApp.Entity.Person;


public interface PersonInter {
	
	public <T> ResponseEntity<T> saveData(String name, String surname, String gender);
	public ArrayList<Person> listPerson();
	public Optional<Person> search(int id);
	public <T> ResponseEntity<T> deletePerson(int id);
	public String updateUser(int id,String name,String surname,String gender);

}
