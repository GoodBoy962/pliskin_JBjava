package com.pliskin.repository;

import java.math.BigDecimal;

/**
 * Created by aleksandrpliskin on 14.10.15.
 */
public interface ScoresRepository {
    public Integer getTotal(Integer id);

    public BigDecimal getAverage(Integer id);

    public Integer getCurrentSubject(Integer id, String subject);
}
