package lk.dialog.eventdriven.orderservice.controller;

import lk.dialog.eventdriven.orderservice.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final StreamBridge streamBridge;

    @PostMapping(value = "/orders")
    public ResponseEntity<String> placeOrder(@RequestBody OrderDto orderDto) {
           log.info("Called create order controller.OrderDto:{}", orderDto.toString());
           try{
               streamBridge.send("inventoryEventSupplier-out-0", MessageBuilder.withPayload(orderDto.getName()).build());
               return new ResponseEntity<>("Success", org.springframework.http.HttpStatus.CREATED);
           }catch (Exception e){
               return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
           }
    }

    @PutMapping(value = "/orders")
    public String updateOrder(@RequestBody OrderDto orderDto) {
        log.info("Called update order controller:{}"+ orderDto.toString());
        streamBridge.send("inventoryEventSupplier-out-0", MessageBuilder.withPayload(orderDto.getName()).build());
        return "Order Update Successfully";
    }

    private Boolean handleErrorCase() {
        return false;
    }
}
