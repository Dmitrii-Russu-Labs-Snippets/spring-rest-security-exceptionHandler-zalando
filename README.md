# Spring REST Security Exception Handling (Zalando)

Centralized handling of Spring Security authentication and authorization exceptions using [Zalando Problem-Spring-Web](https://github.com/zalando/problem-spring-web).  
Returns standardized [ProblemDetail (RFC 7807)](https://datatracker.ietf.org/doc/html/rfc7807) JSON responses for all security errors (401 Unauthorized / 403 Forbidden).

---


## Overview
This repository demonstrates how to handle Spring Security exceptions (authentication and authorization) in a centralized way using **Zalando Problem-Spring-Web**.  
Instead of writing custom `AuthenticationEntryPoint`, `AccessDeniedHandler`, or global `@ExceptionHandler`, we rely on Zalando's library, which automatically maps exceptions into **Problem JSON** responses.

---

## Features
- **401 Unauthorized** → RFC 7807 Problem JSON with status `401`
- **403 Forbidden** → RFC 7807 Problem JSON with status `403`
- Standardized error format powered by Zalando
- No need for custom `@RestControllerAdvice`
- Consistent and extendable error responses across the application

---

## Example 401 response
```http
Content-Type: application/problem+json

{
  "type": "about:blank",
  "title": "Unauthorized",
  "status": 401,
  "detail": "Full authentication is required to access this resource",
  "instance": "/auth/user"
}
```

## Example 403 response
```http
Content-Type: application/problem+json

{
  "type": "about:blank",
  "title": "Forbidden",
  "status": 403,
  "detail": "Access Denied",
  "instance": "/auth/admin"
}
```

---

## How to Run
```
./mvnw spring-boot:run
```
---

## Example curl
401 (no credentials)
```
curl -i http://localhost:8080/auth/user
```
401 (wrong credentials)
```
curl -i -u wrong:wrong http://localhost:8080/auth/user
```
403 (authenticated but not authorized)
```
curl -i -u ann:1234 http://localhost:8080/auth/admin
```
200 (authorized)
```
curl -i -u jack:123 http://localhost:8080/auth/admin
```
---

## Related

- [spring-rest-security-entrypointHandler-component](https://github.com/Dmitrii-Russu-Labs-Snippets/spring-rest-security-entrypointHandler-component) — handlers as separate components  
- [spring-rest-security-entrypointHandler-bean](https://github.com/Dmitrii-Russu-Labs-Snippets/spring-rest-security-entrypointHandler-bean) — handlers as Spring beans

