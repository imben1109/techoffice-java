package com.ittechoffice.example.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class FileExplorerControllerTest {
	
    @Autowired
    private MockMvc mvc;

	@Test
	public void list() throws Exception{
		MvcResult result = this.mvc.perform(get("/fileExplorer/list?parent=.")).andReturn();
		System.out.println("=====Content=====");
		System.out.println(result.getResponse().getContentAsString());
	}
}
