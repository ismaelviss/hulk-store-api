package com.ismaelviss.hulkstore.web.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ismaelviss.hulkstore.domain.model.Orders;
import com.ismaelviss.hulkstore.domain.service.ProductService;
import com.ismaelviss.hulkstore.domain.service.StoreService;
import com.ismaelviss.hulkstore.web.controller.ifc.StoreApi;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor
public class StoreApiController implements StoreApi {


    private static final Logger log = LoggerFactory.getLogger(StoreApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    private final StoreService storeService;

    public ResponseEntity<Map<String, Integer>> getInventory() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Map<String, Integer>>(objectMapper.readValue("{\"empty\": false}", Map.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Map<String, Integer>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Map<String, Integer>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Orders> placeOrder(@ApiParam(value = "order placed for purchasing the pet" ,required=true ) @RequestBody Orders body) {
        
    	/*
    	String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Orders>(objectMapper.readValue("{  \"bytes\": [],  \"empty\": true}", Orders.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Orders>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Orders>(HttpStatus.NOT_IMPLEMENTED);
        */
        
    	try {
    		return new ResponseEntity<Orders>(storeService.save(body),HttpStatus.OK);
    	} catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<Orders>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        

    }
   

}
