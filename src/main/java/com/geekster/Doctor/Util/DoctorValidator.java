package com.geekster.Doctor.Util;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DoctorValidator {

    public static List<String> validateDoctor(JSONObject json) {

        List<String> errorList = new ArrayList<>();


        if(!json.has("doctorId")) {
            errorList.add("doctorId");
        }

        if(!json.has("doctorName")) {
            errorList.add("doctorName");
        }

        if(!json.has("specializedIn")) {
            errorList.add("specializedIn");
        }

        return errorList;

    }

}
