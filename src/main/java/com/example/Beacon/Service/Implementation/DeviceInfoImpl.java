package com.example.Beacon.Service.Implementation;

import com.example.Beacon.Model.DeviceInfo;
import com.example.Beacon.Repositery.DeviceInfoRepo;
import com.example.Beacon.Service.DeviceInfoService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Data
public class DeviceInfoImpl implements DeviceInfoService {

    @Autowired
    private DeviceInfoRepo deviceInfoRepo;


    @Override
    public List<DeviceInfo> getAllDevice() {
        return deviceInfoRepo.findAll();
    }

    @Override
    public DeviceInfo getDeviceById(Long id) {
        return deviceInfoRepo.findById(id).orElseThrow(() -> new NoSuchElementException("The Device is not present"));
    }

    @Override
    public DeviceInfo createDevice(DeviceInfo deviceInfo) {
        return deviceInfoRepo.save(deviceInfo);
    }

    @Override
    public DeviceInfo updateDevice(Long id, DeviceInfo deviceInfo) {
        return deviceInfoRepo.save(deviceInfo);
    }

    @Override
    public void deleteDevice(Long id) {
        deviceInfoRepo.deleteById(id);
    }
}
