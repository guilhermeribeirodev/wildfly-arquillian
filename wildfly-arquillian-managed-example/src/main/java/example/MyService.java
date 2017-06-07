package example;

import example.model.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by guidev on 6/3/17.
 */

@Stateless
public class MyService {

    @PersistenceContext
    EntityManager em;

    public String callMe(String number) {
        em.persist(new Person());
        em.persist(new Person());
        em.persist(new Person());

        Query q = em.createQuery("select p from Person p");
        String res = ((Person)q.getResultList().get(0)).getId();

        Query q1 = em.createQuery("select count(p) from Person p");
        return "Calling at "+ res + " "+ q1.getSingleResult();
    }
}
