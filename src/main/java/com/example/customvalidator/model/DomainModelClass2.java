package com.example.customvalidator.model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Valid
public class DomainModelClass2 {
    @NotNull
    private Integer integerValue;

    @Size(min = 2, max = 5)
    private String stringValue;
}
