/*
 * Copyright (c) 2020-2021 Innominds inc. All Rights Reserved. This software is
 * confidential and proprietary information of Innominds inc. You shall not disclose
 * Confidential Information and shall use it only in accordance with the terms
 *
 */
package com.test.features.platform.data.model.persistence;

import com.test.commons.data.jpa.persistence.AbstractIdGeneratedEntity;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Implementation that maps the "user" table in the database to an entity in the ORM world.
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
@Table(name = "user")
@Entity
public class UserEntity extends AbstractIdGeneratedEntity<Integer> {

    /** Reference to the roles. */
    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Collection<RoleEntity> roles;
    /** Reference to the deleted_ts. */
    @Column(name = "deleted_ts")
    private Integer deletedTs;

    /** Reference to the username. */
    @Column(name = "username", nullable = false)
    private String username;

    /** Reference to the deleted. */
    @Column(name = "deleted")
    private Boolean deleted;

    /** Reference to the password. */
    @Column(name = "password", nullable = false)
    private String password;
}
