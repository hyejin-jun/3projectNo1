package org.mbc.czo.function.boardAdmin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mbc.czo.function.boardAdmin.dto.PageAdminRequestDTO;
import org.mbc.czo.function.boardAdmin.service.BoardAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardAdminController {

    private final BoardAdminService boardAdminService;

    @GetMapping("list")
    public void list(PageAdminRequestDTO pageAdminRequestDTO, Model model){

    }

}
