package org.mbc.czo.function.boardAdmin.Search;

import org.mbc.czo.function.boardAdmin.domain.BoardAdmin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardAdminSearch {
    Page<BoardAdmin> search1(Pageable pageable);

    Page<BoardAdmin> searchAll(String[] types, String keyword, Pageable pageable);  // 검색을 위한 메서드 선언
}
