package com.pliskin.service.impl;

import com.pliskin.repository.*;
import com.pliskin.service.MedClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by aleksandrpliskin on 18.10.15.
 */
@Transactional(readOnly = true)
@Service
public class MedClinicServiceImpl implements MedClinicService {

    @Autowired
    private OfficeRepository officeRepository;

    @Autowired
    OperationSupplierRepository operationSupplierRepository;

    @Autowired
    private StuffDataRepository stuffDataRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private PatientDataRepository patientDataRepository;

    @Autowired
    private MedClinicRepository medClinicRepository;

    @Override
    public BigDecimal getAverageSalaryOfEmployeesOfCurrentMedClinic(String name) {
        BigDecimal averageSalary = stuffDataRepository.findByMedClinic(name);
        return averageSalary;
    }

    @Override
    public Integer getSalaryOfCurrentEmployee(String name, String fio) {
        return stuffDataRepository.findByMedClinicAndFio(name, fio);
    }

    @Override
    public BigDecimal getAverageChequeInMedClinic(String name) {
        return patientDataRepository.findByMedClinic(name);
    }

    @Override
    public BigDecimal getAverageChequeInCurrentOffice(String name, String city, String street) {
        return patientDataRepository.findByMedClinicAndOffice(name, city, street);
    }

    @Override
    public String getTheMostProfitableCompany() {
        return medClinicRepository.findTheBestMedClinic();
    }

    @Override
    public Integer getTheMostProfitableOffice() {
        return officeRepository.getTheMostProfitableOffice();
    }

    @Override
    public String getOfficeStreet(Integer id) {
        return officeRepository.getStreet(id);
    }

    @Override
    public String getOfficeCity(Integer id) {
        return officeRepository.getCity(id);
    }

    @Override
    public String getOfficeMedClinic(Integer id) {
        return officeRepository.getMedClinicId(id);
    }

    @Override
    public List<String> getMedClinicNames() {
        return medClinicRepository.getMedClinicNames();
    }

    @Override
    public List<String> getStuffFioOfCurrentMedClinic(String name) {
        return stuffDataRepository.getByMedClinicFios(name);
    }

    @Override
    public Date getEmplymentDate(String name, String fio) {
        return stuffDataRepository.getEmploymentDate(name, fio);
    }

    @Override
    public Date getDismissalDate(String name, String fio) {
        return stuffDataRepository.getDismissalDate(name, fio);
    }

    @Override
    public List<String> getMedClinicCities(String name) {
        return officeRepository.getAllCities(name);
    }

    @Override
    public List<String> getStreetsOfOfficeInCityOfMedClinic(String name, String city) {
        return officeRepository.getAllStreetInCityOfMedClinic(name, city);
    }

    @Override
    public List<String> getProvidersOffice(String name, String city, String street) {
        return providerRepository.findByMedClinicOfficeStreetAndCity(name, city, street);
    }

    @Override
    public List<String> goodsInfo(String name, String city, String street, String providerName) {
        return operationSupplierRepository.whenWasSend(providerName, name, city, street);
    }
}
