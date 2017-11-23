package com.bestway.program.common.base;

import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * 说明：service 父类 (事务)
 * 
 * @author J.
 * @version 1.0
 * @date 2017年7月3日
 */
@Transactional(rollbackFor = Exception.class)
public class TxService {

	protected String fuzzy(String strSource) {

		String strResult;
		if (strSource == null || strSource.trim().length() == 0) {
			return null;
		} else {
			strResult = "%" + strSource.replace(' ', '%') + "%";
			strResult = strResult.replaceAll("%+", "%");
		}
		return strResult;
	}
}
