package com.example.session08.controller;

import com.example.session08.model.dto.PasswordUpdateRequest;
import com.example.session08.model.entity.Course;
import com.example.session08.model.entity.Enrollment;
import com.example.session08.model.entity.User;
import com.example.session08.security.UserPrincipal;
import com.example.session08.service.EnrollmentService;
import com.example.session08.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/profile")
public class UserController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private UserService userService;

    @PostMapping("/enrollments/register")
    public ResponseEntity<?> registerCourse(@RequestParam("courseId") long courseId , @AuthenticationPrincipal UserPrincipal userPrincipal ) {
        Enrollment registered = enrollmentService.registerCourse(userPrincipal.getUser(), courseId);
        if (registered == null) {
            return new ResponseEntity<>("Course not registered", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(registered, HttpStatus.CREATED);
        }
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<String> updatePassword(@RequestBody PasswordUpdateRequest request,
                                                 @AuthenticationPrincipal UserPrincipal userPrincipal) {
        String rs  = userService.updatePassword(userPrincipal.getUser(),request.getOldPassword(),request.getNewPassword(),
                request.getConfirmPassword());
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    @GetMapping("/myCourses")
    public ResponseEntity<List<Enrollment>> getMyCourses(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        List<Enrollment> enrollments = enrollmentService.getRegisteredCourses(userPrincipal.getUser().getId());
        return ResponseEntity.ok(enrollments);
    }
}