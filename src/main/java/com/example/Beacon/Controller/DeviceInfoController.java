package com.example.Beacon.Controller;

import com.example.Beacon.Model.DeviceInfo;
import com.example.Beacon.Service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deviceInfo")
public class DeviceInfoController {

    @Autowired
    private DeviceInfoService deviceInfoService;

    public List<DeviceInfo> getAllDeviceInfos() {
        return deviceInfoService.getAllDevice();
    }

    @GetMapping("/{id}")
    public DeviceInfo getDeviceInfoById(@PathVariable Long id) {
        return deviceInfoService.getDeviceById(id);
    }

    @PostMapping
    public DeviceInfo createDeviceInfo(@RequestBody DeviceInfo deviceInfo) {
        return deviceInfoService.createDevice(deviceInfo);
    }

    @PutMapping("/{id}")
    public DeviceInfo udateDeviceInfoById(@PathVariable Long id, @RequestBody DeviceInfo deviceInfo) {
        return deviceInfoService.updateDevice(id, deviceInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteDeviceInfo(@PathVariable Long id) {
        deviceInfoService.deleteDevice(id);
    }
}
