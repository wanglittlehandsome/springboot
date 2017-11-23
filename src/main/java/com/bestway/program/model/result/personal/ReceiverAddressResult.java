package com.bestway.program.model.result.personal;

import com.bestway.program.common.base.BaseResult;
import com.bestway.program.model.dto.personal.ReceiverAddressDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("收货地址管理返回结果")
public class ReceiverAddressResult extends BaseResult {

    @ApiModelProperty("收货地址pojo")
    private List<ReceiverAddressDto> receiverAddressDto;

    public List<ReceiverAddressDto> getReceiverAddressDto() {
        return receiverAddressDto;
    }

    public void setReceiverAddressDto(List<ReceiverAddressDto> receiverAddressDto) {
        this.receiverAddressDto = receiverAddressDto;
    }
}
