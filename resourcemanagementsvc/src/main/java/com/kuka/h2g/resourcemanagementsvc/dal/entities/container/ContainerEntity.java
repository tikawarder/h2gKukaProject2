package com.kuka.h2g.resourcemanagementsvc.dal.entities.container;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="Container")
public class ContainerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated
    private ContainerSizeEntity size;
}
