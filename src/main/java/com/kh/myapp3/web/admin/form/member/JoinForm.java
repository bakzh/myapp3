package com.kh.myapp3.web.admin.form.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class JoinForm {
  private String email;
  private String pw;
  private String nickname;
}
