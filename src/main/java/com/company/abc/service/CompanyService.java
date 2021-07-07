package com.company.abc.service;

import com.company.abc.domain.Company;
import com.company.abc.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository; //빈가져오기

    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }

    public Company getCompany(Long id){
        return companyRepository.findById(id).orElseThrow(NoSuchElementException::new); //orElseThrow : null 처리

    }

    public Company saveCompany(Company company){
        return companyRepository.save(company);
    }

    public void deleteCompany(Long id){
        companyRepository.deleteById(id);
    }

}
