package com.hashedin.huTaxer.Controller;


import com.hashedin.huTaxer.Modal.JwtRequest;
import com.hashedin.huTaxer.Modal.JwtResponse;
import com.hashedin.huTaxer.Services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;


    @PostMapping({"/login/authenticate"})
    public JwtResponse createJwtTokens(@RequestBody @Valid JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }



}
