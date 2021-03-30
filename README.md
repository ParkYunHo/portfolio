# Portfolio

Portfolio Web Application for Yoonho Park.

_New projects will continue to be updated in the [Table of Contents](#Table-of-Contents)_

## Table of Contents

* [Swagger2 (w/ Restful API)](#Swagger2)
* [Login (w/ NoSQL) __(진행중)__](#Login (진행중))
* [ORM(JPA, JOOQ)&Mapper(Mybatis) 연동   _(예정)_](#)
* [Email 송수신 _(예정)_](#)
* [YTM Crawling&Curve산출 (w/ Selenium) _(예정)_](#)
* [Web Compiler _(예정)_](#)
* [메신저 (w/ WebSocket) _(예정)_](#)
* [Jenkins를 통한 Spring batch 관리 _(예정)_](#)


## Swagger2

1. 개발환경
 * FE : HTML5, javascript
 * BE : Spring boot, Oracle 18c, MyBatis
 * Major : Swagger2, RestfulAPI
 
2. 설명
 * Restful API 방식으로 HTTP Method 4가지를 활용하여 사용자 정보 관리
```
    GET     /userMgmt/{id}    : SELECT (조회)
    POST    /userMgmt         : INSERT (삽입)
    PUT     /userMgmt         : UPDATE (변경)
    DELETE  /userMgmt/{id}    : DELETE (삭제)
``` 
 * Swagger2를 활용하여 API 문서 자동화 구현 
 
 
 ## Login (진행중)
 
1. 개발환경
 * FE : HTML5, javascript
 * BE : Spring boot, Oracle 18c, MyBatis, Redis, Jedis
 * Major : Redis, DB Trigger, HandlerInterceptorAdapter
 
2. 설명
 * 로그인기능, 회원가입기능, 비밀번호 찾기 기능구현
 * Login Session(FingerPrint) 정보를 Redis에 저장하여 생존주기 설정
 * DB Trigger를 통해 회원DB 변경이력 관리
 * 페이지이동 및 로그아웃시 HandlerInterceptorAdapter Class를 상속한 클래스를 통해 Session 관리
 
