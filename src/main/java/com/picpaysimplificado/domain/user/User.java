package com.picpaysimplificado.domain.user;

import java.math.BigDecimal;

import com.picpaysimplificado.DTOs.UserDTO;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "users")
@Table(name = "users")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Nonnull
	private String firstName;
	@Nonnull
	private String lastName;

	@Column(unique = true)
	private String document;

	@Column(unique = true)
	private String mail;

	private String password;

	@Nonnull
	private BigDecimal balance;

	@Nonnull
	@Enumerated(EnumType.STRING)
	private userType userType;

	public User(UserDTO userDTO) {
		firstName = userDTO.firstname();
		lastName = userDTO.lastname();
		document = userDTO.document();
		balance = userDTO.balance();
		mail = userDTO.email();
		password = userDTO.password();
		userType = userDTO.userType();
	}

	public User() {
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getDocument() {
		return document;
	}

	public String getMail() {
		return mail;
	}

	public String getPassword() {
		return password;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public userType getUserType() {
		return userType;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public void setUserType(userType userType) {
		this.userType = userType;
	}
}
