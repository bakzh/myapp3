package com.kh.myapp3.web.admin.form.member;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AddForm {
  @NotBlank
  private String email;       //이메일
  private String pw;          //비밀번호
  private String nickname;    //별칭
}
