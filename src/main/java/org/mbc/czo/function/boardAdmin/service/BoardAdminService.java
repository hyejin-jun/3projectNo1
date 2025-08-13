package org.mbc.czo.function.boardAdmin.service;

import org.mbc.czo.function.boardAdmin.dto.BoardAdminDTO;
import org.mbc.czo.function.boardAdmin.dto.PageAdminRequestDTO;
import org.mbc.czo.function.boardAdmin.dto.PageAdminResponseDTO;

public interface BoardAdminService {

    Long register(BoardAdminDTO boardAdminDTO);  // 글 작성

    BoardAdminDTO readOne(Long bano);  // 상세 보기

    BoardAdminDTO modify(BoardAdminDTO boardAdminDTO); // 수정하기

    void remove(Long bano);

    PageAdminResponseDTO<BoardAdminDTO> list(PageAdminRequestDTO pageAdminRequestDTO);
}
