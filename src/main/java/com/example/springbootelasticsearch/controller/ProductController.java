package com.example.springbootelasticsearch.controller;


import com.example.springbootelasticsearch.dto.request.SearchProductByNameRequest;
import com.example.springbootelasticsearch.dto.request.SearchProductByPrefixRequest;
import com.example.springbootelasticsearch.dto.response.CommonResponse;
import com.example.springbootelasticsearch.entity.Product;
import com.example.springbootelasticsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

     @Autowired
     private ProductService service;

     // create 4 methods to use the service class methods

    @GetMapping()
    public CommonResponse getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public CommonResponse getProductById(@PathVariable long id) {
        return service.getProductById(id);
    }

    @PostMapping("/add")
    public CommonResponse saveProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }




    // create a method to delete the product
    @DeleteMapping("/delete/{id}")
    public CommonResponse deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
    // create a method to get the product by id

    @PutMapping("/update/{id}")
    public CommonResponse updateProduct(@RequestBody Product product, @PathVariable int id) {
        return service.updateProduct(product, id);
    }


    @PostMapping("/autocomplete")
    public CommonResponse autoComplete(@RequestBody SearchProductByNameRequest request) {
        return service.autoComplete(request);
    }


    @PostMapping("/search")
    public CommonResponse searchProduct(@RequestBody SearchProductByNameRequest request) {
        return service.searchProduct(request);
    }

//    @GetMapping("/search-name")
//    public CommonResponse searchProductName(@RequestBody SearchProductByNameRequest searchProductByNameRequest) {
////        return service.searchProduct(name);
//        try {
//            return service.searchProduct(searchProductByNameRequest);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @GetMapping("/search-name-prefix")
//    public Object searchProductNameByPrefix(@RequestBody SearchProductByPrefixRequest searchProductByPrefixRequest) {
////        return service.searchProductByPrefix(name);
//        return service.searchProductByPrefix(searchProductByPrefixRequest);
//    }
//
//    @GetMapping("/search-name-native")
//    public Object searchProductNameByPrefix(@RequestBody SearchProductByNameRequest searchProductByNameRequest) throws IOException {
////        return service.searchProductByPrefix(name);
//        return service.searchNative(searchProductByNameRequest.getName());
//    }
//
//    @GetMapping("/search-product")
//    public Object searchProduct(@RequestBody SearchProductByNameRequest SearchProductByNameRequest) {
//        return service.findByNameContainingOrDescriptionContaining(SearchProductByNameRequest);
//    }
}
