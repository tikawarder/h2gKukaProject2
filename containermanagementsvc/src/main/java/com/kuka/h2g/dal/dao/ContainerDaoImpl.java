package com.kuka.h2g.dal.dao;

import com.kuka.h2g.dal.entities.ContainerEntity;
import com.kuka.h2g.dal.exceptions.NoReturnDataException;
import com.kuka.h2g.dal.repositories.ContainerRepository;
import com.kuka.h2g.dal.transformers.ContainerTransformer;
import com.kuka.h2g.domain.Container;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContainerDaoImpl implements ContainerDao {

    @Autowired
    private ContainerRepository repository;

    @Autowired
    private ContainerTransformer transformer;

    @Override
    public Container save(Container container) {
        ContainerEntity entity = repository.save(transformer.transform(container));
        return transformer.transform(entity);
    }

    @Override
    public List<Container> findAll() {
        return repository.findAll().stream()
                .map(transformer::transform)
                .toList();
    }

    @Override
    public Container findById(long id) {
        return transformer.transform(repository.findById(id).orElseThrow(NoReturnDataException::new));
    }

    @Override
    public boolean delete(Container container) {
        repository.delete(transformer.transform(container));
        return repository.findById(container.getId()).isEmpty();
    }

    @Override
    public boolean deleteById(long id) {
        repository.deleteById(id);
        return repository.findById(id).isEmpty();
    }
}
