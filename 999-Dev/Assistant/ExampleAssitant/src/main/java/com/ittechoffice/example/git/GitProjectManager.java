package com.ittechoffice.example.git;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

import com.ittechoffice.example.fx.Appl;

public class GitProjectManager {
	
	private Git git;
	private String path;
	
	public GitProjectManager(String Path) throws GitAPIException{
		String gitUser = Appl.properties.getProperty(Appl.GIT_USER);
		String gitPassword = Appl.properties.getProperty(Appl.GIT_PASSWORD);

        CredentialsProvider cp = new UsernamePasswordCredentialsProvider(gitUser, gitPassword);
		this.path = path;
        git = Git.init().setDirectory(new File(Path)).call();
	}
	
	public static void main(String[] args) throws GitAPIException{
		GitProjectManager GitProjectManager = new GitProjectManager(Appl.properties.getProperty(Appl.EXAMPLE_HOME));
	}
	
}
