package com.example.demo.mapper;

import com.example.demo.dto.request.AdvertisementCreationRequest;
import com.example.demo.dto.response.AdvertisementResponse;
import com.example.demo.entity.Advertisement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdvertisementMapper {
    Advertisement toAdvertisement(AdvertisementCreationRequest advertisementCreationRequest);

    AdvertisementResponse toAdvertisementResponse(Advertisement advertisement);

    java.util.List<AdvertisementResponse> toAdvertisementResponseList(java.util.List<Advertisement> advertisements);
}
