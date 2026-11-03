package com.quadapp.demo.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionResponse {
    
    @JsonProperty("response_code")
    private int responseCode;

    @JsonProperty("results")
    private List<Question> results;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Question> getResults() {
        return results;
    }

    public void setResults(List<Question> results) {
        this.results = results;
    }
}
