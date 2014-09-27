package com.intel.sto.bigdata.dew.agent;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.intel.sto.bigdata.dew.service.Service;

public class ServiceManager {

  private Map<String, Service> serviceMap = new HashMap<String, Service>();

  public void startService(String serviceName) {
    Service service = serviceMap.get(serviceName);
    new Thread(service).start();
  }

  public void stopService(String serviceName) {
  }

  public Service getService(String serviceName) {
    return serviceMap.get(serviceName);
  }

  public void putService(String serviceName, Service service) {
    serviceMap.put(serviceName, service);
  }

  public void stopAllService() {
    for (Entry<String, Service> entry : serviceMap.entrySet()) {
      entry.getValue().stop();
    }
  }
}