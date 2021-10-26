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
	
	/**
	 * Affiche la liste des utilisateurs.
	 * @throws Exception
	 */
	@Test
	public void test_getUtilisateurs() throws Exception {
		mockMvc.perform(get("/utilisateurs"))
			.andDo(print())
			.andExpect(status().isOk());
	}
	
	/**
	 * Ajouter un utilisateur
	 * @throws Exception
	 */
	@Test
	public void test_creerUtilisateur() throws Exception {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setMailUtilisateur("testMvc@test.fr");
		String writeValueAsString = new ObjectMapper().writeValueAsString(utilisateur);
		mockMvc.perform(post("/creer_utilisateur")
			.contentType(MediaType.APPLICATION_JSON)
			.content(writeValueAsString))
			// .andDo(print())
			.andExpect(status().isOk());
	}
	
	/**
	 * Afficher un utilisateur.
	 * @throws Exception
	 */
	@Test
	public void test_afficherUtilisateur() throws Exception {
		mockMvc.perform(get("/utilisateur/1"))
			// .andDo(print())
			.andExpect(status().isOk());
	}
	
	/**
	 * Afficher un utilisateur qui n'existe pas.
	 * @throws Exception
	 */
	@Test
	public void test_afficherUtilisateurNonExistant() throws Exception {
		mockMvc.perform(get("/utilisateur/9999"))
			// .andDo(print())
			.andExpect(status().isInternalServerError());
	}
	
	/**
	 * Ajouter un utilisateur avec mail vide
	 * @throws Exception
	 */
	@Test
	public void test_creerUtilisateurVide() throws Exception {
		Utilisateur utilisateur = new Utilisateur();
		String writeValueAsString = new ObjectMapper().writeValueAsString(utilisateur);
		this.mockMvc.perform(post("/creer_utilisateur")
			.contentType(MediaType.APPLICATION_JSON)
			.content(writeValueAsString))
			//.andDo(print())
			.andExpect(status().isBadRequest());
	}
	
}
