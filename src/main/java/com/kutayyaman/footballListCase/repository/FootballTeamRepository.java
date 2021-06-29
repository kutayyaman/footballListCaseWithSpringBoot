package com.kutayyaman.footballListCase.repository;

import com.kutayyaman.footballListCase.domain.FootballTeam;
import com.kutayyaman.footballListCase.model.RowStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FootballTeamRepository extends JpaRepository<FootballTeam,Long> {
    List<FootballTeam> findAllByRowStatus(RowStatus rowStatus);

    FootballTeam findFirstByIdAndRowStatus(Long id,RowStatus rowStatus);
}
