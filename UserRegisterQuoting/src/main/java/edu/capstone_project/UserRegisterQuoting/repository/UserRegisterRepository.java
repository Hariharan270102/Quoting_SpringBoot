package edu.capstone_project.UserRegisterQuoting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.capstone_project.UserRegisterQuoting.model.UserRegister;

public interface UserRegisterRepository extends JpaRepository<UserRegister, Integer> {
	UserRegister findByEmail(String email);
	UserRegister findByPhonenumber(String phonenumber);

}
