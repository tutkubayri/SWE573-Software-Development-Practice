package com.swe.comin.controllers;

import com.swe.comin.models.Community;
import com.swe.comin.services.CommunityService;
import com.swe.comin.services.PostTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CommunityController {

    private CommunityService communityService;
    private PostTypeService postTypeService;

    public CommunityController(CommunityService communityService) {

        this.communityService = communityService;
    }

    @GetMapping({"/communities"})
    public ResponseEntity<List<Community>> getAllCommunity() {
        return ResponseEntity.ok(communityService.getAllCommunity());
    }

    @GetMapping("communities/id/{communityId}")
    public ResponseEntity<Community> getCommunityById(@PathVariable Long communityId) {
        return ResponseEntity.ok(communityService.getCommunityById(communityId));
    }

    @PostMapping({"communities/add"})
    public ResponseEntity<Community> saveCommunity(@RequestBody Community communityRequest) {
        return ResponseEntity.ok(communityService.saveCommunity(communityRequest));
    }

    @PutMapping("communities/{communityId}")
    public ResponseEntity<Community> updateCommunity(@PathVariable Long communityId, @RequestBody Community communityRequest) {
        return ResponseEntity.ok(communityService.updateCommunity(communityId, communityRequest));
    }

    @DeleteMapping("communities/{communityId}")
    public void deleteCommunityById(@PathVariable Long communityId) {
        communityService.deleteCommunityById(communityId);
    }
}