package edu.mum.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.Users;
import edu.mum.coffee.repository.UsersRepository;

@Service
@Transactional
public class UsersService {
	@Autowired
	private UsersRepository UsersRepository;

	public Users saveUsers(Users Users) {
		return UsersRepository.save(Users);
	}

	public List<Users> findByUsername(String username) {
		return UsersRepository.findByUsername(username);
	}

	public Users findById(Long id) {
		return UsersRepository.findOne(id);
	}

	public void removeUsers(Users Users) {
		UsersRepository.delete(Users);
	}

	public List<Users> getAllUsers() {
		return  UsersRepository.findAll() ;
	}
}
