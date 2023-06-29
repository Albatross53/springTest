package com.Jpa.Testing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long questionId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Question(Member member) {
        this.member = member;
    }
}
