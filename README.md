
# Hyeyum Project
------------
## 팀원 
김솔잎(조장), 이지애, 한정만, 한정서, 백승범

------------
## 수행기간
2020년 3월 22일 ~ 4월 20일 (약 한달)

------------


## Contetns

1. [개요](#개요)
2. [설계의 주안점](#설계의-주안점)
3. [사용기술 및 개발환경](#사용기술-및-개발환경)
4. [프로젝트 기능 구현](#프로젝트-기능-구현)
5. [주요기능](#주요기능)
6. [Document](#Document)

------------

## 개요
+ 코로나 사태로 타격을 받은 문화 산업 분야와 개인의 문화 생활의 상생을 위한 새로운 형태의 기부 플랫폼
------------

## 설계의 주안점
- 기존의 직접 기부형태와는 달리 개인의 문화 활동 후 리뷰를 작성하면 기부금액으로 집계되도록 하여 개인의 문화활동과 동시에 문화산업에도 선한 영향력을 미칠 수 있도록 하는 데에 주안점을 두었다.

------------
## 사용기술 및 개발환경
![혜윰 개발도구](https://user-images.githubusercontent.com/46438918/118755575-13b97280-b8a4-11eb-8798-bb574685001f.png)

Category | Detail
---- | ----
Laguage & Library | HTML5, JS, CSS, Java, JSP, jQuery, Ajax
API | KakaoMap, kakaoPay, googleMap, googleCharts, EmailJS
IDE | Eclpise
Server | Tomcat(v8.5)
Document | draw.io, AdobeXd, ERDCloud, StarUML
CI | Github
DataBase | Oracle 11g

------------
## 프로젝트 기능 구현


- 공통
    - 프로젝트 주제 선정 및 기획 
    - 플로우차트, 유스케이스 다이어그램 설계
    - DB & 클래스, 시퀸스 다이어그램 설계
    - 메인 페이지, 마이페이지, 회원가입, 관리자 페이지
    - 프로젝트 문서 작업
<br><br>

- 김솔잎
  - 조장
    - 프로젝트 문서 총괄
    <br>  
  - 영화 페이지
   - <감상혜윰>
     - 영화 정보 조회 및 영화 후기 게시판(CRUD), 
     - 관리자 영화 컨텐츠 관리 (CRUD)
   - <추천혜윰>
     - 영화 추천 게시판(CRUD), 검색 기능, 페이징 처리, 좋아요 가감 및 조회수 증가
     <br>
  - 마이 페이지
     - 마이 페이지 메인(CSS) 구현
     - 로그인 및 회원 가입 (다음 주소 API , 유효성 검사 적용) , 회원 정보 수정

<br><br>

- 한정만
  - 도서 페이지
   - <감상혜윰>
     - 도서 정보 조회 및 도서 후기 게시판(CRUD) , 페이징 처리, 댓글 등록 / 삭제, 좋아요 가감 및 조회수 증가 
     - 관리자 도서 컨텐츠 관리 (CRUD)
   - <나눔혜윰>
     - 중고 도서 게시판(CRUD) , 페이징 처리, 파일 등록, 댓글 등록 / 삭제, 좋아요 가감 및 조회수 증가
     <br>
  - 마이 페이지
    - 작성 게시글 / 댓글 모아보기 

 <br><br>
   
- 백승범 
  - 공연 페이지
   - <언제혜윰>
     - 공연 정보 조회 (카카오맵 API 적용), 페이징 처리
     - 관리자 공연 컨텐츠 관리 (CRUD)
   - <관람혜윰>
     - 공연 후기 게시판(CRUD), 페이징 처리, 검색 기능, 파일 등록, 댓글 등록 / 수정 / 삭제, 좋아요 가감 및 조회수 증가
     <br>
  - 마당 페이지
   - <참여혜윰>
     - 결제 기능(카카오페이 API 적용)
     <br>
  - 마이 페이지
    - 사용자 비밀번호 변경 기능
    <br>
  - 관리자 페이지
    - 관리 총괄 (관리자 로그인, 대시보드 관리)
    - 회원 관리(조회)
    - 주문 관리(상태 변경)

<br><br>  
   
- 한정서
  - 마당 페이지
   - <참여혜윰>
     - 굿즈 판매 게시판 CRUD
   - <문의혜윰>
     - 사용자 문의 게시판 CRUD (유효성 검사 적용), 검색 기능, 관리자 답글 게시판 CRUD, 페이징 처리
     <br>
  - 마당 페이지
   - <참여혜윰>
     - 결제 기능(카카오페이 API 적용)
     <br>
  - 마이 페이지
    - 사용자 간 쪽지 수신/발신, 쪽지 내역, 전송 취소 및 읽음 여부 확인 기능
    - 게시글 / 댓글 산정에 따른 기부내역 관리
    - 아이디 / 비밀번호 찾기
  
<br><br>

- 이지애  
  - 소개 페이지
   - <혜윰이란?>
     - 페이지 소개 관리 (구글맵 API 적용, CSS)
   - <혜윰 벗>
     - 제휴 문의 (유효성 검사 적용)
   - <혜윰소식>
     - 공지사항 조회  
     <br>
  - 관리자 페이지
    - 제휴 기업 게시판(CRUD), 제휴 문의 신청 기업의 승인 여부 관리
    - 공지사항 등록 / 수정 / 삭제 
    <br>
  
------------
## 주요 기능
1. 회원가입
![슬라이드21](https://user-images.githubusercontent.com/46438918/118755227-74947b00-b8a3-11eb-9f41-8a537a1a2d9c.PNG)

1-1. 비밀번호 찾기
![슬라이드28](https://user-images.githubusercontent.com/46438918/118755251-8118d380-b8a3-11eb-8c9a-4dab2873b3da.PNG)
![슬라이드29](https://user-images.githubusercontent.com/46438918/118755259-8413c400-b8a3-11eb-816a-4f5252de0d3a.PNG)


2. 소개
![슬라이드33](https://user-images.githubusercontent.com/46438918/118755288-8d049580-b8a3-11eb-998d-13df359a6448.PNG)
![슬라이드34](https://user-images.githubusercontent.com/46438918/118755296-8f66ef80-b8a3-11eb-8bc6-e0923b240024.PNG)
![슬라이드39](https://user-images.githubusercontent.com/46438918/118755308-9988ee00-b8a3-11eb-9f94-1ee366b7bc97.PNG)


3. 도서
![Uploading 슬라이드39.PNG…]()
![슬라이드42](https://user-images.githubusercontent.com/46438918/118755311-9b52b180-b8a3-11eb-9e64-27197ed71dd8.PNG)
![슬라이드43](https://user-images.githubusercontent.com/46438918/118755314-9d1c7500-b8a3-11eb-8b8a-f1458c2869ad.PNG)
![슬라이드45](https://user-images.githubusercontent.com/46438918/118755319-9e4da200-b8a3-11eb-9126-3f7320fe4350.PNG)


4. 영화
![슬라이드52](https://user-images.githubusercontent.com/46438918/118755343-ab6a9100-b8a3-11eb-8bd7-d881f5381c0d.PNG)
![슬라이드54](https://user-images.githubusercontent.com/46438918/118755347-ac9bbe00-b8a3-11eb-9110-f7b3906232a0.PNG)
![슬라이드55](https://user-images.githubusercontent.com/46438918/118755353-adcceb00-b8a3-11eb-9b1c-ae8f5ee0dd52.PNG)
![슬라이드56](https://user-images.githubusercontent.com/46438918/118755354-aefe1800-b8a3-11eb-8994-54ed35dbea70.PNG)



5. 공연
![슬라이드59](https://user-images.githubusercontent.com/46438918/118755370-b3c2cc00-b8a3-11eb-816c-7156607da4cd.PNG)
![슬라이드60](https://user-images.githubusercontent.com/46438918/118755375-b58c8f80-b8a3-11eb-9168-dbb3da25e6c0.PNG)
![슬라이드61](https://user-images.githubusercontent.com/46438918/118755378-b6bdbc80-b8a3-11eb-83e1-0f7799412306.PNG)
![슬라이드62](https://user-images.githubusercontent.com/46438918/118755380-b7565300-b8a3-11eb-94a9-0932cbe41d0e.PNG)


6. QNA
![슬라이드68](https://user-images.githubusercontent.com/46438918/118755396-bcb39d80-b8a3-11eb-9b83-76073db0ed36.PNG)
![슬라이드69](https://user-images.githubusercontent.com/46438918/118755404-bde4ca80-b8a3-11eb-8355-f54748c4c7e7.PNG)


7. 마이페이지
![슬라이드71](https://user-images.githubusercontent.com/46438918/118755422-c50bd880-b8a3-11eb-9128-1784ed66c648.PNG)
![슬라이드73](https://user-images.githubusercontent.com/46438918/118755425-c6d59c00-b8a3-11eb-92d6-8e1665613f73.PNG)
![슬라이드74](https://user-images.githubusercontent.com/46438918/118755426-c6d59c00-b8a3-11eb-8f79-88e55ea3960a.PNG)
![슬라이드75](https://user-images.githubusercontent.com/46438918/118755429-c76e3280-b8a3-11eb-9139-abb203156e76.PNG)
![슬라이드76](https://user-images.githubusercontent.com/46438918/118755431-c806c900-b8a3-11eb-8b54-09dd2c893faf.PNG)
![슬라이드78](https://user-images.githubusercontent.com/46438918/118755432-c89f5f80-b8a3-11eb-9363-f33b33d304c4.PNG)
![슬라이드80](https://user-images.githubusercontent.com/46438918/118755434-c89f5f80-b8a3-11eb-9bae-24f40c28dddc.PNG)


8. 관리자
![슬라이드82](https://user-images.githubusercontent.com/46438918/118755442-d05f0400-b8a3-11eb-9b68-b32533a4eaf7.PNG)
![슬라이드86](https://user-images.githubusercontent.com/46438918/118755443-d228c780-b8a3-11eb-97c6-a5cc108c0ad1.PNG)
![슬라이드87](https://user-images.githubusercontent.com/46438918/118755444-d228c780-b8a3-11eb-99f8-393ea5428189.PNG)
![슬라이드89](https://user-images.githubusercontent.com/46438918/118755445-d2c15e00-b8a3-11eb-9413-85719d97c5db.PNG)
![슬라이드90](https://user-images.githubusercontent.com/46438918/118755447-d2c15e00-b8a3-11eb-8de5-f41d5d614c32.PNG)
![슬라이드91](https://user-images.githubusercontent.com/46438918/118755449-d359f480-b8a3-11eb-9ac4-b08bec13f8c0.PNG)
![슬라이드92](https://user-images.githubusercontent.com/46438918/118755450-d359f480-b8a3-11eb-90a5-676bca337670.PNG)
![슬라이드100](https://user-images.githubusercontent.com/46438918/118755452-d3f28b00-b8a3-11eb-9844-211a4ef12c21.PNG)
![슬라이드105](https://user-images.githubusercontent.com/46438918/118755453-d48b2180-b8a3-11eb-96a1-0f0d939b08f6.PNG)



------------
## Document
### 1. 유스케이스
![유스케이스_우리또자바조](https://user-images.githubusercontent.com/46438918/118754165-70675e00-b8a1-11eb-8530-c32797933ee5.jpg)

### 2. ERD
![문화나눔 혜윰_ERD](https://user-images.githubusercontent.com/46438918/118754139-6180ab80-b8a1-11eb-8689-e564bb0a313f.png)
