package com.example.springbootelasticsearch.repository;

import com.example.springbootelasticsearch.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductMysqlRepo extends JpaRepository<Product, Long> {
}
