package com.cybertek.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
/*
to carry default message in api we are using pojos getters setters , for example we have response 404(Bad credentials)
we need to capture this message and we need to bring this message in response body response in responseEntity

 */
@Getter
@Setter
@Builder
public class DefaultExceptionMessageDto {

    private String message;
}
