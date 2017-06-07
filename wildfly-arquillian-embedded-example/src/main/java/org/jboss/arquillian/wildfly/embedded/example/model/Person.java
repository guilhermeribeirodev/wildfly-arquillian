package org.jboss.arquillian.wildfly.embedded.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by guidev on 6/3/17.
 */
@Entity
public class Person {
    private String id;
    static int countId = 0;

    public Person() {
        id = String.valueOf(++Person.countId);
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
