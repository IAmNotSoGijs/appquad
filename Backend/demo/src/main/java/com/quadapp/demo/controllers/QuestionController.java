package com.quadapp.demo.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quadapp.demo.entity.QuestionSubmission;
import com.quadapp.demo.entity.QuizResponse;
import com.quadapp.demo.services.QuestionService;

@RestController 
@CrossOrigin(origins = "http://localhost:62417")
public class QuestionController {
    
    private final QuestionService questionService;
    
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
        
    }

    @GetMapping ("/questions")
    public QuizResponse getAllQuestions() {  
        
        
        return questionService.createQuiz();

        /// kan met succes nu json data ophalen van de API en terugsturen naar de frontend.
        /// volgende stap, deze json data omzetten naar een object en dit object terugsturen naar de frontend.
        /// is af, nu nog een stap verzinnen om de correcte antwoorden en de incorrecte antwoorden te hashen om naar de frontend te sturen.
    }

    @PostMapping("SumbitAnswers")
    public int postMethodName(@RequestBody QuestionSubmission questionSubmission) 
    {
        return questionService.checkAnswers(questionSubmission);

        /// getest en werkt, de score wordt correct berekend en teruggestuurd naar de frontend. getest met postman.
        /// wilde oorspronkelijk 2 lijsten versturen, echter kwam ik erachter dat het niet mogelijk is om 2 lijsten zo te vullen. maar met een singular object (die 2 lijsten bevat) kan dat wel, dus heb ik een questionsubmission object gemaakt die automatisch de lijsten vult gebaseerd op de json die je verstuurd.
    }   
}