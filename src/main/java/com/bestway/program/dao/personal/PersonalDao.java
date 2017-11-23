package com.bestway.program.dao.personal;


import com.bestway.program.model.dto.personal.ReceiverAddressDto;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 个人中心
 */
@Repository
public interface PersonalDao {


    /**
     * 收货地址管理
     */
    List<ReceiverAddressDto> queryAddressManager(Integer userID);


    /**
     * 新增收货地址
     *
     * @param dto
     */
    void insertReceiveAddress(ReceiverAddressDto dto);

}
