package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
