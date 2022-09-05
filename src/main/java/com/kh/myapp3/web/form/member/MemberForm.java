package com.kh.myapp3.web.form.member;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MemberForm {
  private Long memberId;
  private String email;
  private String pw;
  private String nickname;
  private LocalDateTime cdate;
  private LocalDateTime udate;
}
