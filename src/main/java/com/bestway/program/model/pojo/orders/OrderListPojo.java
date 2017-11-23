package com.bestway.program.model.pojo.orders;

import com.bestway.program.model.pojo.product.HealthExamItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel("持卡预约列表")
public class OrderListPojo implements Serializable {
    @ApiModelProperty(value = "套餐名称")
    private String productName;

    @ApiModelProperty(value = "套餐图片")
    private String fullPic;

    @ApiModelProperty(value = "价格")
    private Double price;

    @ApiModelProperty(value = "订单状态")
    private String status;

    @ApiModelProperty(value = "医院名称")
    private String hospitalName;

    @ApiModelProperty(value = "医院地址")
    private String address;

    @ApiModelProperty(value = "预约时间")
    private String schedule;

    @ApiModelProperty(value = "预约人")
    private String subscriber;

    @ApiModelProperty(value = "单项检查")
    private List<HealthExamItem> healthExamItem;

    public List<HealthExamItem> getHealthExamItem() {
        return healthExamItem;
    }

    public void setHealthExamItem(List<HealthExamItem> healthExamItem) {
        this.healthExamItem = healthExamItem;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFullPic() {
        return fullPic;
    }

    public void setFullPic(String fullPic) {
        this.fullPic = fullPic;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }
}
