package com.xiaoshu.seudcarsmallprograms.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "car_basics")
public class CarBasics extends BaseEntity<Long> {

    private static final long serialVersionUID = 4976087425280780950L;

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
     * 厂家指导价（元）
     */
    @Column(name = "guidance_price")
    private BigDecimal guidancePrice;

    /**
     * 厂商（奥迪进口）
     */
    private String manufacturer;

    /**
     * 级别
     */
    private String level;

    /**
     * 上市时间
     */
    @Column(name = "market_time")
    private String marketTime;

    /**
     * 能源类型（汽油）
     */
    @Column(name = "energy_type")
    private String energyType;

    /**
     * 最大功率（kw）
     */
    @Column(name = "max_power")
    private String maxPower;

    /**
     * 发动机（2.0T 286马力 L4）
     */
    private String engine;

    /**
     * 变速箱(6挡双离合)
     */
    @Column(name = "gear_box")
    private String gearBox;

    /**
     * 车身结构
     */
    @Column(name = "car_structure")
    private String carStructure;

    /**
     * 0~100加速
     */
    private String acceleration;

    /**
     * 耗油
     */
    @Column(name = "oyster_sauce")
    private String oysterSauce;

    /**
     * 整车质保
     */
    private String guarantee;

    /**
     * 颜色
     */
    private String colour;

    /**
     * 首次上牌
     */
    @Column(name = "playing_cards")
    private String playingCards;

    /**
     * 价格
     */
    @Column(name = "selling_price")
    private BigDecimal sellingPrice;

    /**
     * 首页图片地址
     */
    @Column(name = "wel_pic")
    private String welPic;

    /**
     *   状态
     */
    private Integer status;


    /**
     * 获取品牌
     *
     * @return brand - 品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置品牌
     *
     * @param brand 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    /**
     * 获取车型
     *
     * @return type - 车型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置车型
     *
     * @param type 车型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取厂家指导价（元）
     *
     * @return guidance_price - 厂家指导价（元）
     */
    public BigDecimal getGuidancePrice() {
        return guidancePrice;
    }

    /**
     * 设置厂家指导价（元）
     *
     * @param guidancePrice 厂家指导价（元）
     */
    public void setGuidancePrice(BigDecimal guidancePrice) {
        this.guidancePrice = guidancePrice;
    }

    /**
     * 获取厂商（奥迪进口）
     *
     * @return manufacturer - 厂商（奥迪进口）
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * 设置厂商（奥迪进口）
     *
     * @param manufacturer 厂商（奥迪进口）
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    /**
     * 获取级别
     *
     * @return level - 级别
     */
    public String getLevel() {
        return level;
    }

    /**
     * 设置级别
     *
     * @param level 级别
     */
    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    /**
     * 获取上市时间
     *
     * @return market_time - 上市时间
     */
    public String getMarketTime() {
        return marketTime;
    }

    /**
     * 设置上市时间
     *
     * @param marketTime 上市时间
     */
    public void setMarketTime(String marketTime) {
        this.marketTime = marketTime == null ? null : marketTime.trim();
    }

    /**
     * 获取能源类型（汽油）
     *
     * @return energy_type - 能源类型（汽油）
     */
    public String getEnergyType() {
        return energyType;
    }

    /**
     * 设置能源类型（汽油）
     *
     * @param energyType 能源类型（汽油）
     */
    public void setEnergyType(String energyType) {
        this.energyType = energyType == null ? null : energyType.trim();
    }

    /**
     * 获取最大功率（kw）
     *
     * @return max_power - 最大功率（kw）
     */
    public String getMaxPower() {
        return maxPower;
    }

    /**
     * 设置最大功率（kw）
     *
     * @param maxPower 最大功率（kw）
     */
    public void setMaxPower(String maxPower) {
        this.maxPower = maxPower == null ? null : maxPower.trim();
    }

    /**
     * 获取发动机（2.0T 286马力 L4）
     *
     * @return engine - 发动机（2.0T 286马力 L4）
     */
    public String getEngine() {
        return engine;
    }

    /**
     * 设置发动机（2.0T 286马力 L4）
     *
     * @param engine 发动机（2.0T 286马力 L4）
     */
    public void setEngine(String engine) {
        this.engine = engine == null ? null : engine.trim();
    }

    /**
     * 获取变速箱(6挡双离合)
     *
     * @return gear-box - 变速箱(6挡双离合)
     */
    public String getGearBox() {
        return gearBox;
    }

    /**
     * 设置变速箱(6挡双离合)
     *
     * @param gearBox 变速箱(6挡双离合)
     */
    public void setGearBox(String gearBox) {
        this.gearBox = gearBox == null ? null : gearBox.trim();
    }

    /**
     * 获取车身结构
     *
     * @return car_structure - 车身结构
     */
    public String getCarStructure() {
        return carStructure;
    }

    /**
     * 设置车身结构
     *
     * @param carStructure 车身结构
     */
    public void setCarStructure(String carStructure) {
        this.carStructure = carStructure == null ? null : carStructure.trim();
    }

    /**
     * 获取0~100加速
     *
     * @return acceleration - 0~100加速
     */
    public String getAcceleration() {
        return acceleration;
    }

    /**
     * 设置0~100加速
     *
     * @param acceleration 0~100加速
     */
    public void setAcceleration(String acceleration) {
        this.acceleration = acceleration == null ? null : acceleration.trim();
    }

    /**
     * 获取耗油
     *
     * @return oyster_sauce - 耗油
     */
    public String getOysterSauce() {
        return oysterSauce;
    }

    /**
     * 设置耗油
     *
     * @param oysterSauce 耗油
     */
    public void setOysterSauce(String oysterSauce) {
        this.oysterSauce = oysterSauce == null ? null : oysterSauce.trim();
    }

    /**
     * 获取整车质保
     *
     * @return guarantee - 整车质保
     */
    public String getGuarantee() {
        return guarantee;
    }

    /**
     * 设置整车质保
     *
     * @param guarantee 整车质保
     */
    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee == null ? null : guarantee.trim();
    }

    /**
     * 获取颜色
     *
     * @return colour - 颜色
     */
    public String getColour() {
        return colour;
    }

    /**
     * 设置颜色
     *
     * @param colour 颜色
     */
    public void setColour(String colour) {
        this.colour = colour == null ? null : colour.trim();
    }

    /**
     * 获取首次上牌
     *
     * @return playing_cards - 首次上牌
     */
    public String getPlayingCards() {
        return playingCards;
    }

    /**
     * 设置首次上牌
     *
     * @param playingCards 首次上牌
     */
    public void setPlayingCards(String playingCards) {
        this.playingCards = playingCards;
    }

    /**
     * 获取价格
     *
     * @return selling_price - 价格
     */
    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    /**
     * 设置价格
     *
     * @param sellingPrice 价格
     */
    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getWelPic() {
        return welPic;
    }

    public void setWelPic(String welPic) {
        this.welPic = welPic;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}