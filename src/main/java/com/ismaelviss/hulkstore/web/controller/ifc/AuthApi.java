/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.27).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.ismaelviss.hulkstore.web.controller.ifc;

//import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ismaelviss.hulkstore.domain.model.JWT;
import com.ismaelviss.hulkstore.domain.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-07-13T23:59:29.046Z")

@Validated
@Api(tags = "auth", description = "the auth API")
@RequestMapping(value = "/v1")
public interface AuthApi {

    @ApiOperation(value = "Login user", nickname = "loginUser", notes = "Login User.", response = JWT.class, tags={ "auth", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = JWT.class) })
    @RequestMapping(value = "/auth/login",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<?> loginUser(@ApiParam(value = "Logn user object" ,required=true ) @RequestBody User body);


    @ApiOperation(value = "Register user", nickname = "registerUser", notes = "This can only be done by the logged in user.", tags={ "auth", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation") })
    @RequestMapping(value = "/auth/register",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<?> registerUser(@ApiParam(value = "Register user object" ,required=true ) @RequestBody User body);

}
