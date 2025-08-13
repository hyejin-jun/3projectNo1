package org.mbc.czo.function.boardAdmin.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardAdminImageDTO {

    private String baid;

    private String baFileName;

    private int baOrd; // 이미지 순서
}
