package com.zml.dao;

import java.util.ArrayList;

import com.zml.model.Device;

public interface DeviceDao extends BaseDao<Device>{
	ArrayList<Device> getDevices(String type, int status, int datetime);
	ArrayList<Device> getDevices(String type, int status, int page, int pageCount);
	int getDevicesSize(String type, int status);
	
	boolean delDevice(String id);
	boolean updateDevice(Device device);
	Device getDevice(String id);
}
