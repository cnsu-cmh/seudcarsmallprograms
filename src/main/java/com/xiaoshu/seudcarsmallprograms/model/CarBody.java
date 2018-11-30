package com.xiaoshu.seudcarsmallprograms.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "car_body")
public class CarBody extends BaseTransientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * car_basics_id
     */
    @Column(name = "car_id")
    private Integer carId;

    /**
     * 宽(mm)
     */
    private Integer width;

    /**
     * 高(mm)
     */
    private Integer height;

    /**
     * 轴距(mm)
     */
    private Integer wheelbase;

    /**
     * 前轮距(mm)
     */
    @Column(name = "front_wheel_pitch")
    private Integer frontWheelPitch;

    /**
     * 后轮距(mm)
     */
    @Column(name = "rear_wheel_pitch")
    private Integer rearWheelPitch;

    /**
     * 车门数(个)
     */
    @Column(name = "door_num")
    private Integer doorNum;

    /**
     * 座位数(个)
     */
    @Column(name = "seat_num")
    private Integer seatNum;

    /**
     * 油箱容量(L)
     */
    @Column(name = "tank_capacity")
    private Integer tankCapacity;

    /**
     * 行李箱容量(L)
     */
    @Column(name = "trunk_capacity")
    private Integer trunkCapacity;

    /**
     * 整车质量(KG)
     */
    @Column(name = "vehicle_weight")
    private Integer vehicleWeight;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取car_basics_id
     *
     * @return car_id - car_basics_id
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * 设置car_basics_id
     *
     * @param carId car_basics_id
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    /**
     * 获取宽(mm)
     *
     * @return width - 宽(mm)
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 设置宽(mm)
     *
     * @param width 宽(mm)
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 获取高(mm)
     *
     * @return height - 高(mm)
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 设置高(mm)
     *
     * @param height 高(mm)
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 获取轴距(mm)
     *
     * @return wheelbase - 轴距(mm)
     */
    public Integer getWheelbase() {
        return wheelbase;
    }

    /**
     * 设置轴距(mm)
     *
     * @param wheelbase 轴距(mm)
     */
    public void setWheelbase(Integer wheelbase) {
        this.wheelbase = wheelbase;
    }

    /**
     * 获取前轮距(mm)
     *
     * @return front_wheel_pitch - 前轮距(mm)
     */
    public Integer getFrontWheelPitch() {
        return frontWheelPitch;
    }

    /**
     * 设置前轮距(mm)
     *
     * @param frontWheelPitch 前轮距(mm)
     */
    public void setFrontWheelPitch(Integer frontWheelPitch) {
        this.frontWheelPitch = frontWheelPitch;
    }

    /**
     * 获取后轮距(mm)
     *
     * @return rear_wheel_pitch - 后轮距(mm)
     */
    public Integer getRearWheelPitch() {
        return rearWheelPitch;
    }

    /**
     * 设置后轮距(mm)
     *
     * @param rearWheelPitch 后轮距(mm)
     */
    public void setRearWheelPitch(Integer rearWheelPitch) {
        this.rearWheelPitch = rearWheelPitch;
    }

    /**
     * 获取车门数(个)
     *
     * @return door_num - 车门数(个)
     */
    public Integer getDoorNum() {
        return doorNum;
    }

    /**
     * 设置车门数(个)
     *
     * @param doorNum 车门数(个)
     */
    public void setDoorNum(Integer doorNum) {
        this.doorNum = doorNum;
    }

    /**
     * 获取座位数(个)
     *
     * @return seat_num - 座位数(个)
     */
    public Integer getSeatNum() {
        return seatNum;
    }

    /**
     * 设置座位数(个)
     *
     * @param seatNum 座位数(个)
     */
    public void setSeatNum(Integer seatNum) {
        this.seatNum = seatNum;
    }

    /**
     * 获取油箱容量(L)
     *
     * @return tank_capacity - 油箱容量(L)
     */
    public Integer getTankCapacity() {
        return tankCapacity;
    }

    /**
     * 设置油箱容量(L)
     *
     * @param tankCapacity 油箱容量(L)
     */
    public void setTankCapacity(Integer tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    /**
     * 获取行李箱容量(L)
     *
     * @return trunk_capacity - 行李箱容量(L)
     */
    public Integer getTrunkCapacity() {
        return trunkCapacity;
    }

    /**
     * 设置行李箱容量(L)
     *
     * @param trunkCapacity 行李箱容量(L)
     */
    public void setTrunkCapacity(Integer trunkCapacity) {
        this.trunkCapacity = trunkCapacity;
    }

    /**
     * 获取整车质量(KG)
     *
     * @return vehicle_weight - 整车质量(KG)
     */
    public Integer getVehicleWeight() {
        return vehicleWeight;
    }

    /**
     * 设置整车质量(KG)
     *
     * @param vehicleWeight 整车质量(KG)
     */
    public void setVehicleWeight(Integer vehicleWeight) {
        this.vehicleWeight = vehicleWeight;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}