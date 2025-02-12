package org.example.coffeeshop.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coffeeshop.entity.Status;
import org.example.coffeeshop.entity.User;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {
    private Long id;
    private User user;
    private double price;
    private Status status;
    private Date orderDate;
}
