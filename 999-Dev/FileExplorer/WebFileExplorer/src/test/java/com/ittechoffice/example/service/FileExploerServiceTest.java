package com.ittechoffice.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.ittechoffice.example.example.FeNotFolderException;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class FileExploerServiceTest {
	
	@Autowired
	private FileExploerService fileExploerService;
	
    @Test
	public void list() throws FeNotFolderException{
    	fileExploerService.list(".");
	}
}
