/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.datamodel.model.v1_0;

import com.library.datamodel.jaxb.config.v1_0.Amounttype;

/**
 *
 * @author smallgod
 */
public class MoMoPaymentMamboPay {

    private AccountToDebit accountToDebit;
    private AmountToDebit amountToDebit;
    private TransactionId transactionId;

    public AccountToDebit getAccountToDebit() {
        return accountToDebit;
    }

    public void setAccountToDebit(AccountToDebit accountToDebit) {
        this.accountToDebit = accountToDebit;
    }

    public AmountToDebit getAmountToDebit() {
        return amountToDebit;
    }

    public void setAmountToDebit(AmountToDebit amountToDebit) {
        this.amountToDebit = amountToDebit;
    }

    public TransactionId getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(TransactionId transactionId) {
        this.transactionId = transactionId;
    }

    public class AccountToDebit {

        private String accountToDebitParam;
        private String accountToDebitValue;

        public AccountToDebit(String accountToDebitParam, String accountToDebitValue) {

            this.accountToDebitParam = accountToDebitParam;
            this.accountToDebitValue = accountToDebitValue;
        }

        /**
         * @return the accountToDebitValue
         */
        public String getAccountToDebitValue() {
            return accountToDebitValue;
        }

        /**
         * @param accountToDebitValue the accountToDebitValue to set
         */
        public void setAccountToDebitValue(String accountToDebitValue) {
            this.accountToDebitValue = accountToDebitValue;
        }

        public String getAccountToDebitParam() {
            return accountToDebitParam;
        }

        public void setAccountToDebitParam(String accountToDebitParam) {
            this.accountToDebitParam = accountToDebitParam;
        }

    }

    public class AmountToDebit {

        private String amountToDebitParam;
        private Amounttype amountToDebitValue;

        public AmountToDebit(String amountToDebitParam, Amounttype amountToDebitValue) {
            this.amountToDebitParam = amountToDebitParam;
            this.amountToDebitValue = amountToDebitValue;
        }

        public Amounttype getAmountToDebitValue() {
            return amountToDebitValue;
        }

        public void setAmountToDebitValue(Amounttype amountToDebitValue) {
            this.amountToDebitValue = amountToDebitValue;
        }

        public String getAmountToDebitParam() {
            return amountToDebitParam;
        }

        public void setAmountToDebitParam(String amountToDebitParam) {
            this.amountToDebitParam = amountToDebitParam;
        }
    }

    public class TransactionId {

        private String transactionIdParam;
        private String transactionIdValue;

        public TransactionId(String transactionIdParam, String transactionIdValue) {
            this.transactionIdParam = transactionIdParam;
            this.transactionIdValue = transactionIdValue;
        }

        /**
         * @return the transactionIdValue
         */
        public String getTransactionIdValue() {
            return transactionIdValue;
        }

        /**
         * @param transactionIdValue the transactionIdValue to set
         */
        public void setTransactionIdValue(String transactionIdValue) {
            this.transactionIdValue = transactionIdValue;
        }

        public String getTransactionIdParam() {
            return transactionIdParam;
        }

        public void setTransactionIdParam(String transactionIdParam) {
            this.transactionIdParam = transactionIdParam;
        }
    }

}
