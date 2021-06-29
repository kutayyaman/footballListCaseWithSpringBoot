package com.kutayyaman.footballListCase.api;

import com.kutayyaman.footballListCase.dto.DeleteAllFootballersByTeamIdDTO;
import com.kutayyaman.footballListCase.dto.FootballerDTO;
import com.kutayyaman.footballListCase.service.IFootballerService;
import com.kutayyaman.footballListCase.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.FootballerCtrl.CTRL)  // /api/footballer
public class FootballerController {
    private final IFootballerService footballerService;

    public FootballerController(IFootballerService footballerService) {
        this.footballerService = footballerService;
    }

    // /api/footballer/{teamId}
    @GetMapping("/{teamId}")
    public List<FootballerDTO> findAllFootballerByTeamId(@PathVariable Long teamId) {
        return footballerService.findAllFootballerByTeamId(teamId);
    }

    @DeleteMapping("/delete-by-team-id")
    public ResponseEntity<?> deleteAllFootballersByTeamId(@RequestBody DeleteAllFootballersByTeamIdDTO deleteAllFootballersByTeamIdDTO){
        return footballerService.deleteFootballersByTeamId(deleteAllFootballersByTeamIdDTO.getTeamId());
    }

}
