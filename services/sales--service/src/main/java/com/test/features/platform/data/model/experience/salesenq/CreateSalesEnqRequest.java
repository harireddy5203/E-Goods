/*
 * Copyright (c) 2020-2021 Innominds inc. All Rights Reserved. This software is
 * confidential and proprietary information of Innominds inc. You shall not disclose
 * Confidential Information and shall use it only in accordance with the terms
 *
 */
package com.test.features.platform.data.model.experience.salesenq;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class CreateSalesEnqRequest {
    /** Reference to the secondary_vol. */
    @NotNull(message = "sales.enq.secondaryVol.not.null.message")
    private Double secondaryVol;

    /** Reference to the project. */
    private String project;

    /** Reference to the rfq_date. */
    @NotNull(message = "sales.enq.rfqDate.not.null.message")
    private Date rfqDate;

    /** Reference to the region. */
    @NotBlank(message = "sales.enq.region.not.blank.message")
    private String region;

    /** Reference to the customer. */
    @NotBlank(message = "sales.enq.customer.not.blank.message")
    private String customer;

    /** Reference to the sales_man. */
    @NotBlank(message = "sales.enq.salesMan.not.blank.message")
    private String salesMan;

    /** Reference to the rating. */
    @NotNull(message = "sales.enq.rating.not.null.message")
    private Double rating;

    /** Reference to the primary_vol. */
    @NotNull(message = "sales.enq.primaryVol.not.null.message")
    private Double primaryVol;

    /** Reference to the quantity. */
    @NotNull(message = "sales.enq.quantity.not.null.message")
    private Integer quantity;

    /** Reference to the epc_ind_ren_utl. */
    @NotBlank(message = "sales.enq.epcIndRenUtl.not.blank.message")
    private String epcIndRenUtl;
}
