package org.mbc.czo.function.boardAdmin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageAdminRequestDTO {

    @Builder.Default
    private int baPage = 1;  // 첫 페이지

    @Builder.Default
    private int baSize = 10; // 게시물 수


    private String baTyte;  // 다중 검색 (검색 종류)
    public String[] getTypes(){
        if(baTyte == null || baTyte.isEmpty()){
            return null;
        }
        return baTyte.split("");
    }
    public Pageable getPageable(String...props){
        return PageRequest.of(this.baPage -1, this.baSize, Sort.by(props).descending());
    }

    private String baKeyword;  // 폼박스 내용

    private String baLink;  // 페이징 번호 차리시 문자열
    public String getLink(){
        if(baLink == null){
            StringBuilder builder = new StringBuilder();
            builder.append("페이지 = " + this.baPage);
            builder.append(" & 사이즈 = " + this.baSize);

            if(baTyte != null && baTyte.length() > 0){
                builder.append(" & 타입 = " + baTyte);
            }
            if(baKeyword != null){
                try{
                    builder.append(" & 키워드 = " + URLEncoder.encode(baKeyword, "UTF-8"));
                } catch (UnsupportedEncodingException e){
                }
            }
            baLink = builder.toString();
        }
    return baLink;
    }




}
