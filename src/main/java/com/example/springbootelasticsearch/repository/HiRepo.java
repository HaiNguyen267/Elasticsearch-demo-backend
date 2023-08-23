package com.example.springbootelasticsearch.repository;

import com.example.springbootelasticsearch.entity.Hi;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HiRepo extends ElasticsearchRepository<Hi, Long> {
}
