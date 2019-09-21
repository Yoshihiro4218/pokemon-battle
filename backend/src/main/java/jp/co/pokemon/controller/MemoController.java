package jp.co.pokemon.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "memo")
public class MemoController {
//
//    private final MemoService service;
//
//    public MemoController(MemoService service) {
//        this.service = service;
//    }
//
//    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<Memo> id(@PathVariable(value = "id") Long id) {
//        Optional<Memo> memo = service.findById(id);
//        return memo.map(ResponseEntity::ok)
//                   .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @GetMapping(path = "list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<List<Memo>> list(Pageable page) {
//        Page<Memo> memos = service.findAll(page);
//        return ResponseEntity.ok(memos.getContent());
//    }

}

