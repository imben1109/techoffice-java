package com.ittechoffice.example;

import java.io.File;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNStatus;
import org.tmatesoft.svn.core.wc.SVNStatusClient;

public class LocalClientAppl {
	public static void main(String[] args) throws SVNException {
		SVNClientManager clientManager = SVNClientManager.newInstance();
		String path = ""; // Specify the folder
							// which is a svn
							// folder
		SVNStatusClient client = clientManager.getStatusClient();
		SVNStatus status = client.doStatus(new File(path), false);
		System.out.println(status.getRevision().getNumber());

	}
}
