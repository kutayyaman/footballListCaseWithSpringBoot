package com.kutayyaman.footballListCase.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kutayyaman.footballListCase.model.Nationality;
import com.kutayyaman.footballListCase.model.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballerDTO {
    private Long id;
    private String FootballerName;
    private String FootballerSurname;
    private Position position;
    private Nationality nationality;
    private String UniformNumber;
}
