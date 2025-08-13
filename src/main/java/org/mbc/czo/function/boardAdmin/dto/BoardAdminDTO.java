package org.mbc.czo.function.boardAdmin.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardAdminDTO {

    private Long baNo;

    private String baTitle;

    private String baContent;

    private String baWriter;

    private LocalDateTime baRegDate;

    private LocalDateTime baModDate;

    private List<String> fileNemes;

}
