package react.spring.react_spring_pjt.bbs.domain;

import java.util.List;

import lombok.Data;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentResponseDTO;


@Data
public class BbsResponseDTO {
    
    private Integer id;
    private String title;
    private String content;

    private List<CommentResponseDTO> comments;
}
