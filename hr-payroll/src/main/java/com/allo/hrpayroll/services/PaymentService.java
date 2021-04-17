package com.allo.hrpayroll.services;

import com.allo.hrpayroll.entities.Payment;
import com.allo.hrpayroll.entities.Worker;
import com.allo.hrpayroll.feignClients.WorkerFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long workerId, Integer days){
        Worker worker = workerFeignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
