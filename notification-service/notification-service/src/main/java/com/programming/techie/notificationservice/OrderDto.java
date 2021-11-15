package com.programming.techie.notificationservice;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDto implements Serializable {
    private String name;
    private int quantity;
}
