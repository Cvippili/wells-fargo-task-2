package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;  // No Setter, only a Getter

    // ManyToOne relationship to Client (since each portfolio belongs to a single client)
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)  // Defines the foreign key column in the Portfolio table
    private Client client;

    @Column(nullable = false)
    private LocalDate creationDate;

    // Default constructor (required by JPA)
    protected Portfolio() {
    }

    // Constructor with client object (clientId is automatically handled by JPA)
    public Portfolio(Client client) {
        this.client = client;
        this.creationDate = LocalDate.now();  // Default to current date if not provided
    }

    // Getters
    public Long getPortfolioId() {
        return portfolioId;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    // Setters
    public void setClient(Client client) {
        this.client = client;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
