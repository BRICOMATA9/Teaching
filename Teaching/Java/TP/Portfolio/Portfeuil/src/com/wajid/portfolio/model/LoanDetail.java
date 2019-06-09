/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wajid.portfolio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "loan_details")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class LoanDetail extends AuditModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long loanId;
    @NotBlank
    private String loanName;
    @NotNull
    private Double loanAmount;
    @NotNull
    private Double interestRate;
    @NotNull
    private Integer loanPeriod;
    @NotNull
    private Integer paysInYear;    
    @NotNull
    private Date startDate;
    @NotNull
    private Double extraPayYear;

    /**
     * @return the loanId
     */
    public Long getLoanId() {
        return loanId;
    }

    /**
     * @param loanId the loanId to set
     */
    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    /**
     * @return the loanAmount
     */
    public Double getLoanAmount() {
        return loanAmount;
    }

    /**
     * @param loanAmount the loanAmount to set
     */
    public void setLoanAmount(Double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * @return the interestRate
     */
    public Double getInterestRate() {
        return interestRate;
    }

    /**
     * @param interestRate the interestRate to set
     */
    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * @return the loanPeriod
     */
    public Integer getLoanPeriod() {
        return loanPeriod;
    }

    /**
     * @param loanPeriod the loanPeriod to set
     */
    public void setLoanPeriod(Integer loanPeriod) {
        this.loanPeriod = loanPeriod;
    }

    /**
     * @return the paysInYear
     */
    public Integer getPaysInYear() {
        return paysInYear;
    }

    /**
     * @param paysInYear the paysInYear to set
     */
    public void setPaysInYear(Integer paysInYear) {
        this.paysInYear = paysInYear;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the extraPayYear
     */
    public Double getExtraPayYear() {
        return extraPayYear;
    }

    /**
     * @param extraPayYear the extraPayYear to set
     */
    public void setExtraPayYear(Double extraPayYear) {
        this.extraPayYear = extraPayYear;
    }

    /**
     * @return the loanName
     */
    public String getLoanName() {
        return loanName;
    }

    /**
     * @param loanName the loanName to set
     */
    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    
}
