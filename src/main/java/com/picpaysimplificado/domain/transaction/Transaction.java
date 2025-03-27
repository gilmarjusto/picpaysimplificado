package com.picpaysimplificado.domain.transaction;

import com.picpaysimplificado.DTOs.TransactionDTO;
import com.picpaysimplificado.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "transactions")
@Table(name = "transactions")

public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private BigDecimal amount;

	@ManyToOne
	@JoinColumn(name = "sender_id")
	private User sender;

	@ManyToOne
	@JoinColumn(name = "receiver_id")
	private User receiver;

	private LocalDateTime timestamp;

	public Transaction() {
	}

	public long getId() {
		return id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public User getSender() {
		return sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Transaction that = (Transaction) o;
		return id == that.id && Objects.equals(amount, that.amount) && Objects.equals(sender, that.sender) && Objects.equals(receiver, that.receiver) && Objects.equals(timestamp, that.timestamp);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, amount, sender, receiver, timestamp);
	}
}
