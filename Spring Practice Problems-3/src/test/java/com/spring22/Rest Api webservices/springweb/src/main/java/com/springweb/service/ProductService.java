package com.springweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.Repository.ProductRepository;
import com.springweb.entity.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository p;
	
	
	
	public List<Product> findAllProduct(){
		return p.findAll();
	}
	
	
	public void InsertProduct(Product pe) {
		p.save(pe);
	}
	
	public Product getProduct(int id) {
		Optional<Product> pe = p.findById(id);
		return pe.orElse(null);
	
	}
	
	public void UpdateProduct(int id , Product pe) {
		if(p.findById(id).isPresent()) {
			Product product = p.findById(id).get();
			product.setName(pe.getName());
			product.setPrice(pe.getPrice());
			product.setDescription(pe.getDescription());
			
			p.save(product);
			
		}

	}
	
	public void deleteById(int id) {
		p.deleteById(id);
	}
	

}
