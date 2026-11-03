package com.quadapp.demo.services;

import com.quadapp.demo.entity.Question;
import com.quadapp.demo.entity.QuestionAnswer;
import com.quadapp.demo.entity.QuestionDTO;
import com.quadapp.demo.entity.QuestionSubmission;
import com.quadapp.demo.entity.QuizResponse;
import com.quadapp.demo.repository.QuestionRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final Map<String, List<Question>> quizCache = new ConcurrentHashMap<>();

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    // public List<Question> getQuestions() {
    //     return questionRepository.GetQuestions();
    // }

    public QuizResponse createQuiz() {
        List<Question> questions = questionRepository.GetQuestions();
        String quizId = UUID.randomUUID().toString();
        quizCache.put(quizId, questions);

        List<QuestionDTO> questionDTOs = new java.util.ArrayList<>();
        
        for (Question question : questions) {

            List<String> answerOptions = new java.util.ArrayList<>();
            answerOptions.add(question.getCorrectAnswer());
            answerOptions.addAll(question.getIncorrectAnswers());

            java.util.Collections.shuffle(answerOptions);

            QuestionDTO questionDTO = new QuestionDTO(question.getQuestionId(), question.getQuestionText(), answerOptions);

            questionDTOs.add(questionDTO);
        }  
        return new QuizResponse(quizId, questionDTOs);
    }
   
    public int checkAnswers(QuestionSubmission submission) {
    
    List<Question> questions = quizCache.get(submission.getQuizId());
    int score = 0;

    if(questions == null) {
        throw new IllegalArgumentException("Invalid quiz ID");
    }
        for (QuestionAnswer answer : submission.getUserAnswers()) {
            for (Question question : questions) {
                if (answer.getQuestionId() == question.getQuestionId()
                        && answer.getUserAnswer() != null
                        && answer.getUserAnswer().equalsIgnoreCase(
                                question.getCorrectAnswer())) {
                    score++;
                    break;
                }
            }
        }
        return score;
    }
}