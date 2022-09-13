package com.kuka.h2g.dal.dao;

import com.kuka.h2g.domain.Container;

import java.util.List;

public interface ContainerDao {
    Container create (Container container);
    List<Container> findAll ();
    Container findById (long id);
}
