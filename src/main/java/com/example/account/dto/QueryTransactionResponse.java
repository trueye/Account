package com.example.account.dto;

import com.example.account.type.TransactionResultType;
import com.example.account.type.TransactionType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QueryTransactionResponse {
    private String accountNumber;
    private TransactionType transactionType;
    private TransactionResultType transactionResult;
    private String transactionId;
    private Long amount;
    private LocalDateTime transactedAt;


    public static QueryTransactionResponse from(TransactionalDto transactionalDto) {
        return QueryTransactionResponse.builder()
                .accountNumber(transactionalDto.getAccountNumber())
                .transactionType(transactionalDto.getTransactionType())
                .transactionResult(transactionalDto.getTransactionResultType())
                .transactionId(transactionalDto.getTransactionId())
                .amount(transactionalDto.getAmount())
                .transactedAt(transactionalDto.getTransactedAt())
                .build();
    }
}
