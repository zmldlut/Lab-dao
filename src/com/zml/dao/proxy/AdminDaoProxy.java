package com.zml.dao.proxy;

import java.util.ArrayList;

import com.zml.dao.AdminDao;
import com.zml.dao.impl.AdminDaoImpl;
import com.zml.model.Admin;

public class AdminDaoProxy extends BaseDaoProxy implements AdminDao {
    
    public AdminDaoProxy() {
    	super(AdminDaoImpl.class);
    }

    @Override
    public boolean doCreate(Admin obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Admin findDao(Admin obj) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
	public ArrayList<String> getNames() {
		ArrayList<String> result = null;
		result = ((AdminDaoImpl) super.dao).getNames();
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public String getPasswordFromName(String name) {
		String result = null;
		result = ((AdminDaoImpl) super.dao).getPasswordFromName(name);
		connPool.returnConnection(conn);
		return result;
	}
}
