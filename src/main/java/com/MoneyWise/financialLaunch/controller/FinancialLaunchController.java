package com.MoneyWise.financialLaunch.controller;

import com.MoneyWise.financialLaunch.entity.FinancialLaunch;
import com.MoneyWise.financialLaunch.service.FinancialLaunchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "launchs")
public class FinancialLaunchController {

    @Autowired
    private FinancialLaunchService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<FinancialLaunch> findById(@PathVariable UUID id){
        FinancialLaunch obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody FinancialLaunch financialLaunch){
        financialLaunch.setId(null);
        financialLaunch = service.save(financialLaunch);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(financialLaunch.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody FinancialLaunch financialLaunch){
        financialLaunch.setId(id);
        service.update(financialLaunch);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<FinancialLaunch>> findAll(){
        List<FinancialLaunch> financialLaunchList = service.findAll();
        return ResponseEntity.ok().body(financialLaunchList);
    }
}
