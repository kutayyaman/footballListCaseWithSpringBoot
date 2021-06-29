package com.kutayyaman.footballListCase.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kutayyaman.footballListCase.model.League;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FootballTeamDTO {
    private Long id;
    private String teamName;
    private League league;
    private String logoUrl;
    private String city;
    private String yearTeamWasFounded;
}
