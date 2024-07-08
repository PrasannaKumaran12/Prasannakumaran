package Service;

import java.awt.print.Pageable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import Entity.Review;
import Repository.ReviewRepository;

@Service

public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	public Review addReview(Long productId,Long userId,
			int rating,String title,String comment) {
		if(rating <1 || rating>5) 
		{
			throw new IllegalArgumentException("Rating should be between 1 - 5");
		}
	
		if(reviewRepository.existByProductIdAndUserID(productId, userId))
		{
		throw new IllegalArgumentException("Alreay Reviewed");
		}
	
		Review review = new Review();
		review.setProuctId(productId);
		review.setUserId(userId);
		review.setRating(rating);
		review.setComment(comment);
		review.setTitle(title);
		review.setTimestamp(new Timestamp(System.currentTimeMillis()));
		
		return reviewRepository.save(review);
	}
	
	public List<Review>getReviews(Long productId,int page,int size,String sortBy){
		Pageable pageable =PageRequest.of(page, size,Sort.by(sortBy));
		return ((reviewRepository.findByProductId(productId,pageable)).getContent();
	}
	public ReviewSummary getReviewSummary(Long ProductId) {
		List<Review>reviews= reviewRepository.findanotherByProductId(ProductId);
		double averageRating= reviews.stream().mapToInt(Review::genRating).average().
				orelse(0.0);
		Map<Integer,Long>ratingDistribution=reviews.stream().
				collect(Collectors.groupingBy(Review::getRating,Collectors.counting()));
		return new ReviewSummary(averageRating,ratingDistribution);
		
	}
		
}
