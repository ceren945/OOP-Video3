package oopWithNLayeredApp.business;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAcess.HibernateProductDao;
import oopWithNLayeredApp.dataAcess.JdbcProductDao;
import oopWithNLayeredApp.dataAcess.ProductDao;
import oopWithNLayeredApp.entities.Product;

import java.util.List;

public class ProductManager  {

    private ProductDao productDao;
    private Logger[] loggers;

    public ProductManager(ProductDao productDao,Logger[] loggers) {
        this.productDao = productDao;
        this.loggers = loggers;
    }

    public void add(Product product)throws Exception {

        if(product.getPrice()<10) {
            throw new Exception("Ürün Fiaytı 10'dan küçük olamaz.");
        }
//        JdbcProductDao productDao = new JdbcProductDao();
//        productDao.add(product);

//        HibernateProductDao hibernateProductDao = new HibernateProductDao();
//        hibernateProductDao.add(product);
//        ProductDao productDao = new JdbcProductDao();

         productDao.add(product);
         for(Logger logger : loggers) { //[db,mail]
             logger.log(product.getName());
         }
        }
    }

