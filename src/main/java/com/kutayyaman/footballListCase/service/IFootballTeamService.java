package com.kutayyaman.footballListCase.service;

import com.kutayyaman.footballListCase.domain.FootballTeam;
import com.kutayyaman.footballListCase.dto.FootballTeamDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFootballTeamService {
    List<FootballTeamDTO> findAllFootballTeam();
    FootballTeamDTO findFirstById(Long id);
    ResponseEntity<?> deleteFootballTeamById(Long id);
    ResponseEntity<?> updateFootballTeam(FootballTeamDTO footballTeamDTO);
}
