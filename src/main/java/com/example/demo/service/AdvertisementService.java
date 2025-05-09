package com.example.demo.service;

import com.example.demo.dto.request.AdvertisementCreationRequest;
import com.example.demo.dto.response.AdvertisementResponse;
import com.example.demo.entity.Advertisement;
import com.example.demo.mapper.AdvertisementMapper;
import com.example.demo.repository.AdvertisementRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AdvertisementService {
    AdvertisementRepository advertisementRepository;
    AdvertisementMapper advertisementMapper;

    public AdvertisementResponse createAdvertisement(AdvertisementCreationRequest request) {
        Advertisement advertisement = advertisementMapper.toAdvertisement(request);
        return advertisementMapper.toAdvertisementResponse(advertisementRepository.save(advertisement));
    }

    public List<AdvertisementResponse> getAllAdvertisements() {
        return advertisementMapper.toAdvertisementResponseList(advertisementRepository.findAll());
    }
}
