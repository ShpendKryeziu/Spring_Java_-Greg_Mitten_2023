package com.example.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    // Esercizio 6    --------------------------------------------------------------------------------------------------
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
}
