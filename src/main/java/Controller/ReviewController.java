package Controller;

import java.util.List;

import org.apache.catalina.realm.JNDIRealm.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Entity.Review;
import Service.ReviewService;

@RestController
@RequestMapping("/product/{productId}/reviews")
public abstract class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@PostMapping
		public abstract ResponseEntity<Review>createReview(
		@PathVariable Long productId,
		@RequestBody ReviewRequest reviewRequest,
		@AuthenticationPrincipal User user);
	{
		Review review = reviewService.addReview(productId,user.getId(),
				reviewRequest.getRating(),review.getTitle(),review.getComment());
		
		return new ResponseEntity<>(review,HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Review>>getReviews( 
			@PathVariable Long productId,@RequestParam int page,
			@RequestParam int size, @RequestParam String sortBy){
	List<Review>reviews= reviewService.getReviews(productId, page, size, sortBy);
		return new ResponseEntity<>(reviews,HttStatus.OK);
			
	@GetMapping("/summary")
	public ResponseEntity<ReviewSummary>getReviewSummary(
			@PathVariable Long productId){
		ReviewSummary summary = reviewService.getReviewSummary(productId);
	
		return new ResponseEntity<>(summary,HttpStatus.OK);
	}
		
	}
	
}
