package com.ernest.productsandcategories.services;

import java.util.List; 
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ernest.productsandcategories.models.Category;
import com.ernest.productsandcategories.models.CategoryProduct;
import com.ernest.productsandcategories.models.Product;
import com.ernest.productsandcategories.repositories.CategoryProductRepository;
import com.ernest.productsandcategories.repositories.CategoryRepository;
import com.ernest.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	private final CategoryProductRepository categoryProductRepository;
	private final CategoryRepository categoryRepository;
	
	public ProductService (ProductRepository productRepository, CategoryProductRepository categoryProductRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryProductRepository = categoryProductRepository;
		this.categoryRepository = categoryRepository;
	}
	
	  
    public List<Product> allProduct() {
        return productRepository.findAll();
    }
    
    
    public Product createProduct(Product p) {
        return productRepository.save(p);
    }
    
    
    public Product findProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            return optionalProduct.get();
        } else {
            return null;
        }
    }
    
	//======================================================
	// create a relationship between product and category
	//======================================================
	public CategoryProduct saveRelationship(CategoryProduct cp) {
		return categoryProductRepository.save(cp);
	}
	
	//======================================================
	// Finding a product id not containing in  category
	//======================================================
	public List<Category> excludeCategories(Product product){
		return categoryRepository.findByProductsId(product);
	}
	
	
	//======================================================
	// Finding a category id not containing in product
	//======================================================
	public List<Product> excludeProducts(Category category){
		return productRepository.findByCategoriesId(category);
	}
	
}
