package com.example.springboot.dao;

import com.example.springboot.model.Doctor;
import com.example.springboot.model.Hospital;
import com.example.springboot.model.Hospitals;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDAO {

    private static Hospitals list = new Hospitals();

    static
    {
        list.getHospitalList().add(new Hospital("Florence Nigthngale", "İstanbul", "Gupta", "1111110011"));
        list.getHospitalList().add(new Hospital("Acıbadem", "Ankara", "www.acibadem.com", "1111110011"));
        list.getHospitalList().add(new Hospital("Cerrahpaşa", "İstanbul", "www.cerrahpasa.com", "1111110011"));
    }
    public Hospitals getHospital() {

        return list;
    }

    public Hospital getHospitalById(long id){
        for (Hospital hospital: list.getHospitalList()) {
            if (hospital.getId() == id){
                return hospital;
            }
        }
        return null;
    }

    public void addHospital(Hospital hospital) {
        list.getHospitalList().add(hospital);
    }
}
