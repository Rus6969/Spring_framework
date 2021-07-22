package com.cybertek.aspects;
import com.cybertek.controller.ProductController;
import com.cybertek.entity.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(ProductController.class);
//  // this pointcut will work in all methods under controller
//    @Pointcut("execution(* com.cybertek.controller.ProductController.*(..))")
//    public void pointcut(){}
//
//    // advice implement this pointcut which above willl implement evverywhere after each method in controller
//    @Before("pointcut()")
//    public void log(){
//        logger.info("-------------");
//    }
//
//  // without using a pointcut
//    @Before("execution(* com.cybertek.controller.ProductController.*(..))")
//    public void beforeAdvice(){
//        logger.info("-----------");
//    }
//
//
//  //  execution
//    // meaning go to that specific controller class all methods started with up( update)
//    @Pointcut("execution(* com.cybertek.controller.ProductController.up*(..))")
//    private void anyUpdateOperation(){}
//
//    @Pointcut("execution(* com.cybertek.repository.ProductRepository.findById(Long))")
//    private void anyProductRepositoryFindById(){}
//    //
//    @Before("anyProductRepositoryFindById()")
//    public void beforeProductRepoAdvice(JoinPoint joinPoint){
//        logger.info("Before(findById) -> Method {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
//    }
//     //so here we are using joinpoint we want to
//    @Before("anyUpdateOperation()")
//    public void beforeControllerAdvice(JoinPoint joinPoint){
//        logger.info("Before -> Method {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
//    }
//
//    //within
//    // class level under controller run any class (..)- means any subpackages all classes
//    @Pointcut("within(com.cybertek.controller..*)")
//    private void anyControllerOperation(){}
//    // @within annotation level looking a specific annotation
//    @Pointcut("@within(org.springframework.stereotype.Service)")
//    private void anyServiceAnnotatedOperation(){}
//
//
//
//// here we can combine pointcuts
//    @Before("anyServiceAnnotatedOperation() || anyControllerOperation() ")
//    public void beforeControllerAdvice2(JoinPoint joinPoint){
//        logger.info("Before -> Method : {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
//    }

//    //annotation     @annotation works on method level @within on a class level
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    private void anyDeleteProductOperation(){}

//    @Before("anyDeleteProductOperation()")
//    public void beforeControllerAdvice(JoinPoint joinPoint){
//        logger.info("Before -> Method : {} - Arguments : {} - Target : {}",joinPoint,joinPoint.getArgs(),joinPoint.getTarget());
//    }

    //after returning
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetProductOperation(){}

    @AfterReturning(pointcut = "anyGetProductOperation()",returning = "results")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, Product results){
        // since we can return one product or all products thats we are using mono to return one
        logger.info("After Returning(Mono Result) -> Method : {} - results :{}",joinPoint.getSignature().toShortString(),results);
    }
    // here example of returning all products
    @AfterReturning(pointcut = "anyGetProductOperation()",returning = "results")
    public void afterReturningControllerAdvice2(JoinPoint joinPoint, List<Product> results){
        logger.info("After Returning(List Result) -> Method : {} - results :{}",joinPoint.getSignature().toShortString(),results);
    }


}

