package com.example.demo.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ImageRequest {
    String url;
}
