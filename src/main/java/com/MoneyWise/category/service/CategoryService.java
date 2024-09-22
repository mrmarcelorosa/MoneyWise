package com.MoneyWise.category.service;

import com.MoneyWise.category.entity.Category;
import com.MoneyWise.category.repository.CategoryRepository;
import com.MoneyWise.generic.exception.DataIntegrityException;
import com.MoneyWise.generic.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void delete(UUID id){
        findById(id);
        try {
            repository.deleteById(id);
        }catch (DataIntegrityViolationException dataIntegrityViolationException){
            throw new DataIntegrityException("Não é possível excluir uma categoria que tenha lançamentos vinculados");
        }
    }

    public List<Category> findAll(){
        return repository.findAll();
    }


}
