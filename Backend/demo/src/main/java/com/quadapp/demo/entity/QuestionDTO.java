package com.quadapp.demo.entity;

import java.util.List;

public class QuestionDTO {
    private long questionId;
    private String question;
    private List<String> options;

    public QuestionDTO(long questionId, String question, List<String> options) {
        this.questionId = questionId;
        this.question = question;
        this.options = options;
    }

    public long getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }
}
