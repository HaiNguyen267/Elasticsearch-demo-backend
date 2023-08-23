package com.example.springbootelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
// 2 types of repositories: ElasticsearchRepository and JpaRepository must be in different packages, according to Spring Data Commons documentation
@EnableElasticsearchRepositories(basePackages = "com.example.springbootelasticsearch.search")
@EnableJpaRepositories(basePackages = "com.example.springbootelasticsearch.repository")
public class SpringBootElasticsearchApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootElasticsearchApplication.class, args);
	}

}
