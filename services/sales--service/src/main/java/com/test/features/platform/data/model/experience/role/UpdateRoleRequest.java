/*
 * Copyright (c) 2020-2021 Innominds inc. All Rights Reserved. This software is
 * confidential and proprietary information of Innominds inc. You shall not disclose
 * Confidential Information and shall use it only in accordance with the terms
 *
 */
package com.test.features.platform.data.model.experience.role;

import javax.validation.constraints.NotBlank;
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
public class UpdateRoleRequest {
    /** Reference to the description. */
    private String description;

    /** Reference to the deleted_ts. */
    private Integer deletedTs;

    /** Reference to the name. */
    @NotBlank(message = "role.name.not.blank.message")
    private String name;

    /** Reference to the id. */
    @NotBlank(message = "role.id.not.blank.message")
    private String id;

    /** Reference to the deleted. */
    private Boolean deleted;
}
