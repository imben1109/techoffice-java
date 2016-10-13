package com.ittechoffice.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Indexer {
	
	private IndexWriter indexWriter;
	private Directory indexDirectory;
	
	public Indexer(String path) throws IOException{
		indexDirectory = FSDirectory.open(Paths.get(path));
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());        
        indexWriter= new IndexWriter(indexDirectory, config);
	}
	
	public void indexFile(File file) throws IOException{
		Document document = new Document();
		String content = FileUtils.readFileToString(file, "UTF-8");
		document.add(new TextField("path", file.getPath(), Store.YES));
		document.add(new TextField("content", content, Store.YES));
		indexWriter.addDocument(document);
	}
	
	public void close() throws IOException{
		indexWriter.close();
		indexDirectory.close();
	}
	
	
}
