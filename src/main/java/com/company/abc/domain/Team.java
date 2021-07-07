package com.company.abc.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") //하단두줄 : 서로바라볼때 무한재귀현상 방지 두쪽다 넣어줘야함

public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    private String name;

    @OneToMany(mappedBy = "team") //mappedBy 누가 날 어떤 명칭으로 호출하는지
    private List<Member> members;   //원투매니라 매니를 받아오려면 list

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company; //바라볼 객체 설정


}
