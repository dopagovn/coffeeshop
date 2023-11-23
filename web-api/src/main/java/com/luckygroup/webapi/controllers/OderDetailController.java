package com.luckygroup.webapi.controllers;

import com.luckygroup.webapi.models.OderDetail;
import com.luckygroup.webapi.services.OderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api/v1")
public class OderDetailController {

    @Autowired
    private OderDetailService oderDetailService;

    @GetMapping(path = "/oder-details")
    public ResponseEntity<?> getAllOderDetails() {
        Optional<List<OderDetail>> oderDetails = oderDetailService.getAllOrderDetails();
        if (oderDetails.isPresent()) {
            return ResponseEntity.ok(oderDetails.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Order details not found");
        }
    }

    @GetMapping(path = "/oder-detail")
    public ResponseEntity<?> getOderDetailById(@RequestParam Integer id) {
        Optional<OderDetail> oderDetail = oderDetailService.findById(id);

        if (oderDetail.isPresent()) {
            return ResponseEntity.ok(oderDetail.get());
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Order detail not found");
        }
    }

    @PostMapping(path = "/oder-detail")
    public ResponseEntity<String> saveOderDetail(@RequestBody OderDetail oderDetail) {
        oderDetailService.saveOrderDetail(oderDetail);
        return ResponseEntity.ok("Order detail saved successfully");
    }

    @DeleteMapping(path = "/oder-detail")
    public ResponseEntity<String> deleteOderDetail(@RequestParam Integer id) {
        oderDetailService.deleteOrderDetail(id);
        return ResponseEntity.ok("Order detail deleted successfully");
    }

    // Bổ sung các phương thức khác tại đây

    // Ví dụ:
    @GetMapping(path = "/oder-details-by-oder")
    public ResponseEntity<?> getOderDetailsByOrderId(@RequestParam Integer orderId) {
        Optional<OderDetail> oderDetails = oderDetailService.getOrderDetailsByOrderId(orderId);
        if (!oderDetails.isEmpty()) {
            return ResponseEntity.ok(oderDetails);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Order details not found for the given order ID");
        }
    }
}
