package com.alexiades.model;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Transaction {


    @JsonIgnore
    private String transferId ;

    @JsonProperty(required = true)
    private String firstName;

    @JsonProperty(required = true)
    private String lastName;

    @JsonProperty(required = true)
    private String currencyCode;

    @JsonProperty(required = true)
    private Long fromAccountId;

    @JsonProperty(required = true)
    private Long toAccountId;

    @JsonProperty(required = true)
    private Date transdate;

    @JsonProperty(required = true)
    private BigDecimal amount;

    @JsonProperty(required = true)
    private String comment;

    public Transaction() {
    }

    public Transaction(String firstName,String lastName,String currencyCode, Long fromAccountId, Long toAccountId,Date transdate,BigDecimal amount,String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.currencyCode = currencyCode;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.transdate = transdate;
        this.amount = amount;
        this.comment = comment;
    }



    public String getTransferId() {

       transferId = getFirstName()+getTransdate().toString();

        return transferId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }

    public Long getToAccountId() {
        return toAccountId;
    }

    public Date getTransdate() {
        return transdate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getComment() {
        return comment;
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
        return transferId + "{"+ "firstName='" + firstName + '\''
                + ", lastName=" + lastName
                + ", currencyCode='" + currencyCode
                + ", fromAccountId=" + fromAccountId
                + ", toAccountId=" + toAccountId
                + ", transdate='" + transdate
                + ", amount='" + amount
                + ", comment=" + comment + '}';
    }

}
