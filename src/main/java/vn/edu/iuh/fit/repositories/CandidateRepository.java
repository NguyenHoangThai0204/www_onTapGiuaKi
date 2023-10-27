package vn.edu.iuh.fit.repositories;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import vn.edu.iuh.fit.data.ConnectionDb;
import vn.edu.iuh.fit.models.Candidate;
import vn.edu.iuh.fit.models.Roles;

import java.util.List;
import java.util.Optional;

public class CandidateRepository {
    private SessionFactory sessionFactory;
    public CandidateRepository (){
        this.sessionFactory = ConnectionDb.getInstance().getSessionFactory();
    }
    public void insertCan(Candidate c ){
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(c);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }
    public void delete(long id ){
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Candidate candidate = session.get(Candidate.class, id);
            session.delete(candidate);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
        }
    }

    public List<Candidate> getAllCan(){
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            List<Candidate> can = session
                    .createQuery("from Candidate ", Candidate.class)
                            .getResultList();
            transaction.commit();
            return can;
        }catch (Exception e){
            transaction.rollback();
        }
        return null;
    }
    public Optional<Candidate> getCanById(long id){
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Candidate candidate = session.get(Candidate.class, id);
            transaction.commit();
            return Optional.ofNullable(candidate);
        }catch (Exception e){
            transaction.rollback();
        }
        return Optional.empty();
    }
    public List<Candidate> getAllCanByRole(Roles roles) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List<Candidate> can = session
                    .createQuery("select distinct c from Candidate c join " +
                            "c.experiences e where e.roles = :role", Candidate.class)
                    .setParameter("role", roles)
                    .getResultList();
            transaction.commit();
            return can;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    public List<Candidate> getAllCanHaveEmail() {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            List<Candidate> can = session
                    .createQuery("from Candidate where email is null", Candidate.class)
                    .getResultList();
            transaction.commit();
            return can;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

}
