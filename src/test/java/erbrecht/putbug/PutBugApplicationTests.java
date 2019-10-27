package erbrecht.putbug;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DemoController.class)
class PutBugApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void whenSubmitPost_thenReturnValue() throws Exception {
		String postValue = "my post value";
		mvc.perform(post("/post")
				.param("value", postValue)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/plain;charset=utf-8"))
				.andExpect(content().string(postValue));
	}

	@Test
	void whenSubmitPut_thenReturnValue() throws Exception {
		String putValue = "my put value";
		mvc.perform(put("/put")
				.param("value", putValue)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/plain;charset=utf-8"))
				.andExpect(content().string(putValue));
	}

	@Test
	void whenSubmitPostWithHiddenPutMethod_thenReturnValue() throws Exception {
		String putValue = "my put value";
		mvc.perform(post("/put")
				.param("_method", "PUT")
				.param("value", putValue)
				.contentType(MediaType.APPLICATION_FORM_URLENCODED))
				.andExpect(status().isOk())
				.andExpect(content().contentType("text/plain;charset=utf-8"))
				.andExpect(content().string(putValue));
	}
}
