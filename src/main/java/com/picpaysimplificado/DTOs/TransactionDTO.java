package com.picpaysimplificado.DTOs;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, long senderid, long receiverid) {
}
