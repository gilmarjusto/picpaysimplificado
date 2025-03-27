package com.picpaysimplificado.services;

import com.picpaysimplificado.DTOs.NotificationDTO;
import com.picpaysimplificado.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String mail = user.getMail();

        NotificationDTO notificationDTO = new NotificationDTO(mail, message);

        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("https://util.devi.tools/api/v1/notify", notificationDTO, String.class);

        if (!(notificationResponse.getStatusCode() == HttpStatus.OK)){
            System.out.println("Erro ao Enviar mensagem ao cliente ");
            throw new Exception("Erro ao Enviar mensagem ao cliente");
        }

    }
}
