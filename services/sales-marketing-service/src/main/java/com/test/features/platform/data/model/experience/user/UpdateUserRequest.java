/*
 * Copyright (c) 2020-2021 Innominds inc. All Rights Reserved. This software is
 * confidential and proprietary information of Innominds inc. You shall not disclose
 * Confidential Information and shall use it only in accordance with the terms
 *
 */
package com.test.features.platform.data.model.experience.user;

import java.util.Collection;
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
public class UpdateUserRequest {
    /** Reference to the roles. */
    @NotNull(message = "user.roles.not.null.message")
    private Collection<String> roles;

    /** Reference to the deleted_ts. */
    private Integer deletedTs;

    /** Reference to the id. */
    @NotNull(message = "user.id.not.null.message")
    private Integer id;

    /** Reference to the username. */
    @NotBlank(message = "user.username.not.blank.message")
    private String username;

    /** Reference to the deleted. */
    private Boolean deleted;

    /** Reference to the password. */
    @NotBlank(message = "user.password.not.blank.message")
    private String password;
}
