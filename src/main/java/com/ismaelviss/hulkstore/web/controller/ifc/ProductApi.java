/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.ismaelviss.hulkstore.web.controller.ifc;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ismaelviss.hulkstore.domain.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-13T23:59:29.046Z")

@Validated
@Api(tags = "product", description = "the product API")
@RequestMapping(value = "/v1")
public interface ProductApi {

    @ApiOperation(value = "Add a new Product to the store", nickname = "addPet", notes = "", tags={ "product", })
    @ApiResponses(value = { 
        @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/product",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> addProduct(@ApiParam(value = "Product object that needs to be added to the store" ,required=true ) @RequestBody Product body);


    @ApiOperation(value = "Find product by ID", nickname = "getProductById", notes = "Returns a single product", response = Product.class, tags={ "product", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Product.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Product not found") })
    @RequestMapping(value = "/product/{productId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Product> getProductById(@ApiParam(value = "ID of Product to return",required=true) @PathVariable("productId") Long productId);


    @ApiOperation(value = "Find product by ID", nickname = "getProducts", notes = "Returns a single product", response = Product.class, tags={ "product", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Product.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Product not found") })
    @RequestMapping(value = "/product",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Product>> getProducts();


    @ApiOperation(value = "Update an existing Product", nickname = "updateProduct", notes = "", tags={ "product", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Product not found"),
        @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/product",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateProduct(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true ) @RequestBody Product body);

}
