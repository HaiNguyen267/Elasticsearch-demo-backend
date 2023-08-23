package com.example.springbootelasticsearch.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSearchResult {
    private long id;
    private String name;
    private String imageUrl;
    private Long price;
    private String description;
    private String descriptionMatchHighlight; // this field contains the highlighted description with HTML tags
}
