package com.ittechoffice.example;

import java.io.File;
import java.io.IOException;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.revwalk.RevCommit;

import com.ittechoffice.example.helper.DateTimeHelper;
import com.ittechoffice.example.helper.NewRepositoryHelper;

public class CommitExample {
	public static void main(String[] args) throws IOException, GitAPIException{
		Git git = NewRepositoryHelper.createTempRepository();
		File dir = git.getRepository().getDirectory();
		String filePath = "test";
		File file = new File(dir, filePath);
		file.createNewFile();

		// add a newly created file to local index 
		git.add().addFilepattern(filePath).call();
		
		// commit the change
		git.commit().setMessage("a newly created file").call();
		
		// print all commit log message
		Iterable<RevCommit> logs = git.log().call();
		for (RevCommit log: logs){
			System.out.println(DateTimeHelper.parseInt(log.getCommitTime()) + " " + log.getFullMessage());
		}
	}
}
