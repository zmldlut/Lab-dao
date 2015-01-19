package com.zml.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zml.dao.DeviceDao;
import com.zml.model.Device;
import com.zml.util.TimeUtil;

public class DeviceDaoImpl extends BaseDaoImpl implements DeviceDao{

	public DeviceDaoImpl() {
		
	}
	
	public DeviceDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	public ArrayList<Device> getDevices(String type, int status, int datetime) {
		ArrayList<Device> result = new ArrayList<Device>();
		String sql = "select * from devices where type = ?";
		switch(status){
		case 0:
			break;
		case 1:
			sql += "and id not in (select device_id from order_device where start_time = ?)"; 
			break;
		case 2:
			sql += "and id in (select device_id from order_device where start_time = ?)";
			break;
		default:
			break;
		}
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, type);
			if(status != 0) {
				this.pstmt.setTimestamp(2, new java.sql.Timestamp(TimeUtil.getOderTime(datetime).getTime()));
			}
			ResultSet rs = this.pstmt.executeQuery();
			Device device;
			while (rs.next()) {
				System.out.println(rs);
				device = new Device();
				device.setId(rs.getString(1));
				device.setName(rs.getString(2));
				device.setType(rs.getString(3));
				device.setService_tag(rs.getString(4));
				result.add(device);
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
	public boolean doCreate(Device device) {
		boolean result = false;
		String sql = "insert into devices (id, name, type, service_tag, status) values (?, ?, ?, ?, ?)";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, device.getId());
			this.pstmt.setString(2, device.getName());
			this.pstmt.setString(3, device.getType());
			this.pstmt.setString(4, device.getService_tag());
			this.pstmt.setInt(5, device.getStatus());
			if(this.pstmt.executeUpdate() > 0) {
				result = true;
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
	public Device findDao(Device obj) {
		return null;
	}
}
