package com.Jpa.Testing;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@org.springframework.stereotype.Service
public class Service {
    private final MemberRepositoy memberRepositoy;
    private final QuestionRepositoy questionRepositoy;

    public Service(MemberRepositoy memberRepositoy,
                   QuestionRepositoy questionRepositoy) {
        this.memberRepositoy = memberRepositoy;
        this.questionRepositoy = questionRepositoy;
    }

    public Member createMember(){
        Member member = new Member();
        return memberRepositoy.save(member);
    }

    public Question createQuestion(long memberId){
        Member member = findMember(memberId);
        Question question = new Question(member);
        return questionRepositoy.save(question);
    }

    public void deleteMember(long memberId){
        Member member = findMember(memberId);
        memberRepositoy.delete(member);
    }

    public void deleteQuestion(long questionId){
        Optional<Question> optionalQuestion = questionRepositoy.findById(questionId);
        Question question = optionalQuestion.orElseThrow(()->new RuntimeException("question no"));
        questionRepositoy.delete(question);
    }

    public Member findMember(long memberId){
        Optional<Member> optionalMember = memberRepositoy.findById(memberId);
        Member member = optionalMember.orElseThrow(() -> new RuntimeException("member no"));
        return member;
    }

}
