package com.example.customvalidator.model;

import lombok.*;

import javax.validation.Valid;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Valid
public class БольшойСложныйОбъект {
    private String зависимоеПоле1;
    private String зависимоеПоле2;
    private String зависимоеПоле3;
    private String зависимоеПоле4;
    private String зависимоеПоле5;
}
