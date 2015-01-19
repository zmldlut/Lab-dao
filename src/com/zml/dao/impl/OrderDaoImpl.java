package com.zml.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.zml.dao.OrderDao;
import com.zml.model.Order;

public class OrderDaoImpl extends BaseDaoImpl implements OrderDao{

	public OrderDaoImpl() {
		
	}
	
	public OrderDaoImpl(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<Order> findDao(String stdNum) {
		ArrayList<Order> result = new ArrayList<Order>();
		String sql = "select * from order_device where stdNum = ?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, stdNum);
			ResultSet rs = this.pstmt.executeQuery();
			Order order;
			while(rs.next()) {
				order = new Order();
				order.setId(rs.getString(1));
				order.setDevice_id(rs.getString(2));
				order.setOrder_time(rs.getTimestamp(3));
				order.setStart_time(rs.getTimestamp(4));
				order.setEnd_time(rs.getTimestamp(5));
				order.setStatus(rs.getInt(6));
				order.setStdNum(rs.getString(7));
				result.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return result;
	}
	
	@Override
	public boolean doCreate(Order order) {
		boolean result = false;
		String sql = "insert into order_device (stdNum, device_id, order_time, start_time, end_time, status, id) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, order.getStdNum());
			this.pstmt.setString(2, order.getDevice_id());
			this.pstmt.setTimestamp(3, new Timestamp(order.getOrder_time().getTime()));
			this.pstmt.setTimestamp(4, new Timestamp(order.getStart_time().getTime()));
			this.pstmt.setTimestamp(5, new Timestamp(order.getEnd_time().getTime()));
			this.pstmt.setInt(6, order.getStatus());
			this.pstmt.setString(7, order.getId());
			
			if(this.pstmt.executeUpdate() > 0) {
				result = true;
			}
			System.out.println(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				this.pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	@Override
	public Order findDao(Order obj) {
		// TODO Auto-generated method stub
		return null;
	}
}
