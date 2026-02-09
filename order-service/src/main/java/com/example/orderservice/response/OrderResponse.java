package com.example.orderservice.response;

public class OrderResponse {
    private Long orderId;
    private String orderStatus;
    private String orderFor;

    public OrderResponse(){}

    public OrderResponse(Long orderId, String orderStatus, String orderFor) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.orderFor = orderFor;
    }

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public String getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    public String getOrderFor() {
        return orderFor;
    }
    public void setOrderFor(String orderFor) {
        this.orderFor = orderFor;
    }
}
