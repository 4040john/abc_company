package com.company.abc.controller;

import com.company.abc.domain.Company;
import com.company.abc.domain.Member;
import com.company.abc.domain.Team;
import com.company.abc.dto.MemberInsertDTO;
import com.company.abc.dto.TeamInsertDTO;
import com.company.abc.service.CompanyService;
import com.company.abc.service.MemberService;
import com.company.abc.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    TeamService teamService;

    @GetMapping     //파람으로 받고 싶으실때는 @RequestParam으로 받으시면 됩니다
    public List<Member> getMemberList(){
        return memberService.getMembers();
    }

    @GetMapping("/{id}")
    public Member getMember(@PathVariable Long id){
        return memberService.getMember(id);
    }

    @PostMapping
    public Member insertMember(@RequestBody MemberInsertDTO dto){
        Team team = teamService.getTeam(dto.getTeamId());

        Member member = new Member();
        member.setName(dto.getName());
        member.setCareer(dto.getCareer());
        member.setPhoneNumber(dto.getPhoneNumber());
        member.setJob(dto.getJob());
        member.setTeam(team);

        return memberService.saveMember(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id,@RequestBody MemberInsertDTO dto){
        Team team = teamService.getTeam(dto.getTeamId());

        Member member = memberService.getMember(id);
        member.setName(dto.getName());
        member.setCareer(dto.getCareer());
        member.setPhoneNumber(dto.getPhoneNumber());
        member.setJob(dto.getJob());
        member.setTeam(team);

        return memberService.saveMember(member);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id){
        teamService.deleteTeam(id);
    }

}
