package com.quadapp.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.quadapp.demo.entity.Question;
import com.quadapp.demo.entity.QuestionResponse;

@Repository 
public class QuestionRepository {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String apiUrl = "https://opentdb.com/api.php?amount=10&category=9&difficulty=easy&type=multiple";

    public List<Question> GetQuestions() {
        QuestionResponse response = restTemplate.getForObject(
            apiUrl, 
            QuestionResponse.class);
        
        List<Question> questions = response.getResults();

        // for(int i = 0; i < questions.size(); i++) {
        //     questions.get(i).setId(i + 1);
            
        //     System.out.println(
        //     questions.get(i).getQuestionId()
        //     );
        // }

        return questions;
    }
}

