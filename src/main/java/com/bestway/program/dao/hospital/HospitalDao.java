package com.bestway.program.dao.hospital;


import com.bestway.program.model.pojo.hospital.Hospital;
import com.bestway.program.model.pojo.product.ProductOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalDao {


    /**
     * 通过体检卡号ID获取医疗机构
     *
     * @param latitude
     * @param longitude
     * @param cardID
     * @return
     */
    List<Hospital> queryAppointHospital(@Param("latitude") Double latitude, @Param("longitude") Double longitude,
                                        @Param("cardID") Integer cardID);


}
