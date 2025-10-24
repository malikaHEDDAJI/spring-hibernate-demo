package tests;

import dao.IDao;
import entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import util.HibernateConfig;

import static org.junit.jupiter.api.Assertions.*;


@SpringJUnitConfig(classes = HibernateConfig.class)
public class ProductDaoTest {

    @Autowired
    private IDao<Product> productDao;

    @Test
    public void testCreateProduct() {
        Product p = new Product();
        p.setName("Test Produit");
        p.setPrice(50.0);

        boolean result = productDao.create(p);
        assertTrue(result);
        assertNotEquals(0, p.getId());
    }

    @Test
    public void testFindAllProducts() {
        assertNotNull(productDao.findAll());
    }
}
