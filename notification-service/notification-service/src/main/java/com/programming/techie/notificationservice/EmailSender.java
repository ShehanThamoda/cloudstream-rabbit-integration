package com.programming.techie.notificationservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailSender {

    public void sendEmail(OrderDto orderDto) {
        log.info("============Your Order Placed Successfully==============");
        log.info("Item name"+"           Quantity");
        log.info("-"+orderDto.getName()+"                 "+orderDto.getQuantity());
        log.info("========================================================");

    }
}
