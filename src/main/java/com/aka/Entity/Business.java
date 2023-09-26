package com.aka.Entity;

import java.math.BigDecimal;
import java.util.Date;

public class Business {
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String storeName;
    private String storeAddress;
    private String storeBlurb;
    private String mainImage;
    private Integer orderTypeId;
    private BigDecimal startPrice;
    private BigDecimal deliveryPrice;
    private String storeRemarks;
    private Integer storeStatus;
    private Date createTime;
    private Date updateTime;

    public Business() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreBlurb() {
        return storeBlurb;
    }

    public void setStoreBlurb(String storeBlurb) {
        this.storeBlurb = storeBlurb;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public Integer getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(Integer orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public BigDecimal getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(BigDecimal deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getStoreRemarks() {
        return storeRemarks;
    }

    public void setStoreRemarks(String storeRemarks) {
        this.storeRemarks = storeRemarks;
    }

    public Integer getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(Integer storeStatus) {
        this.storeStatus = storeStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storeBlurb='" + storeBlurb + '\'' +
                ", mainImage='" + mainImage + '\'' +
                ", orderTypeId=" + orderTypeId +
                ", startPrice=" + startPrice +
                ", deliveryPrice=" + deliveryPrice +
                ", storeRemarks='" + storeRemarks + '\'' +
                ", storeStatus=" + storeStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
