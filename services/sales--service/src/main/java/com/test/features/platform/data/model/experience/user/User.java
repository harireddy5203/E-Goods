/*
 * Copyright (c) 2020-2021 Innominds inc. All Rights Reserved. This software is
 * confidential and proprietary information of Innominds inc. You shall not disclose
 * Confidential Information and shall use it only in accordance with the terms
 *
 */
package com.test.features.platform.data.model.experience.user;

import com.test.features.platform.data.model.experience.role.Role;
import java.util.Collection;
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
public class User {
    /** Reference to the roles. */
    private Collection<Role> roles;

    /** Reference to the deleted_ts. */
    private Integer deletedTs;

    /** Reference to the id. */
    private Integer id;

    /** Reference to the username. */
    private String username;

    /** Reference to the deleted. */
    private Boolean deleted;

    /** Reference to the password. */
    private String password;
}
