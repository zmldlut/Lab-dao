package com.zml.dao.proxy;

import com.zml.dao.ReportDao;
import com.zml.dao.impl.ReportDaoImpl;
import com.zml.model.Report;

public class ReportDaoProxy extends BaseDaoProxy implements ReportDao{
	
	public ReportDaoProxy() {
		super(ReportDaoImpl.class);
	}
	
	@Override
	public boolean doCreate(Report report) {
		boolean result = false;
		result = ((ReportDaoImpl) dao).doCreate(report);
		connPool.returnConnection(this.conn);
		return result;
	}

	@Override
	public Report findDao(Report obj) {
		return null;
	}
}
