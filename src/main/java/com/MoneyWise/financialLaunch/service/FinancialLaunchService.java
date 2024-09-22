package com.MoneyWise.financialLaunch.service;

import com.MoneyWise.financialLaunch.entity.FinancialLaunch;
import com.MoneyWise.financialLaunch.repository.FinancialLaunchRepository;
import com.MoneyWise.generic.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FinancialLaunchService {

    @Autowired
    FinancialLaunchRepository repository;

    public FinancialLaunch findById(UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Categoria não encontrada!")
        );
    }

    public FinancialLaunch save(FinancialLaunch financialLaunch){
        return repository.save(financialLaunch);
    }

    public FinancialLaunch update(FinancialLaunch category){
        findById(category.getId());
        return repository.save(category);
    }

    public void delete(UUID id){
        findById(id);
        repository.deleteById(id);
    }

    public List<FinancialLaunch> findAll(){
        return repository.findAll();
    }

}
