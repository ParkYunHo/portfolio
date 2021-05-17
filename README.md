# Portfolio

Portfolio Web Application for Yoonho Park.

_New projects will continue to be updated in the [Table of Contents](#Table-of-Contents)_

## Table of Contents

* [Swagger2 (w/ Restful API)](#Swagger2)
* [Login (w/ NoSQL)](#Login)
* [ORM(JPA, JOOQ)&Mapper(Mybatis) 연동 __(진행중)__](#)
* [메신저 (w/ WebSocket) _(예정)_](#)
* [Jenkins를 통한 Spring batch 관리 _(예정)_](#)
* [YTM Crawling&Curve산출 (w/ Selenium) _(예정)_](#)
* [Apache Kafka를 활용한 메세지큐 구현 _(예정)_](#)
* [Kubernetes를 활용한 Container개발환경 구축 _(예정)_](#)



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
 
 
## Login
 
1. 개발환경
 * FE : HTML5, javascript
 * BE : Spring boot, Oracle 18c, MyBatis, Redis, Lettuce
 * Major : Redis, DB Trigger, HandlerInterceptor ~~(HandlerInterceptorAdapter)~~
 
2. 설명
 * 로그인기능, 회원가입기능, 비밀번호 찾기 기능구현
 * Login Session(FingerPrint) 정보를 Redis에 저장하여 생존주기 설정
 * DB Trigger를 통해 회원DB 변경이력 관리
 * 페이지이동 및 로그아웃시 HandlerInterceptor Interface를 구현한 클래스를 통해 Session 관리
 
## ORM(JPA, JOOQ)&Mapper(Mybatis) 연동

1. 개발환경
 * FE : HTML5, javascript
 * BE : Spring boot, Oracle 18c, MyBatis, JPA, Hibernate
 * Major : ORM, JPA, Hibernate, MyBatis
 
2. 설명
 * JPA와 Mybatis를 동시에 구현함으로써 각각의 장단점을 상호 보완
 * Restful API방식으로 JPA 구현
 ```
    GET     /userMgmt/jpa/{id}    : SELECT (조회)
    POST    /userMgmt/jpa         : INSERT (삽입)
    PUT     /userMgmt/jpa         : UPDATE (변경)
    DELETE  /userMgmt/jpa/{id}    : DELETE (삭제)
``` 
 * Swagger2를 활용하여 API 문서 자동화 구현 
 * JPA란?
    * MyBatis는 Mapper방식으로 복잡한 쿼리(특히 Select문) 작성시 유리
    * ORM
        * 객체와 관계형 DB 데이터를 자동으로 매핑(연결)
        * 객체를 통해 간적적으로 DB데이터 핸들링
        * 장점
            1. 객체지향적 코드로 직관적
            2. 재사용 및 유지보수의 편리성 증가
            3. DBMS에 대한 종속성이 줄어듬 (DBMS교체시 비교적 적은 리스크와 시간 소요)
        * 단점
            1. 러닝커브가 높다.
            2. 복잡한 SELECT문을 작성하기에 복잡함.
            3. 프로시저 베이스 시스템에서는 장점이 발휘되기 힘듬.
    * JPA (Java Persistence API)
        * 자바 Application에서 RDB 사용방식을 정의한 __인터페이스__
        * 특정 기능을하는 라이브러리가 아님.
    * Hibernate
        * JPA 인터페이스를 구현하는 구현체
        * JPA와 Hibernate는 Interface와 이를 구현한 Class와 같은 관계
