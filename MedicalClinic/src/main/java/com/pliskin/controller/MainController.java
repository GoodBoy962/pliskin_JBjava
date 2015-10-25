package com.pliskin.controller;

import com.pliskin.model.*;
import com.pliskin.service.MedClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by aleksandrpliskin on 17.10.15.
 */
@Controller
public class MainController {

    @Autowired
    MedClinicService medClinicService;

    @RequestMapping("/main")
    public String getMainPage() {
        return "main";
    }

    @RequestMapping(value = "/average_salary")
    public String getFormForAverageSalary(Model model) {
        List<String> medClinicNames = medClinicService.getMedClinicNames();
        model.addAttribute("medClinicNames", medClinicNames);
        return "average-salary";
    }

    @RequestMapping(value = "/average_salary_result")
    public String getAverageSalaryOfEmployeesOfCurrentMedClinic(
            @ModelAttribute MedClinic medClinic,
            Model model
    ) {
        model.addAttribute("averageSalary", medClinicService.getAverageSalaryOfEmployeesOfCurrentMedClinic(medClinic.getName()).doubleValue());
        model.addAttribute("stuffList", medClinicService.getStuffFioOfCurrentMedClinic(medClinic.getName()));
        return "average-salary-result";
    }

    @RequestMapping(value = "/average_salary/employee_salary")
    public String getSalaryOfCurrentEmployee(
            @ModelAttribute MedClinic medClinic,
            @ModelAttribute People people,
            Model model
    ) {
        model.addAttribute("salaryOfCurrentEmployee", medClinicService.getSalaryOfCurrentEmployee(medClinic.getName(), people.getFio()));
        model.addAttribute("employmentDate", medClinicService.getEmplymentDate(medClinic.getName(), people.getFio()));
        model.addAttribute("dismissalDate", medClinicService.getDismissalDate(medClinic.getName(), people.getFio()));
        model.addAttribute("fio", people.getFio());
        return "employee-salary";
    }

    @RequestMapping("/average_cheque")
    public String gerFormForAverageCheque(Model model) {
        List<String> medClinicNames = medClinicService.getMedClinicNames();
        model.addAttribute("medClinicNames", medClinicNames);
        return "average-cheque";
    }

    @RequestMapping("/average_cheque_result")
    public String getAverageChequeInMedClinic(
            @ModelAttribute MedClinic medClinic,
            @ModelAttribute Office office,
            Model model
    ) {
        if (office.getCity() == null) {
            model.addAttribute("cities", medClinicService.getMedClinicCities(medClinic.getName()));
        } else if (office.getStreet() == null) {
            model.addAttribute("streets", medClinicService.getStreetsOfOfficeInCityOfMedClinic(medClinic.getName(), office.getCity()));
            model.addAttribute("city", office.getCity());
        }
        model.addAttribute("medClinic", medClinic);
        model.addAttribute("averageChequeInMedClinic", medClinicService.getAverageChequeInMedClinic(medClinic.getName()).intValue());
        return "average-cheque-result";
    }

    @RequestMapping("/average_cheque/current_office")
    public String getAverageChequeInCurrentOffice(
            @ModelAttribute MedClinic medClinic,
            @ModelAttribute Office office,
            Model model
    ) {
        BigDecimal averageChequeInCurrentOffice = medClinicService.getAverageChequeInCurrentOffice(medClinic.getName(), office.getCity(), office.getStreet());
        if (averageChequeInCurrentOffice == null) {
            model.addAttribute("averageChequeInCurrentOfficeError", "неправильный адрес офиса");
            return "average-cheque-result";
        }
        model.addAttribute("averageChequeInCurrentOffice", medClinicService.getAverageChequeInCurrentOffice(medClinic.getName(), office.getCity(), office.getStreet()).doubleValue());
        return "current-office";
    }

    @RequestMapping("/goods_info")
    public String getInfoAboutSendingGoods(
            @ModelAttribute Provider provider,
            @ModelAttribute Office office,
            @ModelAttribute MedClinic medClinic,
            Model model
    ) {
        model.addAttribute("infoAboutSendingGoods", medClinicService.getInfoAboutSendingGoods(provider.getName(), medClinic.getName(), office.getCity(), office.getStreet()));
        return "goods-info";
    }

    @RequestMapping("/profitability")
    public String getProfitPage() {
        return "profitability";
    }

    @RequestMapping("/profitability/company")
    public String getTheMostProfitableCompany(Model model) {
        model.addAttribute("theMostProfitableCompany", medClinicService.getTheMostProfitableCompany());
        return "profitability-page";
    }

    @RequestMapping("/profitability/office_prof")
    public String getTheMostProfitableOffice(
            @ModelAttribute MedClinic medClinic,
            Model model) {
        Integer id = medClinicService.getTheMostProfitableOffice();
        model.addAttribute("theMostProfitableOfficeMedClinic", medClinicService.getOfficeMedClinic(id));
        model.addAttribute("theMostProfitableOfficeCity", medClinicService.getOfficeCity(id));
        model.addAttribute("theMostProfitableOfficeStreet", medClinicService.getOfficeStreet(id));
        return "office-prof";
    }
}
