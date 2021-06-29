package com.kutayyaman.footballListCase.service;

import com.kutayyaman.footballListCase.domain.Footballer;
import com.kutayyaman.footballListCase.dto.FootballTeamDTO;
import com.kutayyaman.footballListCase.dto.FootballerDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFootballerService {
    List<FootballerDTO>  findAllFootballerByTeamId(Long teamId);
    ResponseEntity<?> deleteFootballersTeamById(Long footballerId);
    ResponseEntity<?> deleteFootballersByTeamId(Long teamId);
}
