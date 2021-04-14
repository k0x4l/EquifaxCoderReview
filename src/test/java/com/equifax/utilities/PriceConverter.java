package com.equifax.utilities;

public class PriceConverter {
    public static Float getPrice(String ItemPrice){

        String price = ItemPrice.trim().substring(1,ItemPrice.length());

        if(price.contains("\n")) {
            String[] priceArray = price.trim().split("\n");
            price = priceArray[0].trim() + "." + priceArray[1].trim();
        }
        Float priceFloat = Float.valueOf(price);

        return priceFloat;
    }
}