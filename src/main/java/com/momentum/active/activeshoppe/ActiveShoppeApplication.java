package com.momentum.active.activeshoppe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.metrics.export.prometheus.EnablePrometheusMetrics;

@SpringBootApplication
//@EnablePrometheusMetrics //TODO for some reason trying to add Prometheus breaks the application
public class ActiveShoppeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActiveShoppeApplication.class, args);
    }

}
