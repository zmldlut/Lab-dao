package com.zml.dao.factory;

import com.zml.dao.proxy.BaseDaoProxy;

public class DaoFactory {

	public static BaseDaoProxy getDaoInstance(Class<? extends BaseDaoProxy> daoClass) throws Exception {
		return daoClass.newInstance();
	}
}
