package com.order_service.controller;


import com.order_service.modal.OrderRequest;
import com.order_service.services.OrderService;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Log4j2
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Long>placeOrder(@RequestBody OrderRequest orderRequest){
      Long orderId=orderService.placeOrder(orderRequest);

      log.info("Order ID: "+orderId);
     return new ResponseEntity<>(orderId, HttpStatus.CREATED);
    }

}
