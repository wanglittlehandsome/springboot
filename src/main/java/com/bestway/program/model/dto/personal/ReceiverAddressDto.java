package com.bestway.program.model.dto.personal;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增收货地址参数")
public class ReceiverAddressDto {

    @ApiModelProperty("用户ID")
    private Integer userID;

    @ApiModelProperty("收货人")
    private String receiverName;

    @ApiModelProperty("联系电话")
    private String mobile;

    @ApiModelProperty("省ID")
    private Long province;

    @ApiModelProperty("市ID")
    private Long city;

    @ApiModelProperty("区ID")
    private Long district;

    @ApiModelProperty("省名")
    private String provinceName;

    @ApiModelProperty("市名")
    private String cityName;

    @ApiModelProperty("区名")
    private String districtName;

    @ApiModelProperty("详细地址")
    private String address;

    public ReceiverAddressDto() {
        super();
    }

    public ReceiverAddressDto(Integer userID, String receiverName, String mobile, Long province, Long city, Long district, String address) {
        this.userID = userID;
        this.receiverName = receiverName;
        this.mobile = mobile;
        this.province = province;
        this.city = city;
        this.district = district;
        this.address = address;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getProvince() {
        return province;
    }

    public void setProvince(Long province) {
        this.province = province;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public Long getDistrict() {
        return district;
    }

    public void setDistrict(Long district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
