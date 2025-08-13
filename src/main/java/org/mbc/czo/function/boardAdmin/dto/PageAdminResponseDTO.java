package org.mbc.czo.function.boardAdmin.dto;

import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageAdminResponseDTO<E> {

    private int baPage;   // 현재 페이지,
    private int baSize;   // 페이지당 게시물 수
    private int baTotal;  //  총 게시물

    private int start;  // 시작 페이지
    private int end;  // 끝 페이지

    private boolean prev;  // 이전 페이지 존재 여부
    private boolean next;  // 다음 페이지 존재 여부

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageAdminResponseDTO(PageAdminRequestDTO pageAdminRequestDTO, List<E> dtoList, int total){

        if (total <= 0){
            return;
        }
        this.baPage = pageAdminRequestDTO.getBaPage();
        this.baSize = pageAdminRequestDTO.getBaSize();

        this.baTotal = total;
        this.dtoList = dtoList;

        this.end = (int)(Math.ceil(this.baPage / 10.0)) * 10;  // 화면에서 마지막 번호
        this.start = this.end - 9 ; // 화면에서의 시작 번호

        int last = (int)(Math.ceil((total/(double)baSize))); // 데이터 계수를 계산한 마지막 페이지
        this.end = end > last ? last:end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.baSize;

    }

}
