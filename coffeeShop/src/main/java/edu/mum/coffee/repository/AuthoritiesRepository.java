package edu.mum.coffee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.coffee.domain.Authorities;
import edu.mum.coffee.domain.Users;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {
}
