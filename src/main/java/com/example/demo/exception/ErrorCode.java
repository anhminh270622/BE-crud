package com.example.demo.exception;

public enum ErrorCode {
    EMAIL_EXITED(9999, "Email đã tồn tại"),
    USER_EXITED(9999, "Tên người dùng đã tồn tại"),
    USER_NOT_FOUND(1000, "Không tìm thấy người dùng"),
    USER_NOT_AUTHORIZED(1002, "Người dùng không được phép"),
    USER_NOT_VALID(1003, "Tên người dùng phải ít nhất 2 ký tự"),
    PASSWORD_NOT_VALID(1004, "Mật khẩu phải ít nhất 8 ký tự"),
    EMAIL_NOT_VALID(1005, "Email không hợp lệ"),
    DOB_NOT_NULL(1006, "Ngày sinh không được để trống"),
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
