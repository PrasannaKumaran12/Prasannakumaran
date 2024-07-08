package Repository;

import java.awt.print.Pageable;
import java.util.List;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long>{

	boolean existByProductIdAndUserID(Long productID,Long userId);
	
	Page findByProductId(Long productId, Pageable pageable);
	
	List<Review>findanotherByProductId(Long productId);
}
