package com.ittechoffice.example;

import java.io.File;

import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.wc.ISVNPathListHandler;
import org.tmatesoft.svn.core.wc.ISVNStatusHandler;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNStatus;
import org.tmatesoft.svn.core.wc.SVNStatusClient;
import org.tmatesoft.svn.core.wc.SVNStatusType;
import org.tmatesoft.svn.core.wc.SVNTreeConflictDescription;

public class LocalClientAppl {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SVNException {
		SVNClientManager clientManager = SVNClientManager.newInstance();
		String path = ""; // Specify the folder
							// which is a svn
							// folder
		SVNStatusClient client = clientManager.getStatusClient();
		clientManager.getStatusClient().setPathListHandler(new ISVNPathListHandler() {
			public void handlePathListItem(File file) throws SVNException {
				System.out.println(file.getName());
			}
		});
		SVNStatus status = client.doStatus(new File(path), false);
		client.doStatus(new File(path), true, false, true, true, new ISVNStatusHandler() {
			public void handleStatus(SVNStatus status) throws SVNException {
				SVNStatusType statusType = status.getContentsStatus();
				if (statusType != SVNStatusType.STATUS_NORMAL && statusType != SVNStatusType.STATUS_IGNORED) {
					File file = status.getFile();
					System.out.println(status.getFile().getPath());

				}
			}
		});
	}
}
