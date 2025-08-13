package org.mbc.czo.function.product.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mbc.czo.function.product.domain.Item;
import org.mbc.czo.function.product.dto.ItemFormDto;
import org.mbc.czo.function.product.dto.ItemSearchDto;
import org.mbc.czo.function.product.service.ItemService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    // 상품 등록 관련
    @GetMapping(value = "/admin/item/new")
    public String itemForm(Model model) {
        model.addAttribute("itemFormDto", new ItemFormDto());
        return "product/itemForm";
    }
    @PostMapping(value = "/admin/item/new")
    public String itemNew(@Valid ItemFormDto itemFormDto, BindingResult bindingResult, Model model,
                          @RequestParam("itemImgFile") List<MultipartFile> itemImgFileList) {
        // @Valid : 필수 입력 등 유효성 검사하는 용도
        // BindingResult : 유효성 검사 후 에러 정보를 보관하는 객체
        // @RequestParam : 프론트에 요청하여 파라미터로 받는 것
        if (bindingResult.hasErrors()) { // 상품 등록 시 필수 값이 없다면 상품 등록 페이지로 다시 보냄
            return "product/itemForm";
        }
        if (itemImgFileList.get(0).isEmpty() && itemFormDto.getId() == null){ // 상품 등록 시 첫 번째 이미지가 없다면 에러 메시지와 함꼐 상품 등록 페이지로 전환됨
            model.addAttribute("errorMessage", "첫번째 상품 이미지는 필수 입력 값입니다.");
            return "product/itemForm";
        }

        try{
            itemService.saveItem(itemFormDto, itemImgFileList);
        }catch (Exception e){
            model.addAttribute("errorMessage", "상품 등록 중 에러가 발생하였습니다.");
            return "product/itemForm";
        }
        return "redirect:/"; // 상품이 정상적으로 등록되었다면 메인 페이지로 이동
    }

    // 상품 조회 관련
    @GetMapping(value = {"admin/items", "/admin/items/{page}"}) // value에 상품 관리 화면 진입 시 URL에 페이지 번호가 없는 경우와 페이지 번호가 있는 경우 2가지를 매핑
    public String itemManage(ItemSearchDto itemSearchDto, @PathVariable("page") Optional<Integer> page, Model model, Pageable pageable) {
        Pageable pageable1 = PageRequest.of(page.isPresent() ? page.get() : 0,3); // url 경로에 페이지 번호가 있으면 해당 페이지를 조회 하도록 세팅, 없으면 0페이지를 조회하도록함
        Page<Item> items =
                itemService.getAdminItemPage(itemSearchDto, pageable); // 조회 조건과 페이징 정보를 파라미터로 넘겨서 Page<item>객체를 반환 받음
        model.addAttribute("items", items); // 조회한 상품 데이터 및 페이징 정보를 뷰에 전달
        model.addAttribute("itemSearchDto", itemSearchDto); // 페이지 전환 시 기존 검색 조건을 유지한 채 이동할 수 있도록 뷰에 다시 전달
        model.addAttribute("maxPage", 5); //  상품 관리 메뉴 하단에 보여줄 페이지 번호의 최대 개수. 5로 설정했으므로 최대 5개의 이동할 페이지 번호만 보여준다.
        return "item/itemMng";
    }

}
