# Portfolio

Portfolio Web Application for Yoonho Park.

_New projects will continue to be updated in the [Table of Contents](#Table-of-Contents)_

## Table of Contents

* [Swagger2 (w/ Restful API)](#Swagger2)

## Swagger2

1. 개발환경
 * FE : HTML5, javascript
 * BE : Spring boot, Oracle 18c, iBatis
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
 