package org.jboss.arquillian.wildfly.embedded.example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.wildfly.embedded.example.model.Person;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;


import javax.ejb.EJB;

@RunWith(Arquillian.class)
public class EmptyDeploymentTest {

    @Deployment
    public static Archive deploy(){

        return ShrinkWrap.create(WebArchive.class,
                "test.war")
                .addClass(Person.class)
                .addClass(MyService.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
    }

    @EJB
    MyService myService;

    @Test
    public void emptyInContainerTest(){
        System.out.println("=========================================");
        System.out.println("This test should run inside the container");
        System.out.println("=========================================");
        System.out.println(myService.callMe("number"));



    }
}
