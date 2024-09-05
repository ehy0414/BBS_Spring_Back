package react.spring.react_spring_pjt.bbs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import react.spring.react_spring_pjt.bbs.dao.BbsMapper;
import react.spring.react_spring_pjt.bbs.domain.BbsRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.BbsResponseDTO;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentResponseDTO;

@Service
public class BbsService {

    @Autowired
    private BbsMapper bbsMapper;

    public List<BbsResponseDTO> findAll() {
        System.out.println("debug >>> service findAll " + bbsMapper);
        return bbsMapper.findAllRow();
    }

    public void save(BbsRequestDTO params) {
        bbsMapper.saveRow(params);
    }

    public BbsResponseDTO find(Map<String, Integer> map) {
        BbsResponseDTO result = bbsMapper.findRow(map);
        List<CommentResponseDTO> list = bbsMapper.findByIdComment(map);
        result.setComments(list);
        return result;
    }

    public void commentSave(CommentRequestDTO params) {
        System.out.println("client endpoint : /bbs/comments/save");
        bbsMapper.commentSaveRow(params);
    }

    public List<CommentResponseDTO> findComment(Map<String, Integer> map) {
        List<CommentResponseDTO> result = bbsMapper.findByIdComment(map);
        return result;
    }

    public void deleteBbs(Map<String, Integer> map) {
        bbsMapper.deleteRow(map);
    }

    public void updateBbs(BbsRequestDTO params) {
        bbsMapper.updateRow(params);
    }
}
