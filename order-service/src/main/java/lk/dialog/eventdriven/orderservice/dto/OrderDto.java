package lk.dialog.eventdriven.orderservice.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class OrderDto implements Serializable {
    private String name;
    private int quantity;
}
