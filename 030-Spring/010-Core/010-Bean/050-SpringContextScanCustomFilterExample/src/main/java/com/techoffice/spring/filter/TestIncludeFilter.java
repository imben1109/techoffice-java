package com.techoffice.spring.filter;

import java.io.IOException;

import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class TestIncludeFilter implements TypeFilter {

	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		System.out.println("include filter scanned " + metadataReader.getResource());
		return false;
	}

}
