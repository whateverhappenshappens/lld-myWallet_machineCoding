package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    public static int generatedId=0;
    private String id;
    private String From;
    private String To;
    private String createdAt;
    private Enum transactionType;
    private BigDecimal TransferAmount;
}
