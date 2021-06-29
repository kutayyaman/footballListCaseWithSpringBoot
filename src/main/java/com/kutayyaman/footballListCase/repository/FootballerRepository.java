package com.kutayyaman.footballListCase.repository;

import com.kutayyaman.footballListCase.domain.FootballTeam;
import com.kutayyaman.footballListCase.domain.Footballer;
import com.kutayyaman.footballListCase.model.RowStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FootballerRepository extends JpaRepository<Footballer,Long> {
    List<Footballer> findAllByFootballTeamAndRowStatus(FootballTeam footballTeam, RowStatus rowStatus);
    Footballer findFirstByIdAndRowStatus(Long footballerId, RowStatus rowStatus);
}
