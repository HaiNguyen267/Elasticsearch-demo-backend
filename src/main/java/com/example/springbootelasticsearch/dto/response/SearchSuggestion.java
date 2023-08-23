package com.example.springbootelasticsearch.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchSuggestion {
    private String productName;
    private String productNameWithHighlight; // the value but contains the html tags



    public String getProductNameWithHighlight() {
        // valueInHtml is null when user input contains only 1 character, in that case we don't need to highlight anything
        if (productNameWithHighlight == null) {
            return productName;
        }
        return productNameWithHighlight;
    }
}
