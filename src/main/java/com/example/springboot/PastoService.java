package com.example.springboot;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PastoService {
    private PastoDao pastoDao;
    @Autowired
    public PastoService(PastoDao pastoDao) {
        this.pastoDao = pastoDao;
    }

    public List<Pasto> getPasti() {
        return pastoDao.findAll();
    }

    // -----------------------------------------------------------------------------------------------------------------
    // Esercizio Where in Hibernate    ---------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    public List<Pasto> test1() {
        return pastoDao.findByDescription("Big serving of spicy lentils with coconut milk!");
    }
    public List<Pasto> test2() {
        return pastoDao.findByPriceLessThan(13.0);
    }
    public List<Pasto> test3() {
        return pastoDao.findByPriceBetween(11.0, 15.0);
    }
    public List<Pasto> test4() {
        return pastoDao.findByDescriptionAndPriceLessThan("Mezzepenne with Pesto Genovese, the classic with basilico, parmigiano, pinoli and extra vergin olive oil.", 11.0);
    }
    public List<Pasto> test5() {
        return pastoDao.findByDescriptionContains("ragu");
    }
    public List<Pasto> test6() {
        return pastoDao.findByPriceLessThanAndCaloriesGreaterThanOrCaloriesLessThan(11.0, 500, 400);
    }

    // ESERCIZIO 6 __________________________________________________________ //

    public List<Pasto> getWinterPasti() {
        Double currentTemp = getCurrentTemperatureInCelsius();
        if (currentTemp < 12.0) {
            return pastoDao.findByIsWinterMeal(true);
        } else return pastoDao.findByIsWinterMeal(false);
    }

    private Double getCurrentTemperatureInCelsius(){
        JSONObject apiResponse = null;
        try {
            apiResponse = Unirest.get("https://api.open-meteo.com/v1/forecast?latitude=64.14&longitude=-21.90&current_weather=true")
                    .asJson().getBody().getObject();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
        return apiResponse.getJSONObject("current_weather").getDouble("temperature");
    }
}
