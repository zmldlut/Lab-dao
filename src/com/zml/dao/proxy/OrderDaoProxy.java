package com.zml.dao.proxy;

import java.util.ArrayList;

import com.zml.dao.OrderDao;
import com.zml.dao.impl.OrderDaoImpl;
import com.zml.model.Order;

public class OrderDaoProxy extends BaseDaoProxy implements OrderDao{
    
    public OrderDaoProxy() {
        super(OrderDaoImpl.class);
    }

    //签到或开门验证身份
    public ArrayList<Order> findDao(String stdNum) {
        ArrayList<Order> result = null;
        result = ((OrderDaoImpl) dao).findDao(stdNum);
        connPool.returnConnection(conn);
        return result;
    }

	@Override
	public boolean doCreate(Order order) {
		boolean result = false;
		result = ((OrderDaoImpl) dao).doCreate(order);
		connPool.returnConnection(this.conn);
		return result;
	}

	@Override
	public Order findDao(Order obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
