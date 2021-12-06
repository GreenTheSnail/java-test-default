package com.etnetera.hr;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.etnetera.hr.data.Version;
import com.etnetera.hr.repository.VersionRepository;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.etnetera.hr.data.JavaScriptFramework;
import com.etnetera.hr.repository.JavaScriptFrameworkRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * Class used for Spring Boot/MVC based tests.
 * 
 * @author Etnetera
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class JavaScriptFrameworkTests {

	@Autowired
	private MockMvc mockMvc;
	
	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private JavaScriptFrameworkRepository repository;

	@Autowired
	private VersionRepository versionRepository;

	private void prepareData() throws Exception {
		JavaScriptFramework react = new JavaScriptFramework(1L,"ReactJS", LocalDate.of(2019, 10, 10), 10, new ArrayList<>());
		Version version_react_1 = new Version(1L, "17.0.1", react);
		Version version_react_2 = new Version(2L, "17.0.2", react);
		repository.save(react);
		versionRepository.save(version_react_1);
		versionRepository.save(version_react_2);


		JavaScriptFramework vue = new JavaScriptFramework(2L, "Vue.js", LocalDate.of(2020, 10, 10), 5, new ArrayList<>());
		repository.save(vue);
		Version version_vue_1 = new Version(3L, "3.0", vue);
		Version version_vue_2 = new Version(4L, "3.1", vue);
		versionRepository.save(version_vue_1);
		versionRepository.save(version_vue_2);

	}


	@Test
	public void frameworksTest() throws Exception {
		prepareData();

		mockMvc.perform(get("/frameworks")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].id", is(1)))
				.andExpect(jsonPath("$[0].name", is("ReactJS")))
				.andExpect(jsonPath("$[0].deprecationDate", is("2019-10-10")))
				.andExpect(jsonPath("$[0].hypeLevel", is(10)))
				.andExpect(jsonPath("$[1].id", is(2)))
				.andExpect(jsonPath("$[1].name", is("Vue.js")))
				.andExpect(jsonPath("$[1].deprecationDate", is("2020-10-10")))
				.andExpect(jsonPath("$[1].hypeLevel", is(5)));
	}
	
//	@Test
//	public void addFrameworkInvalid() throws JsonProcessingException, Exception {
//		JavaScriptFramework framework = new JavaScriptFramework();
//		framework.setDeprecationDate(LocalDate.now());
//		framework.setHypeLevel(1);
//		mockMvc.perform(post("/frameworks/add").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsBytes(framework)))
//				.andExpect(status().isBadRequest())
//				.andExpect(jsonPath("$.errors", hasSize(1)))
//				.andExpect(jsonPath("$.errors[0].field", is("name")))
//				.andExpect(jsonPath("$.errors[0].message", is("NotEmpty")));
//
//		framework.setName("verylongnameofthejavascriptframeworkjavaisthebest");
//		mockMvc.perform(post("/frameworks/add").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsBytes(framework)))
//			.andExpect(status().isBadRequest())
//			.andExpect(jsonPath("$.errors", hasSize(1)))
//			.andExpect(jsonPath("$.errors[0].field", is("name")))
//			.andExpect(jsonPath("$.errors[0].message", is("Size")));
//
//	}
	
}
