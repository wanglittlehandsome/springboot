package com.bestway.program.service.personal;

import com.bestway.program.dao.personal.PersonalDao;
import com.bestway.program.model.dto.personal.ReceiverAddressDto;
import com.bestway.program.model.pojo.personal.ReceiverAddressPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService {

    @Autowired
    private PersonalDao personalDao;

    /**
     * 收货地址管理
     *
     * @param userID
     * @return
     */
    public List<ReceiverAddressDto> queryAddressManager(Integer userID) {
        return personalDao.queryAddressManager(userID);
    }

    /**
     * 新增收货地址
     *
     * @param dto
     * @return
     */
    public void insertReceiveAddress(ReceiverAddressDto dto) {
        personalDao.insertReceiveAddress(dto);
    }
}
