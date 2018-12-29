package com.xiaoshu.seudcarsmallprograms.model;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;

@Table(name = "seller_information")
public class SellerInformation extends BaseTransientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String phone;

    private byte[] introduce;

    @Transient
    private String introduceStr;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return introduce
     */
    public byte[] getIntroduce() {
        return introduce;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @param introduce
     */
    public void setIntroduce(byte[] introduce) {
        this.introduce = introduce;
        if(StringUtils.isNotBlank(introduceStr)) {
            return;
        }
        if(introduce != null && introduce.length > 0) {
            try {
                String introduceStr = new String(introduce,"UTF-8") ;
                setIntroduceStr(introduceStr);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }

    public String getIntroduceStr() {
        return introduceStr;
    }

    public void setIntroduceStr(String introduceStr) {
        this.introduceStr = introduceStr;
        if(StringUtils.isNotBlank(introduceStr)) {
            byte[] bytes = introduceStr.getBytes();
            setIntroduce(bytes);
        }
    }

}