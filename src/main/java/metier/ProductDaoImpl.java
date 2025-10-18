package metier;

import dao.IDao;
import entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements IDao<Product> {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public boolean create(Product product) {
        getCurrentSession().save(product);
        return true;
    }

    @Override
    public boolean delete(Product product) {
        getCurrentSession().delete(product);
        return true;
    }

    @Override
    public boolean update(Product product) {
        getCurrentSession().update(product);
        return true;
    }

    @Override
    public Product findById(int id) {
        return getCurrentSession().get(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        return getCurrentSession().createQuery("from Product", Product.class).list();
    }
}
