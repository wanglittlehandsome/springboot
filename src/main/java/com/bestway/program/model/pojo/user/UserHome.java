package com.bestway.program.model.pojo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 
 * 说明：个人中心首页
 * 
 * @author J.
 * @version 1.0
 * @date 2017年9月11日
 */
@ApiModel(value = "个人中心首页")
public class UserHome implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户ID")
	private long userId;

	@ApiModelProperty(value = "头像")
	private String avatar;

	@ApiModelProperty(value = "用户名")
	private String nickname;

	@ApiModelProperty(value = "实名")
	private String realname;

	@ApiModelProperty(value = "身份证")
	private String number;

	@ApiModelProperty(value = "手机号")
	private String mobile;

	@ApiModelProperty(value = "rongToken")
	private String rongToken;

	@ApiModelProperty(value = "省")
	private String province;

	@ApiModelProperty(value = "市")
	private String city;

	@ApiModelProperty(value = "区/县")
	private String district;

	@ApiModelProperty(value = "地址")
	private String address;

	@ApiModelProperty(value = "邮编")
	private String postcode;

	@ApiModelProperty(value = "余额")
	private double balance;

	@ApiModelProperty(value = "健康币")
	private long credit;

	@ApiModelProperty(value = "优惠券数量")
	private int coupon;

	@ApiModelProperty(value = "关注数量")
	private int attention;

	@ApiModelProperty(value = "登录方式   p-pwd, q-quick, w-wechat, q-qq")
	private String loginPath;

	@ApiModelProperty(value = "性别    m-男, f-女'")
	private String gender;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public long getCredit() {
		return credit;
	}

	public void setCredit(long credit) {
		this.credit = credit;
	}

	public int getCoupon() {
		return coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	public int getAttention() {
		return attention;
	}

	public void setAttention(int attention) {
		this.attention = attention;
	}

	public String getLoginPath() {
		return loginPath;
	}

	public void setLoginPath(String loginPath) {
		this.loginPath = loginPath;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
