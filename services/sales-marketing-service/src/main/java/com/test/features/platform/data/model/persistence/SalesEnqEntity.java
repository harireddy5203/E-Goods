/*
 * Copyright (c) 2020-2021 Innominds inc. All Rights Reserved. This software is
 * confidential and proprietary information of Innominds inc. You shall not disclose
 * Confidential Information and shall use it only in accordance with the terms
 *
 */
package com.test.features.platform.data.model.persistence;

import com.test.commons.data.jpa.persistence.AbstractIdGeneratedEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Implementation that maps the "sales_enq" table in the database to an entity in the ORM world.
 *
 * @author Admin
 */
@EqualsAndHashCode(
        callSuper = true,
        of = {})
@ToString(
        callSuper = true,
        of = {})
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sales_enq")
@Entity
public class SalesEnqEntity extends AbstractIdGeneratedEntity<Integer> {

    /** Reference to the secondary_vol. */
    @Column(name = "secondary_vol", nullable = false)
    private Double secondaryVol;

    /** Reference to the project. */
    @Column(name = "project")
    private String project;

    /** Reference to the rfq_date. */
    @Column(name = "rfq_date", nullable = false)
    private Date rfqDate;

    /** Reference to the region. */
    @Column(name = "region", nullable = false)
    private String region;

    /** Reference to the customer. */
    @Column(name = "customer", nullable = false)
    private String customer;

    /** Reference to the sales_man. */
    @Column(name = "sales_man", nullable = false)
    private String salesMan;

    /** Reference to the rating. */
    @Column(name = "rating", nullable = false)
    private Double rating;

    /** Reference to the primary_vol. */
    @Column(name = "primary_vol", nullable = false)
    private Double primaryVol;

    /** Reference to the quantity. */
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    /** Reference to the epc_ind_ren_utl. */
    @Column(name = "epc_ind_ren_utl", nullable = false)
    private String epcIndRenUtl;
}
