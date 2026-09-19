package com.biswadeep.banquetHall.service;

import com.biswadeep.banquetHall.Dto.*;
import com.biswadeep.banquetHall.entity.BookingModel;
import com.biswadeep.banquetHall.entity.PostPictureModel;
import com.biswadeep.banquetHall.entity.ReviewModel;
import com.biswadeep.banquetHall.repository.BookingRepository;
import com.biswadeep.banquetHall.repository.PictureRepository;
import com.biswadeep.banquetHall.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final PictureRepository pictureRepository;
    private final ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;

    //Create post means uploads photo
    public PostDto createPost(RequestPostDto req){

        long autoIncId = pictureRepository.findAll().size();

        if(req.getImage().isEmpty() || !req.getImage().contains("https://res.cloudinary.com")){
            throw new RuntimeException("Image not found");
        }


        PostPictureModel result = PostPictureModel.builder()
                .image(req.getImage())
                .seq(autoIncId+1)
                .title(req.getTitle())
                .category(req.getCategory())
                .build();
        PostPictureModel savedPost = pictureRepository.save(result);

        PostDto response = new PostDto();
        response.setId(savedPost.getId());
        response.setImage(savedPost.getImage());
        response.setTitle(savedPost.getTitle());
        response.setSeq(savedPost.getSeq());
        response.setCategory(savedPost.getCategory());
        response.setCreatedAt(savedPost.getCreatedAt());
        response.setUpdatedAt(savedPost.getUpdatedAt());

        return response;
    }

    public List<PostDto> getAllPosts() {
        try{
        List<PostPictureModel> res = pictureRepository.findAll();
        return res.stream().map(post->{
            PostDto response = new PostDto();
            response.setId(post.getId());
            response.setImage(post.getImage());
            response.setSeq(post.getSeq());
            response.setTitle(post.getTitle());
            response.setCategory(post.getCategory());
            response.setCreatedAt(post.getCreatedAt());
            response.setUpdatedAt(post.getUpdatedAt());
            return response;
        }).toList();
        }catch(Exception e){
            throw new RuntimeException("Error getting posts");
        }
    }

    public ReviewDto createReview(RequestReviewDto req) {

        long autoIncId = reviewRepository.findAll().size();

        ReviewModel result = ReviewModel.builder()
                .name(req.getName())
                .seq(autoIncId+1)
                .video(req.getVideo())
                .comment(req.getComment())
                .build();

        ReviewModel savedReview = reviewRepository.save(result);

        ReviewDto response = new ReviewDto();
        response.setId(savedReview.getId());
        response.setName(savedReview.getName());
        response.setSeq(savedReview.getSeq());
        response.setVideo(savedReview.getVideo());
        response.setComment(savedReview.getComment());
        response.setCreatedAt(savedReview.getCreatedAt());
        response.setUpdatedAt(savedReview.getUpdatedAt());

        return response;
    }

    public List<ReviewDto> getAllReviews(){
        List<ReviewModel> res = reviewRepository.findAll();
        return res.stream().map(review->{
            ReviewDto response = new ReviewDto();
            response.setId(review.getId());
            response.setName(review.getName());
            response.setSeq(review.getSeq());
            response.setVideo(review.getVideo());
            response.setComment(review.getComment());
            response.setCreatedAt(review.getCreatedAt());
            response.setUpdatedAt(review.getUpdatedAt());
            return response;
        }).toList();
    }



    //Booking Services
    public ResponseBook createBookings(RequestBook req) {
        BookingModel result = BookingModel.builder()
                .firstname((req.getFirstname()))
                .lastname(req.getLastname())
                .email(req.getEmail())
                .phone(req.getPhone())
                .message(req.getMessage()).build();

        BookingModel savedBook = bookingRepository.save(result);

        ResponseBook response = new ResponseBook();
        response.setId(savedBook.getId());
        response.setFirstname(savedBook.getFirstname());
        response.setLastname(savedBook.getLastname());
        response.setEmail(savedBook.getEmail());
        response.setPhone(savedBook.getPhone());
        response.setMessage(savedBook.getMessage());
        response.setCreatedAt(savedBook.getCreatedAt());

        return response;
    }


    public List<ResponseBook> getAllBookings() {
        List<BookingModel> res = bookingRepository.findAll();
        return res.stream().map(booking->{
            ResponseBook response = new ResponseBook();
            response.setId(booking.getId());
            response.setFirstname(booking.getFirstname());
            response.setLastname(booking.getLastname());
            response.setEmail(booking.getEmail());
            response.setPhone(booking.getPhone());
            response.setMessage(booking.getMessage());
            response.setCreatedAt(booking.getCreatedAt());
            return response;
        }).toList();
    }

    public String deleteBookings(String email) {

        if(!bookingRepository.existsByEmail(email)){
            return "Please, Provide the existing email";
        }
        bookingRepository.deleteByEmail(email);
        return "Booking deleted successfully";
    }
    public String deletePictures(String id){

        if(!pictureRepository.existsById(id)){
            return "Please, Provide the right url!!";
        }

        pictureRepository.deleteById(id);
        return "Picture deleted successfully";
    }
    public String deleteReviews(String id){

        if(!reviewRepository.existsById(id)){
            return "Please, Provide the right id!!";
        }

        reviewRepository.deleteById(id);
        return "Review deleted successfully";
    }
}
