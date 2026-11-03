package com.quadapp.demo.entity;

import java.util.List;

public class QuestionSubmission {

    private String quizId;
    private List<QuestionAnswer> userAnswers;

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public List<QuestionAnswer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<QuestionAnswer> userAnswers) {
        this.userAnswers = userAnswers;
    }
}
