package com.example.government.controller;
/**
 * Created By ShaoCHi
 * Date 2021/11/20 9:25 下午
 * Tongji University
 */

import com.example.government.model.Patient2;
import com.example.government.repository.Patient2Repository;
import com.example.government.utils.Result;
import com.example.government.views.Economy;
import com.example.government.views.Patient2Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * author ShaoCHi
 * Date 2021/11/20 9:25 下午
 * Tongji University
 */


@RestController
@RequestMapping(path = "/api/patient2s")
public class Patient2Controller {
  @Autowired
  private Patient2Repository patient2Repository;

  @GetMapping(path = "/all")
  public Result<List<Patient2Info>> getAll(){
    Iterable<Patient2> patient2Iterable=patient2Repository.findAll();
    List<Patient2Info> patient2s=new LinkedList<>();
    for(Patient2 patient2:patient2Iterable){
      patient2s.add(new Patient2Info(patient2));
    }
    return Result.wrapSuccessfulResult(patient2s);
  }

  @GetMapping(path = "/{id}")
  public Result<Integer> getBalance(@PathVariable String id){
    Optional<Patient2> patient2=patient2Repository.findById(id);
    if(!patient2.isPresent()){
      return Result.wrapErrorResult("Not exist!");
    }
    return Result.wrapSuccessfulResult(patient2.get().getBalance());
  }

  @PostMapping(path = "/update")
  public Result<String> update(@RequestBody Economy body){
    Optional<Patient2> patient2=patient2Repository.findById(body.getId());
    patient2.get().setBalance(patient2.get().getBalance()- body.getEconomy());
    patient2Repository.save(patient2.get());
    return Result.wrapSuccessfulResult("update success!");
  }
}
