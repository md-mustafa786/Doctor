package com.geekster.Doctor.controller;

import com.geekster.Doctor.Util.DoctorValidator;
import com.geekster.Doctor.model.Doctor;
import com.geekster.Doctor.service.DoctorService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class DoctorController {


    @Autowired
    DoctorService service;

    @PostMapping(value = "/add-doctor")
    public ResponseEntity<String> saveDoctor(@RequestBody String requestDoctor) {

        JSONObject json = new JSONObject(requestDoctor);

        List<String> validationList = DoctorValidator.validateDoctor(json);

        if(validationList.isEmpty()) {
            Doctor doctor = setDoctor(json);
            service.saveDoctor(doctor);
            return new ResponseEntity<>("Doctor saved", HttpStatus.CREATED);
        } else {

            String[] answer = Arrays.copyOf(
                    validationList.toArray(), validationList.size(), String[].class);

            return new ResponseEntity<>("Please pass these mandatory parameters- " +
                    Arrays.toString(answer), HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping(value = "/get-all-doctor")
    public List<Doctor> getDoctor(@Nullable @RequestParam String doctorId) {

        return service.getDoctor(doctorId);
    }

    @GetMapping("/get-doctor-By-exp")
    public List<Doctor> getbyExp(){
        return service.experiance();
    }



    public Doctor setDoctor (JSONObject json) {
        Doctor doctor = new Doctor();

        String doctorId =  json.getString("doctorId");
        doctor.setDoctorId(Integer.valueOf(doctorId));

        String doctorName = json.getString("doctorName");
        doctor.setDoctorName(doctorName);

        String specializedIn = json.getString("specializedIn");
        doctor.setSpecializedIn(specializedIn);

        if(json.has("experience")) {
            String exp = json.getString("experience");
            doctor.setExperience(exp);
        }

        return doctor;

    }






}