package com.pliskin.util;

import com.pliskin.model.MedClinic;
import com.pliskin.model.Office;
import com.pliskin.model.Provider;
import com.pliskin.service.MedClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 * Created by aleksandrpliskin on 27.10.15.
 */
public class CreateModel {

    @Autowired
    private MedClinicService medClinicService;

    public Model createModel(Model model, Provider provider, MedClinic medClinic, Office office) {
        if (medClinic.getName() == null) {
            model.addAttribute("medClinicNames", medClinicService.getMedClinicNames());
        } else if (office.getCity() == null) {
            model.addAttribute("medClinicName", medClinic.getName());
            model.addAttribute("cities", medClinicService.getMedClinicCities(medClinic.getName()));
        } else if (office.getStreet() == null) {
            model.addAttribute("medClinicName", medClinic.getName());
            model.addAttribute("streets", medClinicService.getStreetsOfOfficeInCityOfMedClinic(medClinic.getName(), office.getCity()));
            model.addAttribute("city", office.getCity());
        } else {
            model.addAttribute("medClinicName", medClinic.getName());
            model.addAttribute("providers", medClinicService.getProvidersOffice(medClinic.getName(), office.getCity(), office.getStreet()));
            model.addAttribute("city", office.getCity());
            System.out.println((office.getCity()));
            model.addAttribute("street", office.getStreet());
        }
        return model;
    }
}
