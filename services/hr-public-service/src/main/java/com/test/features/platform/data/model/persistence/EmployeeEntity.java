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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Implementation that maps the "employee" table in the database to an entity in the ORM world.
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
@Table(name = "employee")
@Entity
public class EmployeeEntity extends AbstractIdGeneratedEntity<Integer> {

    /** Reference to the first_name. */
    @Column(name = "first_name", nullable = false)
    private String firstName;

    /** Reference to the last_name. */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /** Reference to the dob. */
    @Column(name = "dob", nullable = false)
    private Date dob;

    /** Reference to the joining_date. */
    @Column(name = "joining_date", nullable = false)
    private Date joiningDate;

    /** Reference to the dept. */
    @ManyToOne(optional = false)
    @JoinColumn(name = "dept", referencedColumnName = "id", nullable = false)
    private DeptEntity dept;
}
