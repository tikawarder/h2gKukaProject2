package com.kuka.h2g.resourcemanagementsvc.dal.dao.container;

import com.kuka.h2g.resourcemanagementsvc.domain.container.Container;
import com.kuka.h2g.resourcemanagementsvc.domain.container.ContainerSize;

import java.util.List;

public interface ContainerDao {
    Container save (Container container);
    List<Container> findAll ();
    Container findById (long id);
    boolean delete(Container container);
    boolean deleteById(long id);
    List<Container> findBySize(ContainerSize size);
}
