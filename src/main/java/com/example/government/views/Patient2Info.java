package com.example.government.views;
/**
 * Created By ShaoCHi
 * Date 2021/11/20 4:51 下午
 * Tongji University
 */

import com.example.government.model.Patient;
import com.example.government.model.Patient2;
import lombok.Data;

import java.sql.Date;

/**
 * author ShaoCHi
 * Date 2021/11/20 4:51 下午
 * Tongji University
 */

@Data
public class Patient2Info {
  private String patientId;

  private String cardId;

  private String name;

  private String phoneNumber;

  private String sex;

  private Date birthday;

  private Integer type;

  private Integer balance;

  public Patient2Info(Patient2 patient2){
    this.type=2;
    this.patientId=patient2.getPatientId();
    this.cardId=patient2.getCardId();
    this.name=patient2.getName();
    this.phoneNumber=patient2.getPhoneNumber();
    this.sex=patient2.getSex();
    this.birthday=patient2.getBirthday();
    this.balance=patient2.getBalance();
  }
}
