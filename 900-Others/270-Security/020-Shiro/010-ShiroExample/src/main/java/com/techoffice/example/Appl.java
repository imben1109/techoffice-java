package com.techoffice.example;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Appl {
	
    private static final transient Logger log = LoggerFactory.getLogger(Appl.class);

	public static void main(String[] args){
	    Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
	    SecurityManager securityManager = factory.getInstance();
	    SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();

        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        log.info("Retrieved the correct value! [" + value + "]");

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("testerUsername", "testerPassword");
            token.setRememberMe(true);
            currentUser.login(token);
        }
        
        if (currentUser.isAuthenticated()){
        	log.info("Current User is authenticated!");
        }

        currentUser.logout();
        if (!currentUser.isAuthenticated()){
        	log.info("Current User is not authenticated after logout!");
        }
	}
}
