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
public class BoardAdminAllListDTO {

    private Long baNo;

    private String baTitle;

    private String baContent;

    private LocalDateTime baRegDate;

    private Long baReplyCount;

    private List<BoardAdminImageDTO> baBoardImages;

}
