package com.techoffice.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexer {
	
	private IndexWriter indexWriter;
	private Directory indexDirectory;
	
	public Indexer(String path) throws IOException{
		indexDirectory = FSDirectory.open(Paths.get(path));
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());     
        config.setOpenMode(OpenMode.CREATE_OR_APPEND);
        indexWriter= new IndexWriter(indexDirectory, config);
	}
	
	public void indexFile(File file) throws IOException{
		Document document = new Document();
		BufferedReader contentReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
		document.add(new StringField("path", file.getPath(), Store.YES));
		document.add(new TextField("content", contentReader));
		
		indexWriter.updateDocument(new Term("path", file.toString()), document);
	}
	
	public void close() throws IOException{
		indexWriter.close();
		indexDirectory.close();
	}
	
	
}
