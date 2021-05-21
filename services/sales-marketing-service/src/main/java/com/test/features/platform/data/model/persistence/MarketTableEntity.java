/*
 * Copyright (c) 2020-2021 Innominds inc. All Rights Reserved. This software is
 * confidential and proprietary information of Innominds inc. You shall not disclose
 * Confidential Information and shall use it only in accordance with the terms
 *
 */
package com.test.features.platform.data.model.persistence;

import com.test.commons.data.jpa.persistence.AbstractIdGeneratedEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Implementation that maps the "market_table" table in the database to an entity in the ORM world.
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
@Table(name = "market_table")
@Entity
public class MarketTableEntity extends AbstractIdGeneratedEntity<Integer> {

    /** Reference to the name. */
    @Column(name = "name")
    private Integer name;
}
