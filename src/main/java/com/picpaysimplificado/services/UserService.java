package com.picpaysimplificado.services;

import java.math.BigDecimal;

import com.picpaysimplificado.domain.user.userType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public void validateTransaction(User sender, BigDecimal amount) throws Exception {

		if(sender.getBalance().compareTo(amount) < 0){
			throw new Exception("Saldo Insuficiente");
		}
		if(sender.getUserType() == userType.MERCHANT){
			throw new Exception("Lojista Não pode enviar pagamemtos");
		}
	}

	public User findUserById(long id) throws Exception {
		return repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
	}

	public 	void saveUser(User user){
		this.repository.save(user);
	}

}
