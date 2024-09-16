package com.yash.banking.webervices.banking_web_services.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.annotation.processing.Generated;

@Entity(name = "account_types")
public class AccountTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String accountName;
    private double interestRate;
    private double amountLimit;

    private double depositLimit;

    public AccountTypes() {
    }

    public AccountTypes(int id, String accountName, double interestRate, double amountLimit, double depositLimit) {
        this.id = id;
        this.accountName = accountName;
        this.interestRate = interestRate;
        this.amountLimit = amountLimit;
        this.depositLimit = depositLimit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getAmountLimit() {
        return amountLimit;
    }

    public void setAmountLimit(double amountLimit) {
        this.amountLimit = amountLimit;
    }

    public double getDepositLimit() {
        return depositLimit;
    }

    public void setDepositLimit(double depositLimit) {
        this.depositLimit = depositLimit;
    }
}
