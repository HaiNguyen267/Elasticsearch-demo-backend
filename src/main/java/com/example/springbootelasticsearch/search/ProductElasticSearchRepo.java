package com.example.springbootelasticsearch.search;

import com.example.springbootelasticsearch.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Highlight;
import org.springframework.data.elasticsearch.annotations.HighlightField;
import org.springframework.data.elasticsearch.annotations.SourceFilters;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductElasticSearchRepo extends ElasticsearchRepository<Product, Long> {
    @Highlight(fields = {@HighlightField(name = "name")})
    @SourceFilters(includes = "name")
    SearchHits<Product> findByNameContaining(String name);


    List<Product> findByNameOrDescription(String name, String description, Pageable pageable);

}
