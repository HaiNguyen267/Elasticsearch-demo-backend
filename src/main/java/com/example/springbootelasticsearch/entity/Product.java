package com.example.springbootelasticsearch.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.elasticsearch.annotations.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Document(indexName = "product_index")
@Table(name = "products")
@Setting(settingPath = "product-index-analyzer.json")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Field(type = FieldType.Long)
    private Long id;

    // make this long text in mysql
    @Column(length = 1000)
    @Field(type = FieldType.Text, analyzer = "asciifolding_analyzer")
    private String name;


    @Field(type = FieldType.Text, analyzer = "autocomplete_analyzer")
    @Transient
    private String nameAutoCompletion; // this field will only used by Elasticsearch for autocompletion


    @Field(store = false)
    // make this long text in mysql
    @Column(length = 1000)
    private String imageUrl; // this field is not indexed

    @Field(type = FieldType.Long)
    private Long price;


    @Field(type = FieldType.Text, analyzer = "asciifolding_analyzer")
    // make this long text in mysql
    @Column(length = 5000)
    private String description;


    // fix the error: Caused by: org.springframework.data.mapping.PropertyReferenceException: No property 'searchSimilar' found for type 'Product'
    @Transient
    private String searchSimilar;

    public Product(String name, String imageUrl, Long price, String description) {
        this.name = name;
        this.nameAutoCompletion = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
    }


    public String getNameAutoCompletion() {
        if (nameAutoCompletion == null) {
            this.nameAutoCompletion = name;

        }
        return nameAutoCompletion;
    }
}
