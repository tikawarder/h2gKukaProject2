package com.kuka.h2g.service;

import com.kuka.h2g.dal.dao.ContainerDao;
import com.kuka.h2g.domain.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerService {

    @Autowired
    ContainerDao containerDao;

    public Container save (Container container){
        return containerDao.create(container);
    }

    public Container findById (long id){
        return containerDao.findById(id);
    }

    public List<Container> findAll(){
        return containerDao.findAll();
    }
}
