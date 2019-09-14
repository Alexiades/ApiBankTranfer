package com.alexiades.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



public class Account {

        @JsonIgnore
        private long accountId ;

        @JsonProperty(required = true)
        private String userName;

        @JsonProperty(required = true)
        private Double balance;


        @JsonProperty(required = true)
        private String currencyCode;


        public Account() {}

        public Account(String userName,Double balance, String currencyCode) {
            this.userName = userName;
            this.balance = balance;
            this.currencyCode = currencyCode;
        }

        public Account(long accountId, String userName,Double balance, String currencyCode) {
            this.accountId = accountId;
            this.userName = userName;
            this.balance = balance;
            this.currencyCode = currencyCode;
        }

        public long getAccountId() {
            return accountId;
        }

        public String getUserName() {
            return userName;
        }

        public Double getBalance() {
            return balance;
        }

        public String getCurrencyCode() {
            return currencyCode;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            com.alexiades.model.Account user = (com.alexiades.model.Account) o;

            if (accountId != user.accountId) return false;
            if (!userName.equals(user.userName)) return false;
            return currencyCode.equals(user.currencyCode);

        }

        @Override
        public int hashCode() {
            int result = (int) (accountId ^ (accountId >>> 32));
            result = 31 * result + userName.hashCode();
            result = 31 * result + currencyCode.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return accountId + "{" +
                    "userName=" + userName +
                    ", balance='" + balance + '\'' +
                    ", currencyCode='" + currencyCode + '\'' +
                    '}';
        }
    }


