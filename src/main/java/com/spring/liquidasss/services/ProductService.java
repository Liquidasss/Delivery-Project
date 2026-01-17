package com.spring.liquidasss.services;

import com.spring.liquidasss.dao.ProductDao;
import com.spring.liquidasss.models.Delivery;
import com.spring.liquidasss.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductDao productDao;

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
        product.setId(id);
        return this.productDao.updateProduct(product);
    }

    public Boolean deleteProduct(int id){
        return this.productDao.deleteProduct(id);
    }

}
