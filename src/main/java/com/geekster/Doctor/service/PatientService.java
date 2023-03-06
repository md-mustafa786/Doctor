package com.geekster.Doctor.service;

import com.geekster.Doctor.dao.PatientRepository;
import com.geekster.Doctor.exception.RecordNotFound;
import com.geekster.Doctor.model.Doctor;
import com.geekster.Doctor.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PatientService {

    @Autowired
    PatientRepository repository;

    public void savePatient(Patient patient) {
        repository.save(patient);
    }

    public List<Patient> getPatient(String patientId, String docterId) throws RecordNotFound{
        List<Patient> patientsList = new ArrayList<>();
        Patient patient = repository.findById(Integer.valueOf(patientId)).get();
        Doctor doctor = patient.getDoctorId();
        if(doctor.getDoctorId()==Integer.parseInt(docterId)){
            patientsList.add(patient);
        }else {
            throw new RecordNotFound("Not Found");
        }
        return patientsList;
    }
}