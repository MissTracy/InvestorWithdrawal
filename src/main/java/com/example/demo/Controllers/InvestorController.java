package com.example.demo.Controllers;
/**Controllers handle incoming HTTP requests, interact with clients and services methods to perform business logic**/


import com.example.demo.Models.Investor;
import com.example.demo.Models.Products;
import com.example.demo.Services.InvestorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Api(tags = "investor")
@RestController
@RequestMapping("/api/investors")
public class InvestorController {

    @Autowired
    private InvestorService investorService;

    // Retrieve investor information by ID
//    @Operation
    @GetMapping("/{id}")
    @ApiOperation(value = "Get investor Id", response = Investor.class)
    public ResponseEntity<Investor> getInvestorById(@PathVariable Long id) {
        Investor investor = investorService.getInvestorById(id);;
        if (investor != null) {
            return new ResponseEntity<>(investor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Retrieve a list of products for a given investor
    @Operation
    @GetMapping("/{id}/products")
    @ApiOperation(value = "Get products for specified investor", response = Products.class)
    public ResponseEntity<List<Products>> getInvestorProducts(@PathVariable Long id) {
        List<Products> products = investorService.getInvestorProducts(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
