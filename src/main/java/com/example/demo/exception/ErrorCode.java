package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
@AllArgsConstructor
public enum ErrorCode {
    EMAIL_EXITED(9999, "Email đã tồn tại", HttpStatus.BAD_REQUEST),
    USER_EXITED(9999, "Tên người dùng đã tồn tại", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1000, "Không tìm thấy người dùng", HttpStatus.NOT_FOUND),
    USER_NOT_AUTHORIZED(1002, "Người dùng không được phép", HttpStatus.UNAUTHORIZED),
    USER_NOT_VALID(1003, "Tên người dùng phải ít nhất 2 ký tự", HttpStatus.BAD_REQUEST),
    PASSWORD_NOT_VALID(1004, "Mật khẩu phải ít nhất 8 ký tự", HttpStatus.BAD_REQUEST),
    EMAIL_NOT_VALID(1005, "Email không hợp lệ", HttpStatus.BAD_REQUEST),
    DOB_NOT_NULL(1006, "Ngày sinh không được để trống", HttpStatus.BAD_REQUEST),
    USER_NOT_AUTH(1007, "Tên đăng nhập hoặc mật khẩu không đúng", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1008, "Bạn không có quyền truy cập ", HttpStatus.FORBIDDEN),
    ;

    int code;
    String message;
    int statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode.value();
    }
}
