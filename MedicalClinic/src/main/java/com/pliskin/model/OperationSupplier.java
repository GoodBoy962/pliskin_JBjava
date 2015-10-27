package com.pliskin.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by aleksandrpliskin on 17.10.15.
 */
@Entity
@Table(name = "operation_supplier")
public class OperationSupplier {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "begin_date", nullable = false)
    private Date beginDate;

    @Column(name = "end_date")
    private Date endDate;

    @JoinColumn(name = "office_id")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Office officeId;

    @Column(name = "count", nullable = false)
    private Integer count;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id", nullable = false)
    private Provider provider;

    public OperationSupplier() {
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public OperationSupplier(Date beginDate, Date endDate, Office officeId, Integer count, Provider provider) {

        this.beginDate = beginDate;
        this.endDate = endDate;
        this.officeId = officeId;
        this.count = count;
        this.provider = provider;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Office getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Office officeId) {
        this.officeId = officeId;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }
}
