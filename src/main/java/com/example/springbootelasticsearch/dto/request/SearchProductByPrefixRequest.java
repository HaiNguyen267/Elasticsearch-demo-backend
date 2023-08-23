package com.example.springbootelasticsearch.dto.request;


import lombok.Data;

@Data
public class SearchProductByPrefixRequest {
    private String prefix;
}
