package com.example.demo.Services;
/** services encapsulate the business logic.Methods perform specific operations on the data, **/

import com.example.demo.Models.Investor;
import com.example.demo.Models.Products;
import com.example.demo.repos.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


//class responsible for interacting with the database
@Service
public class InvestorService {

    @Autowired
    private InvestorRepository investorRepository;


    //for test
    public InvestorService(InvestorRepository investorRepository) {

    }

    public Investor getInvestorById(Long id) {
        return investorRepository.findById(id).orElse(null);
    }

    public List<Products> getInvestorProducts(Long investorId) {
        Investor investor = investorRepository.findById(investorId).orElse(null);
        if (investor != null) {
            return investor.getProducts();
        }
        return null;
    }

}