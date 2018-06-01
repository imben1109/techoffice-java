package com.techoffice.example;

import java.util.List;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.BaseAnalysis;

public class Appl {
	
	//https://my.oschina.net/apdplat/blog/412921
	public static void main(String[] args) {
	    Result parse = BaseAnalysis.parse("讓戰士們過一個歡樂祥和的新春佳節");
	    
	    System.out.println(parse.getTerms());

	}

}
