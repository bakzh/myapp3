package com.kh.myapp3.web;

import com.kh.myapp3.domain.Product;
import com.kh.myapp3.domain.svc.ProductSVC;
import com.kh.myapp3.web.form.SaveForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

  private final ProductSVC productSVC;

  //등록양식
  @GetMapping("/add")
  public String addForm(){

    return "product/addForm"; //상품등록 view
  }

  //등록처리
  @PostMapping("/add")
  public String add(SaveForm saveForm){
    log.info("saveForm:{}",saveForm);

    Product product = new Product();
    product.setPname(saveForm.getPname());
    product.setQuantity(saveForm.getQuantity());
    product.setPrice(saveForm.getPrice());

    Product savedProduct = productSVC.save(product);

    return "redirect:/products/"+savedProduct.getProductId(); //상품상세 view
  }

  //상품개별조회
  @GetMapping("/{pid}")
  public String findById(
          @PathVariable("pid") String pid,
          Model model
  ){
    //db에서 상품조회


    Product product = new Product();
    model.addAttribute("product",product);

    return "product/itemForm"; //상품 상세 view
  }

  //수정양식
  @GetMapping("/{pid}/edit")
  public String editForm(){

    return "product/editForm"; //상품 수정 view
  }

  //수정처리
  @PostMapping("/{pid}/edit")
  public String edit(){

    return "redirect:/products/1"; //상품 상세 view
  }

  //삭제처리
  @GetMapping("/{pid}/del")
  public String del(){

    return "redirect:/products"; //전체 목록 view
  }

  //목록화면
  @GetMapping
  public String all(){

    return "product/all"; //전체목록 view
  }
}
