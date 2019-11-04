package com.retail.oms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_types")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderTypes {
    @Id
    private String order_type;
    private String order_type_description;
    private int order_type_sla;


}
