package com.ernest.productsandcategories.repositories;

import java.util.List; 

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ernest.productsandcategories.models.Category;
import com.ernest.productsandcategories.models.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
    // this method retrieves all from the database
    List<Product> findAll();
    
    List<Product> findByCategoriesId(Category category); 
    
   
}