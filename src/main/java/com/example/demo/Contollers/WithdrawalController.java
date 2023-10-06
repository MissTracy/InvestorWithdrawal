package com.example.demo.Contollers;
/**Controllers handle incoming HTTP requests, interact with clients and services methods to perform business logic**/


import com.example.demo.Models.Withdrawal;
import com.example.demo.Services.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/withdrawals")
public class WithdrawalController {

    private final WithdrawalService withdrawalService;

    @Autowired
    public WithdrawalController(WithdrawalService withdrawalService) {
        this.withdrawalService = withdrawalService;
    }

    @PostMapping("/{productId}/create")
    public ResponseEntity<String> createWithdrawal(
            @PathVariable Long productId,
            @RequestBody Withdrawal withdrawals) {

        //aag problem with id
//        Long investorId = null;
        Long investorId = withdrawals.getInvestorId();


        boolean withdrawalSuccessful = withdrawalService.createWithdrawal(investorId, productId, withdrawals);
        if (withdrawalSuccessful) {
            return new ResponseEntity<>("Withdrawal created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Withdrawal failed", HttpStatus.BAD_REQUEST);
        }
    }
}