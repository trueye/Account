package com.example.account.dto;

import com.example.account.aop.AccountLockIdInterface;
import com.example.account.type.TransactionResultType;
import lombok.*;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

public class UseBalance {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request implements AccountLockIdInterface {
        @NotNull
        @Min(1)
        private Long userId;

        @NotBlank
        @Size(min = 10, max = 10)
        private String accountNumber;

        @NotNull
        @Min(10)
        @Max(1000_000_000)
        private Long amount;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private String accountNumber;
        private TransactionResultType transactionResult;
        private String transactionId;
        private Long amount;
        private LocalDateTime transactedAt;


        public static Response from(TransactionalDto transactionalDto) {
            return Response.builder()
                    .accountNumber(transactionalDto.getAccountNumber())
                    .transactionResult(transactionalDto.getTransactionResultType())
                    .transactionId(transactionalDto.getTransactionId())
                    .amount(transactionalDto.getAmount())
                    .transactedAt(transactionalDto.getTransactedAt())
                    .build();
        }
    }
}
