package com.metro.metromilan.controller;

import com.metro.metromilan.entity.UserClassRegistration;
import com.metro.metromilan.services.Interfaces.IfirstTimeUserService;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/new")
public class firstTimeController {
    /*
    need to show ~ 10 nearby entries to the new user.
    user I/P :- Either enable location or manually enter it.
    */


    final IfirstTimeUserService ifirstTimeUserService;

    private static final Logger log = LoggerFactory.getLogger(firstTimeController.class);

    public firstTimeController(IfirstTimeUserService ifirstTimeUserService) {
        this.ifirstTimeUserService = ifirstTimeUserService;
    }

    /*@ApiOperation(value = "Get initial data for new User.", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 400, message = "Bad Request, Request cannot be fulfilled due to bad syntax"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 405, message = "Method not allowed")})*/
    @GetMapping(value = "/user" /*produces = MediaType.APPLICATION_JSON_VALUE*/)
    private List<UserClassRegistration> firstTimeController(@RequestParam(name="selectedPlace") @NotNull String place){
        log.info("Inside the Controller of firstTimeController");
        //log.info("Hello There");
        place=place.toUpperCase();
        log.info(place);
        return ifirstTimeUserService.getNearbyDestination(place);
        //return new ResponseEntity<>(HttpStatus.OK);
    }
}
