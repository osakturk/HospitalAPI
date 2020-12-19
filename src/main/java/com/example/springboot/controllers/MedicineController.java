package com.example.springboot.controllers;

import com.example.springboot.dao.MedicineDAO;
import com.example.springboot.model.Medicine;
import com.example.springboot.model.Medicines;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicineController {

    @Autowired
    MedicineDAO medicineDao;

    @GetMapping(path="/api/medicines", produces = MediaType.APPLICATION_JSON_VALUE)
    public Medicines showAllMedicines(){
        return medicineDao.getMedicines();
    }

    @GetMapping(path="/api/medicines/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Medicine medicineViewByName(@PathVariable("name") String name ) {
        return medicineDao.getMedicineByName(name);
    }

    @GetMapping(path="/api/medicines/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Medicine medicineViewById(@PathVariable("id") String  id) {
        return medicineDao.getMedicineById(UUID.fromString(id));
    }

    @PostMapping(value="/api/medicines", produces= MediaType.APPLICATION_JSON_VALUE)
    public Medicine addMedicine(@RequestParam Map<String, String> formData) {
        Medicine medicines = Medicine.convertBody(formData);
        medicines.setId(UUID.randomUUID());
        return medicineDao.addMedicine(medicines);
    }

    @PutMapping(path = "/api/medicines/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public void updateMedicine(@PathVariable("id") String id, @RequestParam Map<String, String> formData) {

        Medicine medicines = Medicine.convertBody(formData);
        medicines.setId(UUID.fromString(id));
        medicineDao.updateMedicine(medicines);
    }

    @DeleteMapping(value="/api/medicines/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value=HttpStatus.OK)
    public void deleteMedicine(@PathVariable("id") String id) {
        medicineDao.deleteMedicine(UUID.fromString(id));
    }
}
