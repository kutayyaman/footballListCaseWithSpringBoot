package com.kutayyaman.footballListCase.service.impl;

import com.kutayyaman.footballListCase.domain.FootballTeam;
import com.kutayyaman.footballListCase.domain.Footballer;
import com.kutayyaman.footballListCase.dto.FootballTeamDTO;
import com.kutayyaman.footballListCase.dto.FootballerDTO;
import com.kutayyaman.footballListCase.model.RowStatus;
import com.kutayyaman.footballListCase.repository.FootballerRepository;
import com.kutayyaman.footballListCase.service.IFootballTeamService;
import com.kutayyaman.footballListCase.service.IFootballerService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FootballerServiceImpl implements IFootballerService {
    private final FootballerRepository footballerRepository;
    private final IFootballTeamService footballTeamService;
    private final ModelMapper modelMapper;

    public FootballerServiceImpl(FootballerRepository footballerRepository, @Lazy IFootballTeamService footballTeamService, ModelMapper modelMapper) {
        this.footballerRepository = footballerRepository;
        this.footballTeamService = footballTeamService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<FootballerDTO> findAllFootballerByTeamId(Long teamId) {
        FootballTeamDTO footballTeamDTO = footballTeamService.findFirstById(teamId);
        List<FootballerDTO> result = new ArrayList<>();

        FootballTeam footballTeam = modelMapper.map(footballTeamDTO,FootballTeam.class);

        List<Footballer> footballers = footballerRepository.findAllByFootballTeamAndRowStatus(footballTeam, RowStatus.ACTIVE);
        for (Footballer footballer : footballers){
            FootballerDTO footballerDTO = modelMapper.map(footballer,FootballerDTO.class);
            result.add(footballerDTO);
        }
        return result;
    }

    @Override
    public ResponseEntity<?> deleteFootballersTeamById(Long footballerId) {
        Footballer footballer = footballerRepository.findFirstByIdAndRowStatus(footballerId,RowStatus.ACTIVE);
        footballer.setFootballTeam(null);
        footballerRepository.save(footballer);
        return ResponseEntity.ok("Footballer's Team Is Deleted");
    }

    @Override
    public ResponseEntity<?> deleteFootballersByTeamId(Long teamId) {
        FootballTeamDTO footballTeamDTO = footballTeamService.findFirstById(teamId);
        FootballTeam footballTeam = modelMapper.map(footballTeamDTO,FootballTeam.class);

        List<Footballer> footballers = footballerRepository.findAllByFootballTeamAndRowStatus(footballTeam,RowStatus.ACTIVE);
        for(Footballer footballer : footballers){
            footballer.setRowStatus(RowStatus.DELETED);
        }
        footballerRepository.saveAll(footballers);

        return ResponseEntity.ok("Footballers Deleted By Team Id");
    }
}
