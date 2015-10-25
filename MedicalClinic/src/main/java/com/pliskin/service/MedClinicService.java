package com.pliskin.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by aleksandrpliskin on 18.10.15.
 */
public interface MedClinicService {

    BigDecimal getAverageSalaryOfEmployeesOfCurrentMedClinic(String name);

    Integer getSalaryOfCurrentEmployee(String name, String fio);

    BigDecimal getAverageChequeInMedClinic(String name);

    BigDecimal getAverageChequeInCurrentOffice(String name, String city, String street);

    Boolean getInfoAboutSendingGoods(String providerName, String name, String city, String street);

    String getTheMostProfitableCompany();

    Integer getTheMostProfitableOffice();

    String getOfficeStreet(Integer id);

    String getOfficeCity(Integer id);

    String getOfficeMedClinic(Integer id);

    List<String> getMedClinicNames();

    List<String> getStuffFioOfCurrentMedClinic(String name);

    Date getEmplymentDate(String name, String fio);

    Date getDismissalDate(String name, String fio);

    List<String> getMedClinicCities(String name);

    List<String> getStreetsOfOfficeInCityOfMedClinic(String name, String city);

    List<String> getProvidersOffice(String name, String city, String street);

    List<String> goodsInfo(String name, String city, String street, String providerName);

}
