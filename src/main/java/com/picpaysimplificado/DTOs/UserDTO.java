package com.picpaysimplificado.DTOs;

import com.picpaysimplificado.domain.user.userType;
import org.hibernate.id.IdentifierGeneratorHelper;
import org.hibernate.usertype.UserType;

import java.math.BigDecimal;

public record UserDTO(String firstname,
                      String lastname,
                      String document,
                      BigDecimal balance,
                      String email,
                      String password,
                      userType userType) {
}
