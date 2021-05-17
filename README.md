# Portfolio

Portfolio Web Application for Yoonho Park.

_New projects will continue to be updated in the [Table of Contents](#Table-of-Contents)_

## Table of Contents

* [Swagger2 (w/ Restful API)](#Swagger2)
* [Login (w/ NoSQL)](#Login)
* [ORM(JPA, JOOQ)&Mapper(Mybatis) ���� __(������)__](#)
* [�޽��� (w/ WebSocket) _(����)_](#)
* [Jenkins�� ���� Spring batch ���� _(����)_](#)
* [YTM Crawling&Curve���� (w/ Selenium) _(����)_](#)
* [Apache Kafka�� Ȱ���� �޼���ť ���� _(����)_](#)
* [Kubernetes�� Ȱ���� Container����ȯ�� ���� _(����)_](#)



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
 
 
## Login
 
1. ����ȯ��
 * FE : HTML5, javascript
 * BE : Spring boot, Oracle 18c, MyBatis, Redis, Lettuce
 * Major : Redis, DB Trigger, HandlerInterceptor ~~(HandlerInterceptorAdapter)~~
 
2. ����
 * �α��α��, ȸ�����Ա��, ��й�ȣ ã�� ��ɱ���
 * Login Session(FingerPrint) ������ Redis�� �����Ͽ� �����ֱ� ����
 * DB Trigger�� ���� ȸ��DB �����̷� ����
 * �������̵� �� �α׾ƿ��� HandlerInterceptor Interface�� ������ Ŭ������ ���� Session ����
 
## ORM(JPA, JOOQ)&Mapper(Mybatis) ����

1. ����ȯ��
 * FE : HTML5, javascript
 * BE : Spring boot, Oracle 18c, MyBatis, JPA, Hibernate
 * Major : ORM, JPA, Hibernate, MyBatis
 
2. ����
 * JPA�� Mybatis�� ���ÿ� ���������ν� ������ ������� ��ȣ ����
 * Restful API������� JPA ����
 ```
    GET     /userMgmt/jpa/{id}    : SELECT (��ȸ)
    POST    /userMgmt/jpa         : INSERT (����)
    PUT     /userMgmt/jpa         : UPDATE (����)
    DELETE  /userMgmt/jpa/{id}    : DELETE (����)
``` 
 * Swagger2�� Ȱ���Ͽ� API ���� �ڵ�ȭ ���� 
 * JPA��?
    * MyBatis�� Mapper������� ������ ����(Ư�� Select��) �ۼ��� ����
    * ORM
        * ��ü�� ������ DB �����͸� �ڵ����� ����(����)
        * ��ü�� ���� ���������� DB������ �ڵ鸵
        * ����
            1. ��ü������ �ڵ�� ������
            2. ���� �� ���������� ���� ����
            3. DBMS�� ���� ���Ӽ��� �پ�� (DBMS��ü�� ���� ���� ����ũ�� �ð� �ҿ�)
        * ����
            1. ����Ŀ�갡 ����.
            2. ������ SELECT���� �ۼ��ϱ⿡ ������.
            3. ���ν��� ���̽� �ý��ۿ����� ������ ���ֵǱ� ����.
    * JPA (Java Persistence API)
        * �ڹ� Application���� RDB ������� ������ __�������̽�__
        * Ư�� ������ϴ� ���̺귯���� �ƴ�.
    * Hibernate
        * JPA �������̽��� �����ϴ� ����ü
        * JPA�� Hibernate�� Interface�� �̸� ������ Class�� ���� ����
