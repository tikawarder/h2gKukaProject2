package com.kuka.h2g.resourcemanagementsvc.dal.repositories.container;

import com.kuka.h2g.resourcemanagementsvc.dal.entities.container.ContainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerRepository extends JpaRepository<ContainerEntity, Long> {
}
