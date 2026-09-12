package com.biswadeep.banquetHall.controller;

import com.biswadeep.banquetHall.Dto.*;
import com.biswadeep.banquetHall.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @GetMapping
    public ResponseEntity<String> greet() {
        return ResponseEntity.ok("Hello from server, Backend works perfectly");
    }
    


    //Photos
    @PostMapping("/postphoto")
    public ResponseEntity<PostDto> createPost(@RequestBody RequestPostDto req){
        return ResponseEntity.ok(adminService.createPost(req));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return ResponseEntity.ok(adminService.getAllPosts());
    }


    //Videos and Review
    @PostMapping("/postreview")
    public ResponseEntity<ReviewDto> createReview(@RequestBody RequestReviewDto req){
        return ResponseEntity.ok(adminService.createReview(req));
    }
    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewDto>> getAllReviews(){
        return ResponseEntity.ok(adminService.getAllReviews());
    }


    //Booking services api
    @PostMapping("/booking")
    public ResponseEntity<ResponseBook> createBookings(@RequestBody RequestBook req){
        return ResponseEntity.ok(adminService.createBookings(req));
    }

    @GetMapping("/fetchbookings")
    public ResponseEntity<List<ResponseBook>> getAllBookings(){
        return ResponseEntity.ok(adminService.getAllBookings());
    }


    //Delete bookings , posts , videos
    @DeleteMapping("/delete-booking/{email}")
    public ResponseEntity<String> deleteBookings(@PathVariable String email){
        return ResponseEntity.ok(adminService.deleteBookings(email));
    }
    @DeleteMapping("/delete-posts/{id}")
    public ResponseEntity<String> deletePosts(@PathVariable String id){
        return ResponseEntity.ok(adminService.deletePictures(id));
    }
    @DeleteMapping("/delete-reviews/{id}")
    public ResponseEntity<String> deleteReviews(@PathVariable String id){
        return ResponseEntity.ok(adminService.deleteReviews(id));
    }
}
