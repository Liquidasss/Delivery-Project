package com.spring.liquidasss.services;

import com.spring.liquidasss.dao.ProductDao;
import com.spring.liquidasss.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product addProduct(Product product){
        return this.productDao.addProduct(product);
    }

    public List<Product> getProducts(){
        return this.productDao.getProducts();
    }

    public Product getProduct(int id){
        return this.productDao.getProduct(id);
    }

    public Product updateProduct(int id, Product product){
        return this.productDao.updateProduct(product);
    }

    public Boolean deleteProduct(int id){
        return this.productDao.deleteProduct(id);
    }

}
