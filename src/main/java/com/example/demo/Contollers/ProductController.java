package com.example.demo.Contollers;
/**Controllers handle incoming HTTP requests, interact with clients and services methods to perform business logic**/


import com.example.demo.Models.Investor;
import com.example.demo.Models.Products;
import com.example.demo.Services.InvestorService;
import com.example.demo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final InvestorService investorService;
    private final ProductService productService;

    @Autowired
    public ProductController(InvestorService investorService, ProductService productService) {
        this.investorService = investorService;
        this.productService = productService; // Inject the ProductService
    }

    // Retrieve a list of products for a given investor
    @GetMapping("/{investorId}/products")
    public ResponseEntity<List<Products>> getInvestorProducts(@PathVariable Long investorId) {
        List<Products> products = investorService.getInvestorProducts(investorId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Products productRequest) {
        Investor investor = new Investor();

        // Creating a new Products instance based on the requested data
        Products newProduct = new Products();
        newProduct.setProductName(productRequest.getProductName());
        newProduct.setBalance(productRequest.getBalance());
        newProduct.setProductType(productRequest.getProductType());
        newProduct.setInvestor(investor); // Set the investor for this product

        // Save the new product using a service
        productService.saveProduct(newProduct);

        // Return a response
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }

}
