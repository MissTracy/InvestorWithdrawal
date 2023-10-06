package com.example.demo.Models;
/**Models are entities of the app/data structures and are mapped to database tables **/


import jakarta.persistence.*;

import java.math.BigDecimal;

//class used to represent withdrawal request data
@Entity
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long investorId;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    public Long getInvestorId() {
        return investorId;
    }

    public void setInvestorId(Long investorId) {
        this.investorId = investorId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setProduct() {

    }

}