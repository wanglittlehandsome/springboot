package com.bestway.program.service.hospital;


import com.bestway.program.dao.hospital.HospitalDao;
import com.bestway.program.model.pojo.hospital.Hospital;
import com.bestway.program.model.pojo.product.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalDao hospitalDao;

    /**
     * 通过体检卡号ID获取医疗机构
     *
     * @param latitude
     * @param longitude
     * @param cardID
     * @return
     */
    public List<Hospital> queryAppointHospital(Double latitude, Double longitude, Integer cardID) {

        List<Hospital> list = hospitalDao.queryAppointHospital(latitude, longitude, cardID);
        for (Hospital hospital : list) {
            hospital.setDistance(this.calculate(hospital.getJuli()));
        }
        return list;
    }




    /**
     * 说明：计算距离
     *
     * @param distance
     */
    public Double calculate(Long distance) {
        // 计算距离
        if (distance == null)
            return null;
        Double juli = (double) distance / 1000;
        BigDecimal bg = new BigDecimal(juli);
        Double bd_half_up = bg.setScale(2, RoundingMode.HALF_UP).doubleValue();
        return bd_half_up;
    }
}
