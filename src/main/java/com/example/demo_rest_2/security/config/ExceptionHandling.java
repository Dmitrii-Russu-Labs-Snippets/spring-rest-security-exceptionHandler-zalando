package com.example.demo_rest_2.security.config;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;


@RestControllerAdvice
class ExceptionHandling implements ProblemHandling, SecurityAdviceTrait {

}