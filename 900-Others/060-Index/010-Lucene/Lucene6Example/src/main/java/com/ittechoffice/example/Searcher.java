package com.ittechoffice.example;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class Searcher {
	private IndexSearcher indexSearcher;
	
	public Searcher(String path) throws IOException{
		Directory indexDirectory = FSDirectory.open(Paths.get(path));
		IndexReader indexReader = DirectoryReader.open(indexDirectory);
		indexSearcher = new IndexSearcher(indexReader);
	}
	
	public void search(String search) throws ParseException, IOException{
        QueryParser queryParser = new QueryParser("content",  new StandardAnalyzer());
        Query query = queryParser.parse(search);
        TopDocs topDocs = indexSearcher.search(query,10);
        System.out.println("totalHits " + topDocs.totalHits);
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {           
            Document document = indexSearcher.doc(scoreDoc.doc);
            System.out.println("path " + document.get("path"));
            System.out.println("content " + document.get("content"));
        }
	}
	
}
