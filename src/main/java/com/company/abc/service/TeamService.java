package com.company.abc.service;

import com.company.abc.domain.Team;
import com.company.abc.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public List<Team> getTeams(){
        return teamRepository.findAll();
    }

    public Team getTeam(Long id){
        return teamRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Team saveTeam(Team team){
        return teamRepository.save(team);
    }

    public void deleteTeam(Long id){
        teamRepository.deleteById(id);
    }

}
