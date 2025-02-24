package com.order_service.serviceImpl;

import com.order_service.entity.OrderEntity;
import com.order_service.external.client.ProductService;
import com.order_service.modal.OrderRequest;
import com.order_service.repository.OrderRepository;
import com.order_service.services.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;


    @Override
    public Long placeOrder(OrderRequest orderRequest)    {

        log.info("Placing Order Request: {}",orderRequest);

           log.info("Calling Product Service to reduce quantity");

           productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());

           log.info("Creating Order with Status CREATED");

           OrderEntity order= OrderEntity.builder()
                   .amount(orderRequest.getTotalAmount())
                   .orderStatus("CREATED")
                   .productId(orderRequest.getProductId())
                   .orderDate(Instant.now())
                   .quantity(orderRequest.getQuantity())
                   .build();

           order=orderRepository.save(order);

           log.info("Order Placed Successfully with order id : {} ",order.getId());
           return  order.getId();











        //Payment Service -> payment -> Succcess -> Complete, Else cancel
    }
}
