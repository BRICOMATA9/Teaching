/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wajid.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "transaction_details")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class TransactionEntry extends AuditModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;
    @NotBlank
    private String stockName;
    @NotNull
    private Double stockPrice;
    @NotNull
    private Long stockQuantity;
    @NotBlank
    private String transactionType;

    /**
     * @return the transactionId
     */
    public Long getTransactionId() {
        return transactionId;
    }

    /**
     * @param transactionId the transactionId to set
     */
    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * @return the stockName
     */
    public String getStockName() {
        return stockName;
    }

    /**
     * @param stockName the stockName to set
     */
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    /**
     * @return the stockPrice
     */
    public Double getStockPrice() {
        return stockPrice;
    }

    /**
     * @param stockPrice the stockPrice to set
     */
    public void setStockPrice(Double stockPrice) {
        this.stockPrice = stockPrice;
    }

    /**
     * @return the stockQuantity
     */
    public Long getStockQuantity() {
        return stockQuantity;
    }

    /**
     * @param stockQuantity the stockQuantity to set
     */
    public void setStockQuantity(Long stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    /**
     * @return the transactionType
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * @param transactionType the transactionType to set
     */
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
