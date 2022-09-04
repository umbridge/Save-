package com.hashedin.huTaxer.Modal;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {
    @NotNull(message = "UserName can't be null")
    private String userName;
    @NotNull(message = "Password Can't be null")
    private String userPassword;

}