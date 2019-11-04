package com.retail.oms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="orders")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @EmbeddedId
    private OrderItem orderItem;

    //private Long order_id;

    @Column(nullable = false)
    private Long user_id;

    @Column(nullable = false)
    private double total_amount;

    @Column(nullable = false)
    private String payment_type;
}





