package com.Jpa.Testing;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/test")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping
    public String getTesting(){
        return "test is ok!";
    }

    @PostMapping("/memebr")
    public ResponseEntity postMember() {
        Member member = service.createMember();
        return new ResponseEntity<>(member, HttpStatus.OK);
    }

    @PostMapping("/question/{member_id}")
    public ResponseEntity postQuestion(@PathVariable("member_id") long memberId) {
        Question question = service.createQuestion(memberId);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @GetMapping("/Member/{member_id}")
    public String getMember(@PathVariable("member_id") long memberId){
        Member member = service.findMember(memberId);
        StringBuilder memberQuestionListBuilder = new StringBuilder();
        for (Question question : member.getQuestionList()) {
            memberQuestionListBuilder.append(question.getQuestionId()).append(" ");
        }
        String memberQuestionList = memberQuestionListBuilder.toString();
        return memberQuestionList;
    }

    @DeleteMapping("/member/delete/{question_id}")
    public ResponseEntity deleteQuestion(@PathVariable("question_id") long questionId) {
        service.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
