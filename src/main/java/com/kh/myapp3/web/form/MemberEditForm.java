package com.kh.myapp3.web.form;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberEditForm {
  private Long memberId;
  private String email;
  private String pw;
  private String nickname;
}
