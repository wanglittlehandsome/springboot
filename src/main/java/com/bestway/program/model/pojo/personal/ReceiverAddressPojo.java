package com.bestway.program.model.pojo.personal;

import com.bestway.program.model.dto.personal.ReceiverAddressDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("收货地址管理")
public class ReceiverAddressPojo {

    @ApiModelProperty("收货地址")
    private ReceiverAddressDto receiverAddressDto;

    public ReceiverAddressDto getReceiverAddressDto() {
        return receiverAddressDto;
    }

    public void setReceiverAddressDto(ReceiverAddressDto receiverAddressDto) {
        this.receiverAddressDto = receiverAddressDto;
    }
}
