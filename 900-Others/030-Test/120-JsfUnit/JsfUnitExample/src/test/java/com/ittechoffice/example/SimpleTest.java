package com.ittechoffice.example;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class SimpleTest {
	
    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
            .addClasses(TestBean.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        // System.out.println(jar.toString(true));
        return jar;
    }
    
    @Inject
    TestBean testBean;
    
    @Test
    public void test(){
    	testBean.sayHi();
    }
}
