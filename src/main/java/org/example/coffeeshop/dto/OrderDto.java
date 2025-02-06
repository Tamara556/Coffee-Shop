package org.example.coffeeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coffeeshop.entity.User;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private int id;
    private User user;
    private double price;
    private String status;
    private Date orderDate;
}
