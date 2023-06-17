package com.springweb.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springweb.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{


}
