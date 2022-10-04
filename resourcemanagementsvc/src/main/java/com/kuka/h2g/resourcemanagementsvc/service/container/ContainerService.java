package com.kuka.h2g.resourcemanagementsvc.service.container;

import com.kuka.h2g.resourcemanagementsvc.dal.dao.container.ContainerDao;
import com.kuka.h2g.resourcemanagementsvc.domain.container.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerService {

    @Autowired
    ContainerDao containerDao;

    public Container save (Container container){
        return containerDao.save(container);
    }

    public Container findById (long id){
        return containerDao.findById(id);
    }

    public List<Container> findAll(){
        return containerDao.findAll();
    }

    public boolean delete(Container container){
        return containerDao.delete(container);
    }
    public boolean deleteById(Long id){
        return containerDao.deleteById(id);
    }


}
