package com.medicavrai.webapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetEmployees() throws Exception {

		/*
		 * mockMvc.perform(get("/")) .andDo(print()) .andExpect(status().isOk()) .andExpect(view().name("home"))
		 * .andExpect(content().string(containsString("Laurent")));
		 */

	}

}
