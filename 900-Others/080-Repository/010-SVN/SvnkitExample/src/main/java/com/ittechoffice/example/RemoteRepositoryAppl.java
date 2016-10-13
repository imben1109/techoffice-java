package com.ittechoffice.example;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;

public class RemoteRepositoryAppl {
	private static String url = "";
	private static String user = "";
	private static String password = "";
	
	public static void main(String[] args) throws SVNException{
		
		SVNRepository repository = null;
		repository = SVNRepositoryFactory.create(SVNURL.parseURIDecoded(url));
		ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager( user, password );
		repository.setAuthenticationManager(authManager);
		
		System.out.println("Repository Root: " + repository.getRepositoryRoot( true ) );
		System.out.println("Repository UUID: " + repository.getRepositoryUUID( true ) );
		
		long lastRevision = repository.getLatestRevision();
		System.out.println("lastRevision" + lastRevision);

	}
}
