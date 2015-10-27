package com.pliskin.repository;

import java.util.List;

/**
 * Created by aleksandrpliskin on 18.10.15.
 */
public interface OperationSupplierRepository {

    List<String> whenWasSend(String providerName, String name, String city, String street);

}
