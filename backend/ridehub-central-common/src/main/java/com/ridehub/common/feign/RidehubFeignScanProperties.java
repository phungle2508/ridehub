package com.ridehub.common.feign;

// in starter: com.ridehub.common.feign.RidehubFeignScanProperties

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ridehub.feign")
public class RidehubFeignScanProperties {
    public static class ScanSpec {
        private String basePackage; // e.g. com.ridehub.msbooking.client.api
        private String serviceId; // e.g. ${ridehub.services.booking:msbooking}

        public String getBasePackage() {
            return basePackage;
        }

        public void setBasePackage(String basePackage) {
            this.basePackage = basePackage;
        }

        public String getServiceId() {
            return serviceId;
        }

        public void setServiceId(String serviceId) {
            this.serviceId = serviceId;
        }
    }

    private List<ScanSpec> scans = new ArrayList<>();

    public List<ScanSpec> getScans() {
        return scans;
    }

    public void setScans(List<ScanSpec> scans) {
        this.scans = scans;
    }
}
