package com.alexiades.model;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Transaction {

    @JsonProperty(required = true)
    private String currencyCode;

    @JsonProperty(required = true)
    private BigDecimal amount;

    @JsonProperty(required = true)
    private Long fromAccountId;

    @JsonProperty(required = true)
    private Long toAccountId;




    public Transaction() {
    }

    public Transaction(String currencyCode, BigDecimal amount, Long fromAccountId, Long toAccountId) {
        this.currencyCode = currencyCode;
        this.amount = amount;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }



@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Transaction that = (Transaction) o;

        if (!currencyCode.equals(that.currencyCode))
            return false;
        if (!amount.equals(that.amount))
            return false;
        if (!fromAccountId.equals(that.fromAccountId))
            return false;
        return toAccountId.equals(that.toAccountId);

    }

    @Override
    public int hashCode() {
        int result = currencyCode.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + fromAccountId.hashCode();
        result = 31 * result + toAccountId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" + "currencyCode='" + currencyCode + '\'' + ", amount=" + amount + ", fromAccountId="
                + fromAccountId + ", toAccountId=" + toAccountId + '}';
    }

}