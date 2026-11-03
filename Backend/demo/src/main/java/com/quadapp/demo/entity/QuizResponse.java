package com.quadapp.demo.entity;

import java.util.List;

public class QuizResponse {

    private String quizId;
    private List<QuestionDTO> questions;

    public QuizResponse(String quizId, List<QuestionDTO> questions) {
        this.quizId = quizId;
        this.questions = questions;
    }

    public String getQuizId() {
        return quizId;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }
}