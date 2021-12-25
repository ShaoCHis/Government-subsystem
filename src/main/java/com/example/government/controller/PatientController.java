package com.example.government.controller;
/**
 * Created By ShaoCHi
 * Date 2021/11/20 9:25 下午
 * Tongji University
 */

import com.example.government.model.Patient;
import com.example.government.model.Patient2;
import com.example.government.repository.PatientRepository;
import com.example.government.utils.Result;
import com.example.government.views.Economy;
import com.example.government.views.PatientInfo;
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
@RequestMapping(path = "/api/patients")
public class PatientController {
  @Autowired
  private PatientRepository patientRepository;

  @GetMapping(path = "/all")
  public Result<List<PatientInfo>> getAll(){
    Iterable<Patient> patient2Iterable=patientRepository.findAll();
    List<PatientInfo> patient2s=new LinkedList<>();
    for(Patient patient2:patient2Iterable){
      patient2s.add(new PatientInfo(patient2));
    }
    return Result.wrapSuccessfulResult(patient2s);
  }

  @GetMapping(path = "/{id}")
  public Result<Integer> getBalance(@PathVariable String id){
    Optional<Patient> patient=patientRepository.findById(id);
    if(!patient.isPresent()){
      return Result.wrapErrorResult("Not exist!");
    }
    return Result.wrapSuccessfulResult(patient.get().getBalance());
  }

  @PostMapping(path = "/update")
  public Result<String> update(@RequestBody Economy body){
    Optional<Patient> patient2=patientRepository.findById(body.getId());
    patient2.get().setBalance(patient2.get().getBalance()- body.getEconomy());
    patientRepository.save(patient2.get());
    return Result.wrapSuccessfulResult("update success!");
  }
}
