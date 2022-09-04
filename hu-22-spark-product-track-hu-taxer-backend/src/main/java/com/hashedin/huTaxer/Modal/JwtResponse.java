package com.hashedin.huTaxer.Modal;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse{

    private User user;
    private String jwtToken;

}
