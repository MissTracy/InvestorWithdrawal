package com.example.demo.Contollers;
/**Controllers handle incoming HTTP requests, interact with clients and services methods to perform business logic**/


import com.example.demo.Models.Products;
import com.example.demo.Services.InvestorService;
//import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/investors")
public class InvestorController {

    @Autowired
    private InvestorService investorService;

    // Retrieve investor information by ID
//    @Operation
    @GetMapping("/{id}")
    public ResponseEntity<InvestorService> getInvestorById(@PathVariable Long id) {
        InvestorService investor = investorService;
        if (investor != null) {
            return new ResponseEntity<>(investor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Retrieve a list of products for a given investor
//    @Operation
    @GetMapping("/{id}/products")
    public ResponseEntity<List<Products>> getInvestorProducts(@PathVariable Long id) {
        List<Products> products = investorService.getInvestorProducts(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
