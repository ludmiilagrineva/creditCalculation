package spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.entity.Calculation;

import java.util.List;

@Repository
public class CalculatorDAOImpl implements CalculatorDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCalculation(Calculation calculation) {
        Session session = sessionFactory.getCurrentSession();
        session.save(calculation);

    }

    @Override
    public List<Calculation> getAllCalculations() {

        Session session = sessionFactory.getCurrentSession();
        List<Calculation> allCalculation = session.createQuery("from Calculation", Calculation.class).getResultList();
        return allCalculation;
    }

    @Override
    public void deleteCalculations(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Calculation> query = session.createQuery("delete from Calculation " +
                "where id=:calculationId");
        query.setParameter("calculationId", id);
        query.executeUpdate();

    }

    @Override

    public Calculation getCalculation(int id) {
        Session session = sessionFactory.getCurrentSession();
        Calculation calculation = session.get(Calculation.class, id);
        return calculation;
    }
}

