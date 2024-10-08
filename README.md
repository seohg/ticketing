## 콘서트 예약 서비스
  1. [Milestone](#milestone)
2. [시퀀스 다이어그램](#시퀀스다이어그램)
3. [ERD](#ERD)
4. [API 명세](#API명세)
5. [SwaggerUi](#SwaggerUi)
---

### 1. [Milestone]
#### [https://github.com/users/seohg/projects/4](https://github.com/users/seohg/projects/4/views/4)
---


### 2. 시퀀스 다이어그램
#### 유저 대기열 토큰발급
<img width="422" alt="스크린샷 2024-07-03 오후 11 09 34" src="https://github.com/seohg/ticketing/assets/63279356/6f2c5f2b-5e41-4a53-b72f-161a72134fa1">

#### 예약가능 날짜 / 좌석 조회
<img width="463" alt="스크린샷 2024-07-03 오후 11 18 28" src="https://github.com/seohg/ticketing/assets/63279356/89f7f794-9cff-4da3-9854-cfc11df2ef49">

<img width="467" alt="스크린샷 2024-07-03 오후 11 18 14" src="https://github.com/seohg/ticketing/assets/63279356/e9d3c661-a1c5-4711-8625-e381a2d25378">

#### 좌석 예약 요청
<img width="415" alt="스크린샷 2024-07-03 오후 11 20 16" src="https://github.com/seohg/ticketing/assets/63279356/f4170893-88a9-442a-b4ae-82aef6599286">

#### 잔액 충전 및 조회
<img width="314" alt="스크린샷 2024-07-03 오후 11 21 30" src="https://github.com/seohg/ticketing/assets/63279356/9aec718f-c453-47cb-89fe-a8cdd02ff7dc">
<img width="318" alt="스크린샷 2024-07-03 오후 11 21 49" src="https://github.com/seohg/ticketing/assets/63279356/81c2d112-13c2-4af2-b3a8-7c3568ac53eb">

#### 결제
<img width="288" alt="스크린샷 2024-07-03 오후 11 30 13" src="https://github.com/seohg/ticketing/assets/63279356/3f3e3adb-7473-4ec6-a547-03681dea381e">

---


### 3. ERD
#### <img width="481" alt="스크린샷 2024-07-04 오후 8 04 05" src="https://github.com/seohg/ticketing/assets/63279356/37db72d5-2c22-421b-970c-f19b97a253ab">


---


### 4. API 명세
#### mock : [https://documenter.getpostman.com/view/35342121/2sA3dyhB3W#1356d3bd-ab92-45d1-bc34-9a6765fcbe3e](https://documenter.getpostman.com/view/35342121/2sA3dyhB3W)


### 유저 토큰 발급 API - [POST] /users/{userid}/token
#### 서비스를 이용할 토큰을 발급

#### Response

``` 
{
  "token" : "skgjlksjglksjlkjlajhijsrhjue"}
}
```

### 예약 가능 날짜 API - [GET] /concerts/{concertid}/shows
#### 예약가능한 날짜 조회

#### Header 
``` 
Authorization: Bearer <token>
``` 
#### Response

``` 
{
  "showID" : "1",
  "date" : "2024-01-01"
}
``` 

### 예약 가능 좌석 API - [GET] /shows/{showid}/seats
#### 예약가능한 좌석 조회

#### Header 
``` 
Authorization: Bearer <token>
``` 
#### Response

``` 
{
  "showID" : "1",
  "seatNumber" : "10"
}
``` 

### 좌석 예약 요청 API - [POST] /shows/{showid}/seats/{seatid}
#### 날짜와 좌석 정보를 입력받아 좌석을 예약 처리

#### Header 
``` 
Authorization: Bearer <token>
``` 
#### Response
```
성공
{
	"code" : "200"
	"message": "success"
}

실패
{
	"code" : "401"
	"message": "인증 실패"
}

```
### 잔액조회 API - [GET] /users/{userid}/balance
#### 사용자 식별자를 통해 해당 사용자의 잔액을 조회

#### Response
```
{
	"amount" : "300,000"
}
``` 

### 잔액충전 API - [POST] /users/{userid}/balance
#### 사용자 식별자 및 충전할 금액을 받아 잔액을 충전

#### Request
```
{
	"amount" : "300,000"
}
```

### 잔액충전 API - [POST] /users/{userid}/payments
#### 사용자 식별자 및 충전할 금액을 받아 잔액을 충전

#### Header 
``` 
Authorization: Bearer <token>
``` 
#### Request
```
{
	"showid" : "10",
	"seatid" : "20"
}
```
#### Response
```
성공
{
	"code" : "200"
	"message": "success"
}

실패
{
	"code" : "401"
	"message": "인증 실패"
}

```

---

### 5. Swagger UI
#### ![스크린샷 2024-07-11 오후 11 53 22](https://github.com/seohg/ticketing/assets/63279356/cc768ddb-fec3-4ed7-90d7-6e496beb4e9f)



---
