package com.example.government.repository;


import com.example.government.model.Patient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created By ShaoCHi
 * Date 2021/11/20 5:26 下午
 * Tongji University
 */
public interface PatientRepository extends CrudRepository<Patient,String> {
}
