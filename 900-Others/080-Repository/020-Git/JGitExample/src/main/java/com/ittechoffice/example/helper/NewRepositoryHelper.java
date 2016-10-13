package com.ittechoffice.example.helper;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class NewRepositoryHelper {
	public static Git createTempRepository() throws IOException, GitAPIException{
        File dir = File.createTempFile("jGitRepository", ".test");
        
        if(!dir.delete()) {
            throw new IOException("Could not delete file " + dir);
        }
        
        dir.deleteOnExit();
        
        // init a git object
        Git git = Git.init()
                .setDirectory(dir)
                .call();
        
        System.out.println("Created a new repository at " + git.getRepository().getDirectory());
        
        return git;
	}
}
