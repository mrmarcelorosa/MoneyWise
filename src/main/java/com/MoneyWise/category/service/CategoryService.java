package com.MoneyWise.category.service;

import com.MoneyWise.category.entity.Category;
import com.MoneyWise.category.repository.CategoryRepository;
import com.MoneyWise.generic.service.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    public Category findById(UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Categoria não encontrada!")
        );
    }

    public Category save(Category category){
        return repository.save(category);
    }

    public Category update(Category category){
        findById(category.getId());
        return repository.save(category);
    }


}
