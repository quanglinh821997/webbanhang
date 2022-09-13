package com.microtech.global;

import com.microtech.model.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public class GlobalData {
    // tao bien toan cuc
    public static List<Product> cart;

    static {
        cart = new ArrayList<>();
    }
}
