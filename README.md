# ☕ Coffee Manager

> 커피 주문과 관리를 위한 웹 플랫폼

---

## 🚀 프로젝트 소개

Coffee Manager는 커피 상품을 관리하고,  
회원 및 비회원이 손쉽게 커피를 주문할 수 있는 통합 플랫폼입니다.  

---

## ⚙️ 프로젝트 관리 & 빌드 도구

![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

- Maven 기반 프로젝트
- 의존성 관리 및 빌드 자동화
- `pom.xml`을 통해 라이브러리 관리
--

## 🛠️ 기술 스택



### Backend

![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=java&logoColor=white)
![Spring MVC](https://img.shields.io/badge/Spring_MVC-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=spring-security&logoColor=white)
![MyBatis](https://img.shields.io/badge/MyBatis-000000?style=for-the-badge&logo=mybatis&logoColor=white)
![JSP/JSTL](https://img.shields.io/badge/JSP/JSTL-007396?style=for-the-badge&logo=apachetomcat&logoColor=white)

### Database

![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![HikariCP](https://img.shields.io/badge/HikariCP-00BFFF?style=for-the-badge&logo=hikaricp&logoColor=white)


### Frontend
![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)
![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)


---

## 👥 팀원 소개

<table align="center">
  <tbody>
    <tr>
      <td align="center" style="padding: 10px;">
        <a href="https://github.com/qkqehenr7" target="_blank">
          <img src="https://avatars.githubusercontent.com/qkqehenr7" width="100px;" style="border-radius: 50%; border: 2px solid #ddd;" alt="최동준"/>
        </a><br />
        <b>최동준</b><br />
        <sub>@qkqehenr7</sub>
      </td>
      <td align="center" style="padding: 10px;">
        <a href="https://github.com/Parkbyungseok" target="_blank">
          <img src="https://avatars.githubusercontent.com/Parkbyungseok" width="100px;" style="border-radius: 50%; border: 2px solid #ddd;" alt="박병석"/>
        </a><br />
        <b>박병석</b><br />
        <sub>@Parkbyungseok</sub>
      </td>
      <td align="center" style="padding: 10px;">
        <a href="https://github.com/HYUNUYH" target="_blank">
          <img src="https://avatars.githubusercontent.com/HYUNUYH" width="100px;" style="border-radius: 50%; border: 2px solid #ddd;" alt="윤동현"/>
        </a><br />
        <b>윤동현</b><br />
        <sub>@HYUNUYH</sub>
      </td>
      <td align="center" style="padding: 10px;">
        <a href="https://github.com/hyeunS-P" target="_blank">
          <img src="https://avatars.githubusercontent.com/hyeunS-P" width="100px;" style="border-radius: 50%; border: 2px solid #ddd;" alt="박현서"/>
        </a><br />
        <b>박현서</b><br />
        <sub>@hyeunS-P</sub>
      </td>
    </tr>
    <tr>
      <td align="center" style="padding: 5px;"><b>Leader</b></td>
      <td align="center" style="padding: 5px;"><b>Member</b></td>
      <td align="center" style="padding: 5px;"><b>Member</b></td>
      <td align="center" style="padding: 5px;"><b>Member</b></td>
    </tr>
  </tbody>
</table>

---

## 📌 주요 기능

- **회원 주문 / 비회원 주문 기능**
- **커피 상품 등록/수정/삭제 관리**
- **장바구니 기능 및 결제 기능 구현**
- **Spring Security 기반 로그인/회원가입/권한관리**

---

## 📂 프로젝트 구조

- `controller` : HTTP 요청 처리 (Spring MVC Controller)
- `service` : 핵심 비즈니스 로직 처리
- `repository` : DB 접근 계층 (MyBatis 활용)
- `model` : 데이터 전송 객체 (DTO) 및 Entity
- `infra/config` : 스프링 설정 파일 (보안, CORS 등)
- `infra/response` : API 표준 응답 포맷 관리
- `infra/error.exceptions` : 커스텀 예외 처리
- `resources/init` : 초기 데이터베이스 스크립트
- `mybatis.mappers` : MyBatis SQL 매퍼
- `webapp` : JSP 파일을 통한 View 렌더링
- `application.properties` : 프로젝트 전역 설정

