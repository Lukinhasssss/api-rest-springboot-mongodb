package com.lucasmonteiro.apimongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasmonteiro.apimongodb.domain.User;
import com.lucasmonteiro.apimongodb.dto.UserDTO;
import com.lucasmonteiro.apimongodb.repositories.UserRepository;
import com.lucasmonteiro.apimongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public void delete(String id) {
		findById(id); // Se não encontrar o id já lança uma exceção
		repository.deleteById(id);
	}
	
	public User update(User user) {
		User newUser = findById(user.getId());
		updateUser(newUser, user);
		return repository.save(newUser);
	}

	private void updateUser(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}
	
	// Método que pega um DTO e instancia um usuário
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}

}
