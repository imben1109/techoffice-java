package com.ittechoffice.example;

import java.io.File;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.wc.ISVNPathListHandler;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNStatusClient;

public class LocalClientAppl {
	public static void main(String[] args) throws SVNException{
		SVNClientManager clientManager = SVNClientManager.newInstance();
		String path = "";
		SVNStatusClient client = clientManager.getStatusClient();
		clientManager.getStatusClient().setPathListHandler(new ISVNPathListHandler(){
			public void handlePathListItem(File file) throws SVNException {
				System.out.println(file.getName());
			}
		});
		client.doStatus(new File(path), false);
		
	}
}
