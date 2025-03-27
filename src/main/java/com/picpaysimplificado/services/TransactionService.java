package com.picpaysimplificado.services;

import com.picpaysimplificado.DTOs.TransactionDTO;
import com.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    NotificationService notificationService;

    public Transaction createTransaction(TransactionDTO transactionDTO) throws Exception {
        User sender = userService.findUserById(transactionDTO.senderid());
        User receiver = userService.findUserById(transactionDTO.receiverid());

        BigDecimal value = transactionDTO.value();

        userService.validateTransaction(sender,value);

        boolean authorizedTransaction  = authorizeTransaction(sender,value);
        if (!authorizedTransaction){
            throw new Exception("Transação não autorizada");
        }
        Transaction transaction = new Transaction();
        transaction.setSender(sender);
        transaction.setReceiver(receiver);
        transaction.setAmount(value);
        transaction.setTimestamp(LocalDateTime.now());

        //atualizar o saldo
        sender.setBalance(sender.getBalance().subtract(value));
        receiver.setBalance(receiver.getBalance().add(value));

        transactionRepository.save(transaction);
        userService.saveUser(sender);
        userService.saveUser(receiver);
        System.out.println(" ************************ TRANSAÇÃO REALIZADA COM SUCESSO ******************************");

//        notificationService.sendNotification(sender, "Transação realizada com sucesso!");
//        notificationService.sendNotification(receiver, "Transação recebida com sucesso!");

        return transaction;
    }

    public boolean authorizeTransaction(User sender, BigDecimal value){
        return true;
    }
}
