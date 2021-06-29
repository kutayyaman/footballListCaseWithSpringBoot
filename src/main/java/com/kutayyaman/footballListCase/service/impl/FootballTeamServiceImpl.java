package com.kutayyaman.footballListCase.service.impl;

import com.kutayyaman.footballListCase.domain.FootballTeam;
import com.kutayyaman.footballListCase.domain.Footballer;
import com.kutayyaman.footballListCase.dto.FootballTeamDTO;
import com.kutayyaman.footballListCase.dto.FootballerDTO;
import com.kutayyaman.footballListCase.model.RowStatus;
import com.kutayyaman.footballListCase.repository.FootballTeamRepository;
import com.kutayyaman.footballListCase.service.IFootballTeamService;
import com.kutayyaman.footballListCase.service.IFootballerService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FootballTeamServiceImpl implements IFootballTeamService {
    private final FootballTeamRepository footballTeamRepository;
    private final ModelMapper modelMapper;
    private final IFootballerService footballerService;

    public FootballTeamServiceImpl(FootballTeamRepository footballTeamRepository, ModelMapper modelMapper, IFootballerService footballerService) {
        this.footballTeamRepository = footballTeamRepository;
        this.modelMapper = modelMapper;
        this.footballerService = footballerService;
    }

    @Override
    public List<FootballTeamDTO> findAllFootballTeam() {
        List<FootballTeam> footballTeamList = footballTeamRepository.findAllByRowStatus(RowStatus.ACTIVE);
        List<FootballTeamDTO> result = new ArrayList<>();

        for (FootballTeam footballTeam: footballTeamList) {
            FootballTeamDTO footballTeamDTO = modelMapper.map(footballTeam, FootballTeamDTO.class);
            result.add(footballTeamDTO);
        }

        return result;
    }

    @Override
    public FootballTeamDTO findFirstById(Long id) {
        FootballTeam footballTeam = footballTeamRepository.findFirstByIdAndRowStatus(id,RowStatus.ACTIVE);
        FootballTeamDTO footballTeamDTO = modelMapper.map(footballTeam,FootballTeamDTO.class);
        return footballTeamDTO;
    }

    @Override
    public ResponseEntity<?> deleteFootballTeamById(Long id) {
        FootballTeam footballTeam = footballTeamRepository.findFirstByIdAndRowStatus(id, RowStatus.ACTIVE);
        footballTeam.setRowStatus(RowStatus.DELETED);


        List<FootballerDTO> footballerDTOS = footballerService.findAllFootballerByTeamId(id);
        for(FootballerDTO footballerDTO : footballerDTOS){
            footballerService.deleteFootballersTeamById(footballerDTO.getId());
        }

        footballTeamRepository.save(footballTeam);
        return ResponseEntity.ok("Football Team Deleted");
    }

    @Override
    public ResponseEntity<?> updateFootballTeam(FootballTeamDTO footballTeamDTO) {
        FootballTeam footballTeam = footballTeamRepository.findFirstByIdAndRowStatus(footballTeamDTO.getId(),RowStatus.ACTIVE);

        footballTeam.setTeamName(footballTeamDTO.getTeamName());
        footballTeam.setCity(footballTeamDTO.getCity());
        footballTeam.setLeague(footballTeamDTO.getLeague());
        footballTeam.setLogoUrl(footballTeamDTO.getLogoUrl());
        footballTeam.setYearTeamWasFounded(footballTeamDTO.getYearTeamWasFounded());
        footballTeamRepository.save(footballTeam);

        return ResponseEntity.ok("Football Team Is Updated");
    }


}
