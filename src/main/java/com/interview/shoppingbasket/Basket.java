package com.interview.shoppingbasket;

import java.util.*;

public class Basket {
    private List<BasketItem> items = new ArrayList<>();

    public void add(String productCode, String productName, int quantity) {
        BasketItem basketItem = new BasketItem();
        basketItem.setProductCode(productCode);
        basketItem.setProductName(productName);
        basketItem.setQuantity(quantity);

        items.add(basketItem);
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void consolidateItems() {
        // Exercise - implement this function

    	for (int i = 0; i < items.size(); i++) {
    		for (int j = items.size() - 1; j >= 0; j--) {
    			if (items.get(i).getProductCode().equals(items.get(j).getProductCode()) && i != j) {
    				items.get(i).setQuantity(items.get(i).getQuantity() + items.get(j).getQuantity());
    				items.remove(j);
    			}
    		}
    	}
    }
}
