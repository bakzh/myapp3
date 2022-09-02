package com.kh.myapp3.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {

 private Long memberId;           //  MEMBER_ID	NUMBER(8,0)	No		1
 private String email;            //  EMAIL	VARCHAR2(40 BYTE)	No		2
 private String pw;               //  PW	VARCHAR2(10 BYTE)	No		3
 private String nickname;         //  NINKNAME	VARCHAR2(30 BYTE)	Yes		4

 public Member(String email, String pw, String nickname) {
  this.email = email;
  this.pw = pw;
  this.nickname = nickname;
 }
}
