package com.kutayyaman.footballListCase.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Color extends BaseEntity{
    private String colorName;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "teamColors")
    private Collection<FootballTeam> footballTeamList = new ArrayList<>();
}
