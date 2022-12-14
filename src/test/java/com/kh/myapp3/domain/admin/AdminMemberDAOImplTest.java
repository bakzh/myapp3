package com.kh.myapp3.domain.admin;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class AdminMemberDAOImplTest {

  @Autowired
  private AdminMemberDAO adminMemberDAO;

  @Test
  @DisplayName("이메일중복체크")
  void dupChkOfMemberEmail() {
    Boolean isExist = adminMemberDAO.dupChkOfMemberEmail("test1@naver.com");
    Assertions.assertThat(isExist).isTrue();

    isExist = adminMemberDAO.dupChkOfMemberEmail("test1@naver.com1");
    Assertions.assertThat(isExist).isFalse();
  }
}