package com.allo.hrpayroll.resources;

import com.allo.hrpayroll.entities.Payment;
import com.allo.hrpayroll.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/payments")
public class PaymentResource {

    private final PaymentService service;

    @GetMapping("/{workerid}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerid, @PathVariable Integer days){
        Payment payment = service.getPayment(workerid, days);
        return ResponseEntity.ok(payment);
    }
}
