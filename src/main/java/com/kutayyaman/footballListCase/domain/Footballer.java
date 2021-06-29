package com.kutayyaman.footballListCase.domain;

import com.kutayyaman.footballListCase.model.Nationality;
import com.kutayyaman.footballListCase.model.Position;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Footballer extends BaseEntity{
    private String FootballerName;
    private String FootballerSurname;
    @Enumerated(EnumType.STRING)
    private Position position;
    @Enumerated(EnumType.STRING)
    private Nationality nationality;
    private String UniformNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "footballTeamId")
    private FootballTeam footballTeam;
}
