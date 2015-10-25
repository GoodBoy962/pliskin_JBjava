package com.pliskin.repository;

import org.springframework.stereotype.Repository;

/**
 * Created by aleksandrpliskin on 18.10.15.
 */
@Repository
public interface OperationSupplierRepository {

    Boolean wasSomethindSend(String providerName, String name, String city, String street);

}
