/*
 * Copyright (c) 2020-2021 Innominds inc. All Rights Reserved. This software is
 * confidential and proprietary information of Innominds inc. You shall not disclose
 * Confidential Information and shall use it only in accordance with the terms
 *
 */
package com.test.features.platform.data.model.experience.salesenq;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Implementation of an experience model that is meant to be used by the API Layer for communication
 * either with the front-end or to the service-layer.
 *
 * @author Admin
 */
@Data
@SuperBuilder
@NoArgsConstructor
public class SalesEnq {
    /** Reference to the secondary_vol. */
    private Double secondaryVol;

    /** Reference to the project. */
    private String project;

    /** Reference to the rfq_date. */
    private Date rfqDate;

    /** Reference to the id. */
    private Integer id;

    /** Reference to the region. */
    private String region;

    /** Reference to the customer. */
    private String customer;

    /** Reference to the sales_man. */
    private String salesMan;

    /** Reference to the rating. */
    private Double rating;

    /** Reference to the primary_vol. */
    private Double primaryVol;

    /** Reference to the quantity. */
    private Integer quantity;

    /** Reference to the epc_ind_ren_utl. */
    private String epcIndRenUtl;
}
