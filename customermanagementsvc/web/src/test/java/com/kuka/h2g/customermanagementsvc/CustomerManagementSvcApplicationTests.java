package com.kuka.h2g.customermanagementsvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.kuka.h2g.dal.repositories.address.AddressRepository;
import com.kuka.h2g.dal.repositories.customer.CustomerRepository;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerManagementSvcApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerRepository customerRepository;

	@MockBean
	private AddressRepository addressRepository;

	@Test
	void contextLoads() {
		CustomerManagementSvcApplication.main(new String[] {});
	}

}
