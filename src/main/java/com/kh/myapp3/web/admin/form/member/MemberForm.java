package com.kh.myapp3.web.admin.form.member;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
  @DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
  private LocalDateTime cdate;
  @DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
  private LocalDateTime udate;
}
