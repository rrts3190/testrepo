package com.multipldb.multipldb.postgresql.repo;

import com.multipldb.multipldb.postgresql.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer>
{
   Product findByName(String name);
}
