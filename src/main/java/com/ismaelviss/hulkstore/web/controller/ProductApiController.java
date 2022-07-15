package com.ismaelviss.hulkstore.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
//import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ismaelviss.hulkstore.domain.model.Category;
import com.ismaelviss.hulkstore.domain.model.Product;
import com.ismaelviss.hulkstore.domain.service.AuthService;
import com.ismaelviss.hulkstore.domain.service.JwtService;
import com.ismaelviss.hulkstore.domain.service.ProductService;
import com.ismaelviss.hulkstore.domain.service.RoleService;
import com.ismaelviss.hulkstore.domain.service.UsersDetailsService;
import com.ismaelviss.hulkstore.web.controller.ifc.ProductApi;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor
public class ProductApiController implements ProductApi {

	
    private static final Logger log = LoggerFactory.getLogger(ProductApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    private final ProductService productService;

    /*
    @org.springframework.beans.factory.annotation.Autowired
    public ProductApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    
    */

    public ResponseEntity<Void> addProduct(@ApiParam(value = "Product object that needs to be added to the store" ,required=true ) @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Product> getProductById(@ApiParam(value = "ID of Product to return",required=true) @PathVariable("productId") Long productId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Product>(objectMapper.readValue("{\"empty\": false}", Product.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Product>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Product>> getProducts() {
    	/*
        String accept = request.getHeader("Accept");
        try {
            List<Product> listProductsMock = new ArrayList<Product>();
            
            Product product = new Product();
            Category category = new Category();
            //category.setId(1);category.setName("Ropa");
        	product.setId(1);
        	product.setCategory("Ropa");
        	//product.setCategory(category);
        	listProductsMock.add(product);
        	
            return new ResponseEntity<List<Product>>(listProductsMock,HttpStatus.OK);
            //return new ResponseEntity<List<Product>>(objectMapper.readValue("{\"empty\": false}", Product.class), HttpStatus.NOT_IMPLEMENTED);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        */
    	
    	try {
    		return new ResponseEntity<List<Product>>(productService.findAll(),HttpStatus.OK);
    	} catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        

        //return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ResponseEntity<Void> updateProduct(@ApiParam(value = "Product object that needs to be added to the store" ,required=true ) @RequestBody Product body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
