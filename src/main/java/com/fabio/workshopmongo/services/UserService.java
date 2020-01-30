package com.fabio.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.workshopmongo.domain.User;
import com.fabio.workshopmongo.dto.UserDto;
import com.fabio.workshopmongo.repository.UserRepository;
import com.fabio.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
		
	}
	
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
	}
	
	
	public User insert(User obj) {
		
		return repo.insert(obj);
		
		
	}
	
	public User fromDto(UserDto objDto) {
		
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	
	}
}
