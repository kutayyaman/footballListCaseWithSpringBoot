package com.kutayyaman.footballListCase.api;

import com.kutayyaman.footballListCase.dto.DeleteFootballTeamDTO;
import com.kutayyaman.footballListCase.dto.FootballTeamDTO;
import com.kutayyaman.footballListCase.service.IFootballTeamService;
import com.kutayyaman.footballListCase.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.FootballTeamCtrl.CTRL)  // /api/footballTeam
public class FootballTeamController {
    private final IFootballTeamService footballTeamService;

    public FootballTeamController(IFootballTeamService footballTeamService) {
        this.footballTeamService = footballTeamService;
    }

    @GetMapping()
    public List<FootballTeamDTO> findAllFootballTeam() {
        return footballTeamService.findAllFootballTeam();
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteFootballTeamById(@RequestBody DeleteFootballTeamDTO deleteFootballTeamDTO) {
        return footballTeamService.deleteFootballTeamById(deleteFootballTeamDTO.getId());
    }

    @PutMapping()
    public ResponseEntity<?> updateFootballTeam(@RequestBody FootballTeamDTO footballTeamDTO) {
        return footballTeamService.updateFootballTeam(footballTeamDTO);
    }
}
