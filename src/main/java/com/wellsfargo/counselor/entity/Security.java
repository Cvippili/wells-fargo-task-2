package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long securityId; // No Setter, only a Getter

    @Column(nullable = false)
    private String securityName;

    @Column(nullable = false)
    private String securityCategory;

    @Column(nullable = false)
    private BigDecimal purchasePrice; // Use BigDecimal for monetary values

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private LocalDate purchaseDate;

    // Many-to-One relationship to Portfolio (each Security belongs to a single Portfolio)
    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)  // Portfolio foreign key column
    private Portfolio portfolio;

    // Default constructor (required for JPA)
    protected Security() {
    }

    // Constructor for Security entity
    public Security(String securityName, String securityCategory, BigDecimal purchasePrice, int quantity, LocalDate purchaseDate, Portfolio portfolio) {
        this.securityName = securityName;
        this.securityCategory = securityCategory;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
        this.portfolio = portfolio; // Assign Portfolio object
    }

    // Getters and Setters
    public Long getSecurityId() {
        return securityId;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(String securityName) {
        this.securityName = securityName;
    }

    public String getSecurityCategory() {
        return securityCategory;
    }

    public void setSecurityCategory(String securityCategory) {
        this.securityCategory = securityCategory;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
}
