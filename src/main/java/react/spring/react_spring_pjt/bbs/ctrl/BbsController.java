package react.spring.react_spring_pjt.bbs.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import react.spring.react_spring_pjt.bbs.domain.BbsRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.BbsResponseDTO;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentRequestDTO;
import react.spring.react_spring_pjt.bbs.domain.comment.CommentResponseDTO;
import react.spring.react_spring_pjt.bbs.service.BbsService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/bbs")
public class BbsController {

    @Autowired
    private BbsService bbsService;

    @GetMapping("/index")
    public ResponseEntity<Object> landing() {
        System.out.println("client endpoint /bbs/index"+bbsService);

        List<BbsResponseDTO> list = bbsService.findAll();
        System.out.println("result size = "+list.size());

        if( list.size() == 0) {
            Map<String, String> map = new HashMap<>();
            map.put("info", "저장된 데이터가 존재하지 않습니다.");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
 
    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody BbsRequestDTO params) {

        bbsService.save(params);
        System.out.println("client save endpoint : "+params);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    }
    
    @GetMapping("/view/{id}")
    public ResponseEntity<BbsResponseDTO> view(@PathVariable(name = "id") Integer id) {
        System.out.println("debug >>> bbs controller client path /view");
        System.out.println("debug >>> id param value " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);
        BbsResponseDTO result = bbsService.find(map);

        return new ResponseEntity<>( result , HttpStatus.OK);
    }
    
    @PostMapping("/comments/save")
    public ResponseEntity<Void> commentSave(@RequestBody CommentRequestDTO params) {
        System.out.println("debug >>> save comment " + params);
        bbsService.commentSave(params);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/comments/getComment/{id}")
    public ResponseEntity<List<CommentResponseDTO>> getComment(@PathVariable(name ="id") Integer id) {
        System.out.println("debug >>> id param value " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        List<CommentResponseDTO> result = bbsService.findComment(map);
        return new ResponseEntity<List<CommentResponseDTO>>( result , HttpStatus.OK);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBbs(@PathVariable(name ="id") Integer id) {
        System.out.println("debug >>> id param value " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        bbsService.deleteBbs(map);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateBbs(@RequestBody BbsRequestDTO params) {
        System.out.println("debug >>> param value " + params);
        
        bbsService.updateBbs(params);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
