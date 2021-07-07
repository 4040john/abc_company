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
@AllArgsConstructor //전체 생성자 안넣어도 되도록
@Builder
@Data
@Entity         //jpa에서 도메인으로 인식하게끔
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") //하단두줄 : 서로바라볼때 무한재귀현상 방지 두쪽다 넣어줘야함

public class Company {
    
    @Id //식별자 (엔티티로 잡아넣었기떄문에 식별자 무조건 필요)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "company")
    private List<Team>  teams;
}
