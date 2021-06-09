package com.cybertek.exception;
import com.cybertek.entity.DefaultExceptionMessageDto;
import com.cybertek.entity.ResponseWrapper;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;
import java.nio.file.AccessDeniedException;
import java.util.Optional;
// this annotation means create a global structure allows us run this HAandler without object creation
@RestControllerAdvice
//there are 2 high low  precedence  HIGH spring we consider custom handling first priority , low priority
// Spring will take care of in inbuild default way
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionMessageHandler {


     // This ServiceException comming from our class not Spring )
    /*
    here we show related which class exception to use in User Service we are throwing custom exception

     */

    // this exception was manualy called in USER service class when we create a user(called in userservice class)
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ResponseWrapper> serviceException(ServiceException se){
        // here get message there are 2 options first option Spring has inbuilt message or we can override it.
        //to override this exception we created an annotation in @DEFAULTExceptionmesage
    String message =se.getMessage();
    return  new ResponseEntity<>(ResponseWrapper.builder()
            .success(false)
            .code(HttpStatus.CONTINUE.value())
            .message(message)
            .build(),HttpStatus.CONFLICT);
    }

    // here we are saying that this exception will be called as soon this exception is met
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ResponseWrapper> serviceException(AccessDeniedException se){
        //which message will be added here . 2 options
        String message =se.getMessage();
        return  new ResponseEntity<>(ResponseWrapper.builder()
                .success(false)
                .code(HttpStatus.FORBIDDEN.value())
                .message(message)
                .build(),HttpStatus.CONFLICT);
    }
// GEneric Exception if exception belongs one of the classes , run my exception
    @ExceptionHandler({Exception.class, RuntimeException.class, Throwable.class, BadCredentialsException.class})
    public ResponseEntity<ResponseWrapper> genericException(Throwable e, HandlerMethod handlerMethod) {
        // Spring will take message from annotation
        Optional<DefaultExceptionMessageDto> defaultMessage = getMessageFromAnnotation(handlerMethod.getMethod());
        if (defaultMessage.isPresent() && !ObjectUtils.isEmpty(defaultMessage.get().getMessage())) {
            ResponseWrapper response = ResponseWrapper
                    .builder()
                    .success(false)
                    .message(defaultMessage.get().getMessage())
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(ResponseWrapper.builder().success(false).message("Action failed: An error occurred!").code(HttpStatus.INTERNAL_SERVER_ERROR.value()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private Optional<DefaultExceptionMessageDto> getMessageFromAnnotation(Method method) {
        com.cybertek.annotation.DefaultExceptionMessage defaultExceptionMessage = method.getAnnotation(com.cybertek.annotation.DefaultExceptionMessage.class);
        if (defaultExceptionMessage != null) {
            DefaultExceptionMessageDto defaultExceptionMessageDto = DefaultExceptionMessageDto
                    .builder()
                    .message(defaultExceptionMessage.defaultMessage())
                    .build();
            return Optional.of(defaultExceptionMessageDto);
        }
        return Optional.empty();
    }


}
