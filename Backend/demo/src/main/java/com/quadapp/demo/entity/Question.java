package com.quadapp.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
    private long questionId;

    @JsonProperty ("type")
    private String questionType;

    @JsonProperty ("difficulty")
    private String questionDifficulty;
    
    @JsonProperty("category")
    private String questionCategory;
    
    @JsonProperty("question")
    private String questionText;

    @JsonProperty("correct_answer")
    private String correctAnswer;

    @JsonProperty ("incorrect_answers")
    private List<String> incorrectAnswers;

    public long getQuestionId() { return questionId;}
    public void setId(long id) { this.questionId = id; } 

    public String getQuestionType() { return questionType; }
    public void setQuestionType(String questionType) { this.questionType = questionType; }
    
    public String getQuestionDifficulty() { return questionDifficulty; }
    public void setQuestionDifficulty(String questionDifficulty) { this.questionDifficulty = questionDifficulty; }
    
    public String getQuestionCategory() { return questionCategory; }
    public void setQuestionCategory(String questionCategory) { this.questionCategory = questionCategory; }
    
    public String getQuestionText() { return questionText;}
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    
    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }
    
    public List<String> getIncorrectAnswers() { return incorrectAnswers;}
    public void setIncorrectAnswers(List<String> incorrectAnswers) { this.incorrectAnswers = incorrectAnswers; }

    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionType='" + questionType + '\'' +
                ", questionDifficulty='" + questionDifficulty + '\'' +
                ", questionCategory='" + questionCategory + '\'' +
                ", questionText='" + questionText + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", incorrectAnswers=" + incorrectAnswers +
                '}';
    }
}
