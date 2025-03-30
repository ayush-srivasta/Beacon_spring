package com.example.Beacon.Service;

import com.example.Beacon.Model.DeviceInfo;

import java.util.List;

public interface DeviceInfoService {

    public List<DeviceInfo> getAllDevice();

    public DeviceInfo getDeviceById(Long id);

    public DeviceInfo createDevice(DeviceInfo deviceInfo);

    public DeviceInfo updateDevice(Long id, DeviceInfo deviceInfo);

    public void deleteDevice(Long id);


}
