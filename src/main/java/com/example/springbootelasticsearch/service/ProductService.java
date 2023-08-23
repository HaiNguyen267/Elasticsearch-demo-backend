package com.example.springbootelasticsearch.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.example.springbootelasticsearch.dto.request.SearchProductByNameRequest;
import com.example.springbootelasticsearch.dto.response.CommonResponse;
import com.example.springbootelasticsearch.dto.response.ProductSearchResult;
import com.example.springbootelasticsearch.dto.response.SearchSuggestion;
import com.example.springbootelasticsearch.entity.Product;
import com.example.springbootelasticsearch.search.ProductElasticSearchRepo;
import com.example.springbootelasticsearch.repository.ProductMysqlRepo;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.NativeQuery;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.HighlightQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.SourceFilter;
import org.springframework.data.elasticsearch.core.query.highlight.Highlight;
import org.springframework.data.elasticsearch.core.query.highlight.HighlightField;
import org.springframework.data.elasticsearch.core.query.highlight.HighlightParameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductElasticSearchRepo elasticSearchRepo;

    @Autowired
    private ProductMysqlRepo mysqlRepo;

    @Autowired
    private ElasticsearchOperations operations;

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Autowired
    private RestClient restClient;




//    public Object searchProductByPrefix(SearchProductByPrefixRequest searchProductByPrefixRequest) {
//
//        SearchHits<Product> productsByPrefix = elasticSearchRepo.findByNameContaining(searchProductByPrefixRequest.getPrefix());
//
//        return productsByPrefix.toList();
//    }
//
//
//    public Object findByNameContainingOrDescriptionContaining(SearchProductByNameRequest searchProductByPrefixRequest) {
//
//        String text = searchProductByPrefixRequest.getName();
//        SearchHits<Product> productsByPrefix = elasticSearchRepo.findByNameOrDescription(text, text);
//        if (productsByPrefix.getTotalHits() == 0) {
//            productsByPrefix = elasticSearchRepo.findByNameContaining(text);
//        }
//        return productsByPrefix.toList();
//    }
//
//    public Object searchNative(String searchText) throws IOException {
//
//        Function<SearchRequest.Builder, ObjectBuilder<SearchRequest>> builderObjectBuilderFunction = s -> s
//                .index("products")
//                .query(q -> q
//                        .match(t -> t
//                                .field("name")
//                                .query(FieldValue.of(searchText))
//                        )
//                );
//
//        Query query = NativeQuery.builder()
//                .withQuery(q -> q
//                        .match(t -> t
//                                .field("name")
//                                .query(searchText)
//                        )
//                )
//                .build();
//        SearchResponse<Object> searchResponse = elasticsearchClient.search(builderObjectBuilderFunction, Object.class);
//        System.out.println("search response: " + searchResponse);
//
//
//        SearchHits<Product> search = operations.search(query, Product.class);
//        List<SearchHit<Product>> searchHits = search.getSearchHits();
//        List<Product> list = searchHits.stream().map(SearchHit::getContent).toList();
//
//        System.out.println("search hits: " + search);
//        System.out.println(search);
//        return list;
//
//    }


    public CommonResponse getAllProducts() {
//        List<Product> products = mysqlRepo.findAll();
//        elasticSearchRepo.findAll()
        List<Product> products = new ArrayList<>();
        elasticSearchRepo.findAll().forEach(products::add);

        return CommonResponse.builder()
                .code(200)
                .message("Get all products successfully")
                .data(products)
                .build();
    }

    @Transactional
    public CommonResponse saveProduct(Product product) {
        Product savedProduct = mysqlRepo.save(product);
        // index the product in elastic search
        elasticSearchRepo.save(savedProduct);
        return CommonResponse.builder()
                .code(200)
                .message("Product saved successfully")
                .data(savedProduct)
                .build();
    }


    @Transactional
    public CommonResponse deleteProduct(long id) {
        // delete the product from mysql and elastic search
        mysqlRepo.deleteById(id);
        elasticSearchRepo.deleteById(id);
//        operations.delete(String.valueOf(id), Product.class);

        return CommonResponse.builder()
                .code(200)
                .message("Product deleted successfully")
                .build();
    }

    @Transactional
    public CommonResponse updateProduct(Product product, long id) {
        Product oldProduct = (Product) mysqlRepo.findById(id).orElse(null);
        if (oldProduct == null) {
            return CommonResponse.builder()
                    .code(404)
                    .message("Product not found")
                    .build();
        }
        if (product.getName() != null) oldProduct.setName(product.getName());
        if (product.getDescription() != null) oldProduct.setDescription(product.getDescription());
        if (product.getImageUrl() != null) oldProduct.setImageUrl(product.getImageUrl());
        if (product.getPrice() != null) oldProduct.setPrice(product.getPrice());

        // update the product in mysql and elastic search
        mysqlRepo.save(oldProduct);
        elasticSearchRepo.save(oldProduct);
        operations.save(oldProduct);
        return CommonResponse.builder()
                .code(200)
                .message("Product updated successfully")
                .build();
    }

    public CommonResponse autoComplete(SearchProductByNameRequest request) {
        String name = request.getName();
        // if the results query is short and doesn't contain space, then show the short suggestion
        boolean showShortSuggestion = !name.contains(" ") && name.length() < 2;
        // nameAutoCompletion field is only used for autocompletion if the results query is long enough
        String searchField = showShortSuggestion ? "name" : "nameAutoCompletion";

        HighlightField highlightField = new  HighlightField(searchField);
        Highlight highlight = new Highlight(List.of(highlightField));
        HighlightQuery highlightQuery = new HighlightQuery(highlight, String.class);

        SourceFilter sourceFilter = new FetchSourceFilter(new String[]{"name"}, null);

        Query query;

        if (showShortSuggestion) {
            query = NativeQuery.builder()
                    .withQuery(q -> q
                            .prefix(v -> v
                                    .field(searchField)
                                    .value(name)
                            )
                    ).withHighlightQuery(highlightQuery)
                    .withSourceFilter(sourceFilter)
                    .withPageable(PageRequest.of(0, 5))
                    .build();
        } else {
            query = NativeQuery.builder()
                    .withQuery(q -> q
                            .matchPhrase(v -> v
                                    .field(searchField)
                                    .query(name)
                                    .slop(2)

                            )
                    ).withHighlightQuery(highlightQuery)
                    .withSourceFilter(sourceFilter)
                    .withPageable(PageRequest.of(0, 5))
                    .build();
        }

        SearchHits<Product> results = operations.search(query, Product.class);
        List<SearchSuggestion> suggestions = parseProductNameAndFormatSuggestions(results, showShortSuggestion, searchField);

        return CommonResponse.builder()
                .code(200)
                .message("Auto complete successfully")
                .data(suggestions)
                .build();
    }

    private List<SearchSuggestion> parseProductNameAndFormatSuggestions(SearchHits<Product> results, boolean showShortSuggestion, String searchField) {
        List<SearchHit<Product>> searchHits = results.getSearchHits();
        List<String> fullProductNamesWithHightlight = searchHits.stream().map(hit -> String.valueOf(hit.getHighlightField(searchField)))
                .map(s -> s.substring(1, s.length() - 1)) // remove the first and last character of the string which is [ and ]
                .toList();
        List<SearchSuggestion> searchSuggestions = new ArrayList<>();
        // if the results query is short and doesn't contain space, then show the short suggestion
        if (showShortSuggestion) {
            // get all phrases inside the tag <em> of the highlighted field, a string can have multiple <em> tags
            for (String s : fullProductNamesWithHightlight) {
                // loop through the string and find the index of <em> and </em>
                while (true) {
                    int start = s.indexOf("<em>");
                    int end = s.indexOf("</em>");
                    if (start != -1 && end != -1) {
                        SearchSuggestion searchSuggestion = SearchSuggestion.builder()
                                .productName(s.substring(start + 4, end))
                                .build();
                        searchSuggestions.add(searchSuggestion);
                        s = s.substring(end + 5); // find the next <em> tag in the string
                    } else {
                        break;
                    }
                }

            }

        } else {
            // if the results query is long enough, then show the full product name
            for (String productNameWithHightligh : fullProductNamesWithHightlight) {
                // remove the <em> tag
                String productName = productNameWithHightligh.replaceAll("<em>", "").replaceAll("</em>", "");
                SearchSuggestion searchSuggestion = SearchSuggestion.builder()
                        .productName(productName)
                        .productNameWithHighlight(productNameWithHightligh)
                        .build();
                searchSuggestions.add(searchSuggestion);
            }
        }


        // remove the duplicate suggestions
        Set<SearchSuggestion> set = new LinkedHashSet<>(searchSuggestions);
        searchSuggestions.clear();
        searchSuggestions.addAll(set);
        return searchSuggestions;
    }

    public CommonResponse searchProduct(SearchProductByNameRequest name) {

        String keyword = name.getName();
        String searchField = "description";

        HighlightField highlightField = new  HighlightField(searchField);
        Highlight highlight = new Highlight(List.of(highlightField));
        HighlightQuery highlightQuery = new HighlightQuery(highlight, String.class);


        Query query = NativeQuery.builder()
                .withQuery(q -> q
                        .bool(b -> b
                                .must(m -> m
                                        .matchPhrase(v -> v
                                                .field("name")
                                                .query(keyword)
                                                .slop(2)
                                    )
                                )
                                .should(s -> s
                                        .matchPhrase(v -> v
                                                .field("description")
                                                .query(keyword)
                                                .slop(2)
                                        )
                                )

                        )
                )
                .withHighlightQuery(highlightQuery)
//                .withPageable(PageRequest.of(0, 5))
                .build();


        SearchHits<Product> results = operations.search(query, Product.class);
        List<ProductSearchResult> productSearchResult = parseSearchResult(results, keyword);


        return CommonResponse.builder()
                .code(200)
                .message("Search successfully")
                .data(productSearchResult)
                .build();

    }

    private List<ProductSearchResult> parseSearchResult(SearchHits<Product> results, String keyword) {
        List<SearchHit<Product>> searchHits = results.getSearchHits();
        List<ProductSearchResult> products = new ArrayList<>();
        for (SearchHit<Product> searchHit : searchHits) {
            Product product = searchHit.getContent();
            ProductSearchResult productSearchResult = ProductSearchResult.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .imageUrl(product.getImageUrl())
                    .price(product.getPrice())
                    .description(product.getDescription())
                    .build();

            // get the highlighted match in the description
            String descriptionWithHighlight = String.valueOf(searchHit.getHighlightField("description"));
            if (descriptionWithHighlight != null) {
                // remove the first and last character of the string which is [ and ]
                descriptionWithHighlight = descriptionWithHighlight.substring(1, descriptionWithHighlight.length() - 1);
                productSearchResult.setDescriptionMatchHighlight(descriptionWithHighlight);
            }
            products.add(productSearchResult);
        }
        return products;
    }

    public CommonResponse getProductById(long id) {
        Product product = (Product) mysqlRepo.findById(id).orElse(null);
        if (product == null) {
            return CommonResponse.builder()
                    .code(404)
                    .message("Product not found")
                    .build();
        }
        return CommonResponse.builder()
                .code(200)
                .message("Get product by id successfully")
                .data(product)
                .build();
    }
}
