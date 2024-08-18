package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    public static int generatedId=0;
    private String userId;
    private String accountId;
    private Enum type;
    private String createdAt;
    private BigDecimal balance;
}
