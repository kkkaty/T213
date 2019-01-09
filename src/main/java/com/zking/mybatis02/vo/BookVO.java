package com.zking.mybatis02.vo;

import com.zking.mybatis02.model.Book;

import java.util.List;

public class BookVO extends Book {
    private List<Integer> ids;
    private float minPrice;
    private float maxPrice;
    private String name;
    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
