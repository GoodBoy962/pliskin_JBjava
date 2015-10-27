package com.pliskin.repository;

import java.util.List;

/**
 * Created by aleksandrpliskin on 18.10.15.
 */
public interface ProviderRepository {

    List<String> findByMedClinicOfficeStreetAndCity(String name, String city, String street);

}
