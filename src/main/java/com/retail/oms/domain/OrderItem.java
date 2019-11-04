package com.retail.oms.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class OrderItem implements Serializable {

    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "item_id")
    private Long item_id;

    private int item_quantity;

    private double item_price;
    private String billing_address;
    private String shipping_address;
    private String order_status;
    private String order_type;
    private String shipping_node;
    private Date expected_delivery_date;
    private Date actual_delivery_date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return item_quantity == orderItem.item_quantity &&
                Double.compare(orderItem.item_price, item_price) == 0 &&
                Objects.equals(order_id, orderItem.order_id) &&
                Objects.equals(item_id, orderItem.item_id) &&
                Objects.equals(billing_address, orderItem.billing_address) &&
                Objects.equals(shipping_address, orderItem.shipping_address) &&
                Objects.equals(order_status, orderItem.order_status) &&
                Objects.equals(order_type, orderItem.order_type) &&
                Objects.equals(shipping_node, orderItem.shipping_node) &&
                Objects.equals(expected_delivery_date, orderItem.expected_delivery_date) &&
                Objects.equals(actual_delivery_date, orderItem.actual_delivery_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, item_id, item_quantity, item_price, billing_address, shipping_address, order_status, order_type, shipping_node, expected_delivery_date, actual_delivery_date);
    }
}