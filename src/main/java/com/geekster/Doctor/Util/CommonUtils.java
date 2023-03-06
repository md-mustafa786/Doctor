package com.geekster.Doctor.Util;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CommonUtils {

    public static List<String> validatePatient(JSONObject json) {

        List<String> errorList = new ArrayList<>();


        if(!json.has("patientId")) {
            errorList.add("patientId");
        }

        if(!json.has("patientName")) {
            errorList.add("patientName");
        }

        if(!json.has("phoneNumber")) {
            errorList.add("phoneNumber");
        }

        if(!json.has("diseaseType")) {
            errorList.add("diseaseType");
        }
        if(!json.has("gender")) {
            errorList.add("gender");
        }
        if(!json.has("doctorId")) {
            errorList.add("doctorId");
        }

        return errorList;

    }
}