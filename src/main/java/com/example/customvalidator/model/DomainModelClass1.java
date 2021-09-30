package com.example.customvalidator.model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Valid
public class DomainModelClass1 {

    @NotNull
    private Boolean booleanValue;

    @Email
    private String stringValue;

}
