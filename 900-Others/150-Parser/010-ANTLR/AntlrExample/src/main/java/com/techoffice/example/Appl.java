package com.techoffice.example;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.techoffice.antlr.HelloBaseListener;
import com.techoffice.antlr.HelloLexer;
import com.techoffice.antlr.HelloParser;

public class Appl {
	
	public static void main(String[] args){
		ANTLRInputStream  input = new ANTLRInputStream("hello a");
		HelloLexer lexer = new HelloLexer(input);
	    CommonTokenStream tokens = new CommonTokenStream(lexer);
	    HelloParser parser = new HelloParser(tokens);
	    ParseTree tree =  parser.r();
	    ParseTreeWalker walker = new ParseTreeWalker();
	    walker.walk( new HelloBaseListener(), tree );

	}
}
