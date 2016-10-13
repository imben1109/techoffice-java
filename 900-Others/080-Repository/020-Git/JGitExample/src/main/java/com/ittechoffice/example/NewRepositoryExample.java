package com.ittechoffice.example;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

/**
 * This Example demonstrates to use JGit to create a Git Repository
 * 
 * @author Ben_c
 *
 */
public class NewRepositoryExample {
	
	public static void main(String[] args) throws IOException, GitAPIException{
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
	}
	
}
