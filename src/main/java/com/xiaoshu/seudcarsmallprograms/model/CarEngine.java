package com.xiaoshu.seudcarsmallprograms.model;

import javax.persistence.*;

@Table(name = "car_engine")
public class CarEngine extends BaseTransientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "car_id")
    private Integer carId;

    /**
     * 发动机型号
     */
    private String type;

    /**
     * 排量（ml）
     */
    private Integer displacement;

    /**
     * 排量L(2.0)
     */
    @Column(name = "displacement_l")
    private String displacementL;

    /**
     * 进气形式(涡轮增压)
     */
    @Column(name = "intake_form")
    private String intakeForm;

    /**
     * 气缸排列形式
     */
    @Column(name = "cylinder_arr")
    private String cylinderArr;

    /**
     * 气缸个数
     */
    @Column(name = "cylinder_num")
    private Integer cylinderNum;

    /**
     * 每缸气门数
     */
    @Column(name = "cylinder_valve")
    private Integer cylinderValve;

    /**
     * 最大马力(Ps)
     */
    @Column(name = "max_horsepower")
    private Integer maxHorsepower;

    /**
     * 最大功率(kw)
     */
    @Column(name = "max_power")
    private Integer maxPower;

    /**
     * 最大功率转速(rpm)
     */
    @Column(name = "max_power_speed")
    private String maxPowerSpeed;

    /**
     * 燃料形式
     */
    @Column(name = "fuel_form")
    private String fuelForm;

    /**
     * 燃油标号
     */
    @Column(name = "fuel_grade")
    private String fuelGrade;

    /**
     * 供油方式
     */
    @Column(name = "fuel_supply_mode")
    private String fuelSupplyMode;

    /**
     * 缸盖材料
     */
    @Column(name = "cylinder_head_material")
    private String cylinderHeadMaterial;

    /**
     * 缸体材料
     */
    @Column(name = "cylinder_block_material")
    private String cylinderBlockMaterial;

    /**
     * 环保标准
     */
    @Column(name = "env_protection")
    private String envProtection;

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
     * @return car_id
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * @param carId
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    /**
     * 获取发动机型号
     *
     * @return type - 发动机型号
     */
    public String getType() {
        return type;
    }

    /**
     * 设置发动机型号
     *
     * @param type 发动机型号
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取排量（ml）
     *
     * @return displacement - 排量（ml）
     */
    public Integer getDisplacement() {
        return displacement;
    }

    /**
     * 设置排量（ml）
     *
     * @param displacement 排量（ml）
     */
    public void setDisplacement(Integer displacement) {
        this.displacement = displacement;
    }

    /**
     * 获取排量L(2.0)
     *
     * @return displacement_l - 排量L(2.0)
     */
    public String getDisplacementL() {
        return displacementL;
    }

    /**
     * 设置排量L(2.0)
     *
     * @param displacementL 排量L(2.0)
     */
    public void setDisplacementL(String displacementL) {
        this.displacementL = displacementL == null ? null : displacementL.trim();
    }

    /**
     * 获取进气形式(涡轮增压)
     *
     * @return intake_form - 进气形式(涡轮增压)
     */
    public String getIntakeForm() {
        return intakeForm;
    }

    /**
     * 设置进气形式(涡轮增压)
     *
     * @param intakeForm 进气形式(涡轮增压)
     */
    public void setIntakeForm(String intakeForm) {
        this.intakeForm = intakeForm == null ? null : intakeForm.trim();
    }

    /**
     * 获取气缸排列形式
     *
     * @return cylinder_arr - 气缸排列形式
     */
    public String getCylinderArr() {
        return cylinderArr;
    }

    /**
     * 设置气缸排列形式
     *
     * @param cylinderArr 气缸排列形式
     */
    public void setCylinderArr(String cylinderArr) {
        this.cylinderArr = cylinderArr == null ? null : cylinderArr.trim();
    }

    /**
     * 获取气缸个数
     *
     * @return cylinder_num - 气缸个数
     */
    public Integer getCylinderNum() {
        return cylinderNum;
    }

    /**
     * 设置气缸个数
     *
     * @param cylinderNum 气缸个数
     */
    public void setCylinderNum(Integer cylinderNum) {
        this.cylinderNum = cylinderNum;
    }

    /**
     * 获取每缸气门数
     *
     * @return cylinder_valve - 每缸气门数
     */
    public Integer getCylinderValve() {
        return cylinderValve;
    }

    /**
     * 设置每缸气门数
     *
     * @param cylinderValve 每缸气门数
     */
    public void setCylinderValve(Integer cylinderValve) {
        this.cylinderValve = cylinderValve;
    }

    /**
     * 获取最大马力(Ps)
     *
     * @return max_horsepower - 最大马力(Ps)
     */
    public Integer getMaxHorsepower() {
        return maxHorsepower;
    }

    /**
     * 设置最大马力(Ps)
     *
     * @param maxHorsepower 最大马力(Ps)
     */
    public void setMaxHorsepower(Integer maxHorsepower) {
        this.maxHorsepower = maxHorsepower;
    }

    /**
     * 获取最大功率(kw)
     *
     * @return max_power - 最大功率(kw)
     */
    public Integer getMaxPower() {
        return maxPower;
    }

    /**
     * 设置最大功率(kw)
     *
     * @param maxPower 最大功率(kw)
     */
    public void setMaxPower(Integer maxPower) {
        this.maxPower = maxPower;
    }

    /**
     * 获取最大功率转速(rpm)
     *
     * @return max_power_speed - 最大功率转速(rpm)
     */
    public String getMaxPowerSpeed() {
        return maxPowerSpeed;
    }

    /**
     * 设置最大功率转速(rpm)
     *
     * @param maxPowerSpeed 最大功率转速(rpm)
     */
    public void setMaxPowerSpeed(String maxPowerSpeed) {
        this.maxPowerSpeed = maxPowerSpeed == null ? null : maxPowerSpeed.trim();
    }

    /**
     * 获取燃料形式
     *
     * @return fuel_form - 燃料形式
     */
    public String getFuelForm() {
        return fuelForm;
    }

    /**
     * 设置燃料形式
     *
     * @param fuelForm 燃料形式
     */
    public void setFuelForm(String fuelForm) {
        this.fuelForm = fuelForm == null ? null : fuelForm.trim();
    }

    /**
     * 获取燃油标号
     *
     * @return fuel_grade - 燃油标号
     */
    public String getFuelGrade() {
        return fuelGrade;
    }

    /**
     * 设置燃油标号
     *
     * @param fuelGrade 燃油标号
     */
    public void setFuelGrade(String fuelGrade) {
        this.fuelGrade = fuelGrade == null ? null : fuelGrade.trim();
    }

    /**
     * 获取供油方式
     *
     * @return fuel_supply_mode - 供油方式
     */
    public String getFuelSupplyMode() {
        return fuelSupplyMode;
    }

    /**
     * 设置供油方式
     *
     * @param fuelSupplyMode 供油方式
     */
    public void setFuelSupplyMode(String fuelSupplyMode) {
        this.fuelSupplyMode = fuelSupplyMode == null ? null : fuelSupplyMode.trim();
    }

    /**
     * 获取缸盖材料
     *
     * @return cylinder_head_material - 缸盖材料
     */
    public String getCylinderHeadMaterial() {
        return cylinderHeadMaterial;
    }

    /**
     * 设置缸盖材料
     *
     * @param cylinderHeadMaterial 缸盖材料
     */
    public void setCylinderHeadMaterial(String cylinderHeadMaterial) {
        this.cylinderHeadMaterial = cylinderHeadMaterial == null ? null : cylinderHeadMaterial.trim();
    }

    /**
     * 获取缸体材料
     *
     * @return cylinder_block_material - 缸体材料
     */
    public String getCylinderBlockMaterial() {
        return cylinderBlockMaterial;
    }

    /**
     * 设置缸体材料
     *
     * @param cylinderBlockMaterial 缸体材料
     */
    public void setCylinderBlockMaterial(String cylinderBlockMaterial) {
        this.cylinderBlockMaterial = cylinderBlockMaterial == null ? null : cylinderBlockMaterial.trim();
    }

    /**
     * 获取环保标准
     *
     * @return env_protection - 环保标准
     */
    public String getEnvProtection() {
        return envProtection;
    }

    /**
     * 设置环保标准
     *
     * @param envProtection 环保标准
     */
    public void setEnvProtection(String envProtection) {
        this.envProtection = envProtection == null ? null : envProtection.trim();
    }
}