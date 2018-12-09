package com.xiaoshu.seudcarsmallprograms.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class CarBasicsVo  implements Serializable {

    private static final long serialVersionUID = -5533974224467248974L;

    private Long id;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 车型
     */
    private String type;

    /**
     * 名称
     */
    private String name;

    /**
     * 级别
     */
    private String level;

    /**
     * 发动机（2.0T 286马力 L4）
     */
    private String engine;

    /**
     * 车身结构
     */
    private String carStructure;

    /**
     * 整车质保
     */
    private String guarantee;

    /**
     * 首次上牌
     */
    private String playingCards;

    /**
     * 价格
     */
    private BigDecimal sellingPrice;

    /**
     * 首页图片地址
     */
    private String welPic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getCarStructure() {
        return carStructure;
    }

    public void setCarStructure(String carStructure) {
        this.carStructure = carStructure;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    public String getPlayingCards() {
        return playingCards;
    }

    public void setPlayingCards(String playingCards) {
        this.playingCards = playingCards;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getWelPic() {
        return welPic;
    }

    public void setWelPic(String welPic) {
        this.welPic = welPic;
    }

    @Override
    public String toString() {
        return "CarBasicsDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                ", engine='" + engine + '\'' +
                ", carStructure='" + carStructure + '\'' +
                ", guarantee='" + guarantee + '\'' +
                ", playingCards='" + playingCards + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", welPic='" + welPic + '\'' +
                '}';
    }
}
