package org.mbc.czo.Service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.mbc.czo.function.boardAdmin.domain.BoardAdmin;
import org.mbc.czo.function.boardAdmin.dto.BoardAdminDTO;
import org.mbc.czo.function.boardAdmin.dto.PageAdminRequestDTO;
import org.mbc.czo.function.boardAdmin.dto.PageAdminResponseDTO;
import org.mbc.czo.function.boardAdmin.repository.BoardAdminRepository;
import org.mbc.czo.function.boardAdmin.service.BoardAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class BoardAdminServiceTests {

    @Autowired
    private BoardAdminService boardAdminService;

    @Test
    public void testRegister(){
        log.info(boardAdminService.getClass().getName());

        BoardAdminDTO boardAdminDTO = BoardAdminDTO.builder()
                .baTitle("샘플 제목")
                .baContent("샘플 내용")
                .baWriter("샘플 작성자")
                .build();

        Long bano = boardAdminService.register(boardAdminDTO);
        log.info("번호: " + bano);
    }

    @Test
    public void testModify(){

        BoardAdminDTO boardAdminDTO = BoardAdminDTO.builder()
                .baNo(10L)
                .baTitle("제목이 바뀝니다아아ㅏ")
                .baContent("내용이 바뀝니다아아")
                .build();
        boardAdminService.modify(boardAdminDTO);
    }

    @Test
    public void testDelete(){
        Long bano = 100L;
        boardAdminService.remove(bano);
    }

    @Test
    public void testList() {
        PageAdminRequestDTO pageAdminRequestDTO = PageAdminRequestDTO.builder()
                .baTyte("tcw")
                .baKeyword("1")
                .baPage(1)
                .baSize(10)
                .build();

        PageAdminResponseDTO<BoardAdminDTO> responseDTO = boardAdminService.list(pageAdminRequestDTO);
        log.info(responseDTO);
    }

}
