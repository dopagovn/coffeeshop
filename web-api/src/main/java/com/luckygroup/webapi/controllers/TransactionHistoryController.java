// package com.luckygroup.webapi.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import com.luckygroup.webapi.models.TransactionHistory;
// import com.luckygroup.webapi.services.TransactionHistoryService;

// import java.util.List;

// @RestController
// @RequestMapping("/transactions")
// public class TransactionHistoryController {

//     @Autowired
//     private TransactionHistoryService transactionHistoryService;

//     // Endpoint lấy tất cả lịch sử giao dịch
//     @GetMapping
//     public List<TransactionHistory> getAllTransactions() {
//         return transactionHistoryService.getAllTransactions();
//     }

//     // Endpoint lấy lịch sử giao dịch theo ID
//     @GetMapping("/{id}")
//     public TransactionHistory getTransactionById(@PathVariable Long id) {
//         return transactionHistoryService.getTransactionById(id);
//     }

//     // Endpoint thêm mới một giao dịch
//     @PostMapping
//     public TransactionHistory addTransaction(@RequestBody TransactionHistory transactionHistory) {
//         return transactionHistoryService.addTransaction(transactionHistory);
//     }
// }
