package org.example.testaverde;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(User user) {
        em.persist(user);
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public List<User> findAll() {
        Query query = em.createQuery("SELECT u FROM User u");
        return (List<User>) query.getResultList();
    }

    public List<User> search(String params) {
        String nativeSql = "Select * from users where name like '%" + params +"%'";
        Query query = em.createNativeQuery(nativeSql, User.class);
        return query.getResultList();
    }

}
