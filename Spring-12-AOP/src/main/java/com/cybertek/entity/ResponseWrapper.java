package com.cybertek.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;


// this class is needed for customization of Json file ( what do we want see in a response)
@Getter
@Setter
@NoArgsConstructor
public class ResponseWrapper {
    private boolean success;
    private String message;
    private Integer code;
    private Object data;
 // we have 2 constructor when we post we want to see message and data , but if delete data we want to see message
    public ResponseWrapper(String message,  Object data) {
        this.message = message;
        this.data = data;
        this.code= HttpStatus.OK.value();
        this.success = true;
    }

    public ResponseWrapper(String message) {
        this.message = message;
        this.code= HttpStatus.OK.value();
        this.success = true;

    }
}
