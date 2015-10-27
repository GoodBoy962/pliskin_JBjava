package com.pliskin.repository;

import com.pliskin.model.Office;
import com.pliskin.model.People;
import com.pliskin.model.enums.PeopleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by aleksandrpliskin on 18.10.15.
 */
@Repository
public interface PeopleRepository extends JpaRepository<Office, Integer> {

    People findByFioAndType(String fio, PeopleType type);

    List<People> findByOfficeAndType(Office office, PeopleType type);
}
