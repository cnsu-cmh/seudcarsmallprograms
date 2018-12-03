package com.xiaoshu.seudcarsmallprograms.dto;

import java.io.Serializable;

public class CarSellerDto implements Serializable {

    private static final long serialVersionUID = 7665061321762283241L;

    private Long carId;

    private Long sellerId;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
