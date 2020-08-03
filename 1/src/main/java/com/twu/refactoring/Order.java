package com.twu.refactoring;

import java.util.List;

public class Order {
    private String name;
    private String addr;
    private List<LineItem> lineItemList;

    public Order(String nm, String addr, List<LineItem> li) {
        this.name = nm;
        this.addr = addr;
        this.lineItemList = li;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return lineItemList;
    }
}
