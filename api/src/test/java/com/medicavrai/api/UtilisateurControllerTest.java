package com.medicavrai.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicavrai.api.model.Utilisateur;

@SpringBootTest
@AutoConfigureMockMvc
public class UtilisateurControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test_getUtilisateurs() throws Exception {
		this.mockMvc.perform(get("/utilisateurs")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void test_creerUtilisateur() throws Exception {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setMailUtilisateur("testMvc@test.fr");
		String writeValueAsString = new ObjectMapper().writeValueAsString(utilisateur);
		this.mockMvc.perform(post("/creer_utilisateur")
				.contentType(MediaType.APPLICATION_JSON)
				.content(writeValueAsString))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
}
