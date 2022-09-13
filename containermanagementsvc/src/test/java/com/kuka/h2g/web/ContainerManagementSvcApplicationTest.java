package com.kuka.h2g.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
class ContainerManagementSvcApplicationTest {

    @Test
    void contextLoads() {
        ContainerManagementSvcApplication.main(new String[] {});
    }
}