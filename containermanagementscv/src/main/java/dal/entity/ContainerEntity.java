package dal.entity;

import javax.persistence.*;

public class ContainerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated
    private ContainerSizeEntity size;

    boolean isBooked;
}
