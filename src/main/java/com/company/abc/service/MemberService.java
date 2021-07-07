package com.company.abc.service;

import com.company.abc.domain.Member;
import com.company.abc.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> getMembers(){

        return memberRepository.findAll();
    }

    public Member getMember(Long id){

        return memberRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Member saveMember(Member member){
        return memberRepository.save(member);
    }

    public void deleteMember(Long id){
        memberRepository.deleteById(id);
    }

}
