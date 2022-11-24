package com.kuka.h2g.ordermanagementsvc.service;

import com.kuka.h2g.ordermanagementsvc.dto.ContainerSizeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ContainerService {
    private final static String RESOURCE_REST_CONTAINER_URL = "http://localhost:8082/container";

    @Autowired
    RestTemplate restTemplate;

    public List<Long> getContainerIdsBySize(ContainerSizeDto size){
        return restTemplate.getForObject(RESOURCE_REST_CONTAINER_URL+"?size="+size, List.class);
    }
}
