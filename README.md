# Portfolio

Portfolio Web Application for Yoonho Park.

_New projects will continue to be updated in the [Table of Contents](#Table-of-Contents)_

## Table of Contents

* [Swagger2 (w/ Restful API)](#Swagger2)
* [Login (w/ NoSQL) __(������)__](#Login (������))
* [ORM(JPA, JOOQ)&Mapper(Mybatis) ����   _(����)_](#)
* [Email �ۼ��� _(����)_](#)
* [YTM Crawling&Curve���� (w/ Selenium) _(����)_](#)
* [Web Compiler _(����)_](#)
* [�޽��� (w/ WebSocket) _(����)_](#)
* [Jenkins�� ���� Spring batch ���� _(����)_](#)


## Swagger2

1. ����ȯ��
 * FE : HTML5, javascript
 * BE : Spring boot, Oracle 18c, MyBatis
 * Major : Swagger2, RestfulAPI
 
2. ����
 * Restful API ������� HTTP Method 4������ Ȱ���Ͽ� ����� ���� ����
```
    GET     /userMgmt/{id}    : SELECT (��ȸ)
    POST    /userMgmt         : INSERT (����)
    PUT     /userMgmt         : UPDATE (����)
    DELETE  /userMgmt/{id}    : DELETE (����)
``` 
 * Swagger2�� Ȱ���Ͽ� API ���� �ڵ�ȭ ���� 
 
 
 ## Login (������)
 
1. ����ȯ��
 * FE : HTML5, javascript
 * BE : Spring boot, Oracle 18c, MyBatis, Redis, Jedis
 * Major : Redis, DB Trigger, HandlerInterceptorAdapter
 
2. ����
 * �α��α��, ȸ�����Ա��, ��й�ȣ ã�� ��ɱ���
 * Login Session(FingerPrint) ������ Redis�� �����Ͽ� �����ֱ� ����
 * DB Trigger�� ���� ȸ��DB �����̷� ����
 * �������̵� �� �α׾ƿ��� HandlerInterceptorAdapter Class�� ����� Ŭ������ ���� Session ����
 
