package com.br.crudspring.entities;

import com.br.crudspring.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPK id =  new OrderItemPK();
    private Double price;
    private Integer quantity;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product,  Integer quantity, Double price) {
        id.setOrder (order);
        id.setProduct(product);
        this.price = price;
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @JsonIgnore
    public Order getOrder (){
        return id.getOrder();
    }
    public Product getProduct (){
        return id.getProduct();
    }
    public void setProduct(Product product){
        id.setProduct(product);
    }
    public void setOrder(Order order){
        id.setOrder(order);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
