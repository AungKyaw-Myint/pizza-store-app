package org.puralsight.model;

import org.puralsight.util.Helpers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Item> itemList;
    private LocalDateTime dateTime;
    private String custName;

    public Order() {
        itemList= new ArrayList<>();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public double calculateGrandTotal(){
        double totalPrice = itemList.stream()
                .mapToDouble(Item::getTotalPrice)
                .sum();

        return totalPrice;
    }

    public int getTotalItems(){
        int items = itemList.stream()
                .mapToInt(item -> item instanceof GarlicKnots
                        ? 1
                        : item.getQuantity())
                .sum();

        return items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "itemList=" + itemList +
                ", dateTime=" + dateTime +
                ", custName='" + custName + '\'' +
                '}';
    }

    public void printItemList(){
        for (Item item : itemList) {
            System.out.printf(
                    "%-1s   %-3s %-14s %-10s $%-8.2f Total: $%-8.2f%n",
                    Helpers.getIcon(item),
                    item.getQuantity(),
                    item.getName(),
                    "",
                    item.getPrice(),
                    item.getTotalPrice()
            );
        }
    }
}
