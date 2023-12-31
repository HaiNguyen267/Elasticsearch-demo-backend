package com.example.springbootelasticsearch.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponse {
    private int code;
    private String message;
    private Object data;
}
