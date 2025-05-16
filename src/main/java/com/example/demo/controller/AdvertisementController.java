package com.example.demo.controller;

import com.example.demo.dto.request.AdvertisementCreationRequest;
import com.example.demo.dto.request.ApiResponse;
import com.example.demo.dto.response.AdvertisementResponse;
import com.example.demo.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisement")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;

    @PostMapping()
    ApiResponse<AdvertisementResponse> addAdvertisement(@RequestBody AdvertisementCreationRequest request) {
        ApiResponse<AdvertisementResponse> response = new ApiResponse<>();
        AdvertisementResponse advertisement = advertisementService.createAdvertisement(request);
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(advertisement);
        return response;
    }

    @GetMapping()
    ApiResponse<List<AdvertisementResponse>> getAllAdvertisements() {
        ApiResponse<List<AdvertisementResponse>> response = new ApiResponse<>();
        response.setCode(200);
        response.setMessage("Success");
        response.setResult(advertisementService.getAllAdvertisements());
        response.setTotalRecords(
                advertisementService.getAllAdvertisements().size()
        );
        return response;
    }

    @DeleteMapping("/{id}")
    ApiResponse<Void> deleteAdvertisement(@PathVariable String id) {
        ApiResponse<Void> response = new ApiResponse<>();
        advertisementService.deleteAdvertisement(id);
        response.setCode(200);
        response.setMessage("Success");
        return response;
    }
}
