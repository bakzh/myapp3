package com.kh.myapp3.web;

import com.kh.myapp3.domain.Member;
import com.kh.myapp3.domain.svc.MemberSVC;
import com.kh.myapp3.web.form.JoinForm;
import com.kh.myapp3.web.form.MemberEditForm;
import com.kh.myapp3.web.form.MemberForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

  private final MemberSVC memberSVC;

  //가입양식
  @GetMapping("/add")
  public String insertForm(){

    return "members/joinForm";   //가입 view
  }

  //가입처리
  @PostMapping("/add")
  public String insert(JoinForm joinForm){
    log.info("joinForm:{}", joinForm);

    Member member = new Member();
    member.setEmail(joinForm.getEmail());
    member.setPw(joinForm.getPw());
    member.setNickname(joinForm.getNickname());

    Member insertedMember = memberSVC.insert(member);

    return "redirect:/members/"+insertedMember.getMemberId();  //멤버상세 요청 url
  }

  //멤버개별조회
  @GetMapping("/{id}")
  public String findByMemberId(
          @PathVariable("id") Long mid,
          Model model
  ){
    //db에서 상품조회
    Member findedProduct = memberSVC.findById(mid);

    //Member => ItemForm 복사
    MemberForm memberForm = new MemberForm();
    memberForm.setMemberId(findedProduct.getMemberId());
    memberForm.setEmail(findedProduct.getEmail());
    memberForm.setPw(findedProduct.getPw());
    memberForm.setNickname(findedProduct.getNickname());

    //view에서 참조하기위에 model객체에 저장
    model.addAttribute("memberForm",memberForm);

    return "member/memberForm"; //멤버 상세 view
  }

  //수정양식
  @GetMapping("/{id}/edit")
  public String updateForm(@PathVariable("id") Long id, Model model){

    Member findedProduct = memberSVC.findById(id);

    //Member => EditForm 변환
    MemberEditForm memberEditForm = new MemberEditForm();
    memberEditForm.setMemberId(findedProduct.getMemberId());
    memberEditForm.setEmail(findedProduct.getEmail());
    memberEditForm.setPw(findedProduct.getPw());
    memberEditForm.setNickname(findedProduct.getNickname());

    model.addAttribute("memberEditForm",memberEditForm);

    return "member/editForm";  //멤버 수정 view
  }

  //수정처리
  @PostMapping("/{id}/edit")
  public String update(@PathVariable("id") Long id, MemberEditForm memberEditForm){

    Member member = new Member();
    member.setMemberId(id);
    member.setEmail(memberEditForm.getEmail());
    member.setPw(memberEditForm.getPw());
    member.setNickname(memberEditForm.getNickname());

    memberSVC.update(id,member);
    return "redirect:/members/" + id; //멤버 상세 url
  }

  //삭제처리
  @GetMapping("/{id}/del")
  public String del(@PathVariable("id") Long id){

    memberSVC.del(id);
    return "redirect:/members"; // 전체 목록 view
  }

  //목록화면
  @GetMapping
  public String list(Model model){

    List<Member> list = memberSVC.all();
    model.addAttribute("list",list);
    return "member/all"; //전체목록 view
  }
}
