package com.xiaoshu.seudcarsmallprograms.dto;



import java.io.Serializable;
import java.math.BigDecimal;

public class CarBasicsDto implements Serializable {

    private static final long serialVersionUID = -5002439323802603L;

    private String sort;
    private String  brand;
    private String type;
    private String level;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }
}
