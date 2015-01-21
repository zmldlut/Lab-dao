package com.zml.dao.proxy;

import java.util.ArrayList;

import com.zml.dao.DeviceDao;
import com.zml.dao.impl.DeviceDaoImpl;
import com.zml.model.Device;

public class DeviceDaoProxy extends BaseDaoProxy implements DeviceDao{

    public DeviceDaoProxy() {
        super(DeviceDaoImpl.class);
    }
    
    @Override
    public ArrayList<Device> getDevices(String type, int status, int datetime) {
        ArrayList<Device> result = null;
        result = ((DeviceDaoImpl) dao).getDevices(type, status, datetime);
        System.out.println(result.size());
        connPool.returnConnection(conn);
        return result;
    }

	@Override
	public boolean doCreate(Device device) {
		boolean result = false;
		result = ((DeviceDaoImpl) dao).doCreate(device);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public Device findDao(Device obj) {
		return null;
	}

	@Override
	public boolean delDevice(String id) {
		boolean result = false;
		result = ((DeviceDaoImpl) dao).delDevice(id);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public boolean updateDevice(Device device) {
		boolean result = false;
		result = ((DeviceDaoImpl) dao).updateDevice(device);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public Device getDevice(String id) {
		Device result = null;
		result =((DeviceDaoImpl) dao).getDevice(id);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public ArrayList<Device> getDevices(String type, int status, int page, int pageCount) {
		ArrayList<Device> result = null;
		result = ((DeviceDaoImpl) dao).getDevices(type, status, page, pageCount);
		connPool.returnConnection(conn);
		return result;
	}

	@Override
	public int getDevicesSize(String type, int status) {
		int result = 0;
		result = ((DeviceDaoImpl) dao).getDevicesSize(type, status);
		connPool.returnConnection(conn);
		return result;
	}
}
