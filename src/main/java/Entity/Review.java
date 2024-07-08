package Entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long prouctId;
	private Long userId;
	private int rating;
	private String title;
	private String comment;
	private Timestamp timestamp;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getProuctId() {
		return prouctId;
	}
	public void setProuctId(Long prouctId) {
		this.prouctId = prouctId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp1(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public Review(Long id, Long prouctId, Long userId, int rating, String title, String comment, Timestamp timestamp) {
		super();
		this.id = id;
		this.prouctId = prouctId;
		this.userId = userId;
		this.rating = rating;
		this.title = title;
		this.comment = comment;
		this.timestamp = timestamp;
	}
	public Review() {
			}
	@Override
	public String toString() {
		return "Review [id=" + id + ", prouctId=" + prouctId + ", userId=" + userId + ", rating=" + rating + ", title="
				+ title + ", comment=" + comment + ", timestamp=" + timestamp + "]";
	}
	public void setTimestamp(Timestamp timestamp2) {
		
	}
	
	
}
