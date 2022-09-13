package com.kuka.h2g.dal.dao;

import com.kuka.h2g.domain.Container;

import java.util.List;

public interface ContainerDao {
    Container save (Container container);
    List<Container> findAll ();
    Container findById (long id);
    boolean delete(Container container);
    boolean deleteById(long id);
}
