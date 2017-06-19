package edu.mum.coffee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.coffee.domain.Authorities;
import edu.mum.coffee.domain.Users;
import edu.mum.coffee.repository.AuthoritiesRepository;

@Service
@Transactional
public class AuthoritiesService {
	@Autowired
	private AuthoritiesRepository AuthoritiesRepository;
	

	public Authorities saveAuthorities(Authorities Authorities) {
		return AuthoritiesRepository.save(Authorities);
	}


}
