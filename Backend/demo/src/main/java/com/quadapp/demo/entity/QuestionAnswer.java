package com.quadapp.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionAnswer {
    @JsonProperty("questionId")
    private long questionId;

    @JsonProperty ("userAnswer")
    private String userAnswer;

    public long getQuestionId() { return questionId; }
    public void setQuestionId(long questionId) { this.questionId = questionId; }

    public String getUserAnswer() { return userAnswer; }
    public void setUserAnswer(String userAnswer) { this.userAnswer = userAnswer; }
}
