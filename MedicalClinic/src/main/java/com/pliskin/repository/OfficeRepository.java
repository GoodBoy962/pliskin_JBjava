package com.pliskin.repository;

import com.pliskin.model.MedClinic;
import com.pliskin.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by aleksandrpliskin on 18.10.15.
 */

public interface OfficeRepository {

    //public List<Office> findByCityAndStreet(String city, String street);

    List<Office> findByMedClinic(MedClinic medClinic);

    Integer getTheMostProfitableOffice();

    List<Integer> findAllId();

    String getMedClinicId(Integer id);

    String getStreet(Integer id);

    String getCity(Integer id);

    List<String> getAllCities(String name);

    List<String> getAllStreetInCityOfMedClinic(String name, String city);
}
