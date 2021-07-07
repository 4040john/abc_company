package com.company.abc.controller;

import com.company.abc.domain.Company;
import com.company.abc.domain.Team;
import com.company.abc.dto.TeamInsertDTO;
import com.company.abc.service.CompanyService;
import com.company.abc.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    TeamService teamService;

    @Autowired
    CompanyService companyService;

    @GetMapping     //파람으로 받고 싶으실때는 @RequestParam으로 받으시면 됩니다
    public List<Team> getTeamList(){
        return teamService.getTeams();
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable Long id){
        return teamService.getTeam(id);
    }

    @PostMapping
    public Team insertTeam(@RequestBody TeamInsertDTO dto){
        Team team = new Team();
        Company company = companyService.getCompany(dto.getCompanyId());

        team.setCompany(company);
        team.setName(dto.getName());

        return teamService.saveTeam(team);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id,@RequestBody TeamInsertDTO dto){
        Team team = teamService.getTeam(id);
        Company company = companyService.getCompany(dto.getCompanyId());

        team.setCompany(company);
        team.setName(dto.getName());

        return teamService.saveTeam(team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id){
        teamService.deleteTeam(id);
    }
}
