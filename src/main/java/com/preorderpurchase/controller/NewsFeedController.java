package com.preorderpurchase.controller;

import com.preorderpurchase.domain.dto.NewsFeedResponseDto;
import com.preorderpurchase.service.NewsFeedService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasAnyRole('USER','ADMIN')")
public class NewsFeedController {

    private final NewsFeedService newsFeedService;

    public NewsFeedController(NewsFeedService newsFeedService) {
        this.newsFeedService = newsFeedService;
    }

    // 팔로우 뉴스피드
    @GetMapping("/newsfeed/follow")
    public ResponseEntity<List<NewsFeedResponseDto>> getFollowingList() {
        return ResponseEntity.ok().body(newsFeedService.getNewsFeedFollowList());
    }
}
