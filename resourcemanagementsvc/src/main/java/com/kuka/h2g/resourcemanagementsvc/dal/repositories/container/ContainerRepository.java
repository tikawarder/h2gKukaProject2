package com.kuka.h2g.resourcemanagementsvc.dal.repositories.container;

import com.kuka.h2g.resourcemanagementsvc.dal.entities.container.ContainerEntity;
import com.kuka.h2g.resourcemanagementsvc.dal.entities.container.ContainerSizeEntity;
import com.kuka.h2g.resourcemanagementsvc.domain.container.ContainerSize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContainerRepository extends JpaRepository<ContainerEntity, Long> {
    List<ContainerEntity> findIdBySize(ContainerSize size);
}
