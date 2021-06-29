package com.kutayyaman.footballListCase.domain;

import com.kutayyaman.footballListCase.model.League;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class FootballTeam extends BaseEntity{
    private String teamName;
    @Enumerated(EnumType.STRING)
    private League league;
    private String logoUrl;
    private String city;
    private String yearTeamWasFounded;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "FOOTBALLTEAM_COLOR", //3. tablo adi
            joinColumns = @JoinColumn(name = "FOOTBALLTEAM_ID"), //FK1
            inverseJoinColumns = @JoinColumn(name = "COLOR_ID")) //FK2
    private Collection<Color> teamColors = new ArrayList<>();
    @OneToMany(mappedBy = "footballTeam", fetch = FetchType.LAZY)
    private List<Footballer> footballers = new ArrayList<>();

}
