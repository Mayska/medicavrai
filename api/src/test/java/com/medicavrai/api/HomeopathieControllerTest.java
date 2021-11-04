package com.medicavrai.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeopathieControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	/**
	 * Recuperation de la liste homeopathies
	 * @throws Exception
	 */
	@Test
	public void testGetHomeopathies_RecupetationListeHomeopathies() throws Exception {
		mockMvc.perform(get("/homeopathies"))
        .andExpect(status().isOk())
        .andDo(print());
	}
	
	/**
	 * Récupère d'un élément de table. 
	 * @throws Exception
	 */
	@Test
	public void testGetHomeopathie_RecupetationHomeopathieParIdQuiExiste() throws Exception {
		mockMvc.perform(get("/homeopathie/{0}", "1"))
        .andExpect(status().isOk())
        .andDo(print());	
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetHomeopathie_RecupetationHomeopathieParIdQuiExistePas() throws Exception {
		mockMvc.perform(get("/homeopathie/{0}", "9999"))
        .andExpect(status().isNotFound())
        .andDo(print());	
	}
		
}
