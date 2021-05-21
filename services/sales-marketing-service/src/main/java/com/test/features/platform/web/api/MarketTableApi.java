/*
 * Copyright (c) 2020-2021 Innominds inc. All Rights Reserved. This software is
 * confidential and proprietary information of Innominds inc. You shall not disclose
 * Confidential Information and shall use it only in accordance with the terms
 *
 */
package com.test.features.platform.web.api;

import com.test.commons.data.utils.PageUtils;
import com.test.commons.web.api.AbstractApi;
import com.test.commons.web.configuration.properties.ApiDocumentationSettings;
import com.test.features.platform.data.model.experience.markettable.CreateMarketTableRequest;
import com.test.features.platform.data.model.experience.markettable.MarketTable;
import com.test.features.platform.data.model.experience.markettable.UpdateMarketTableRequest;
import com.test.features.platform.web.service.MarketTableService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation of APIs that provide CRUD (Create, Read, Update and Delete) functionality for
 * persistence models of type {@link
 * com.test.features.platform.data.model.persistence.MarketTableEntity}.
 *
 * @author Admin
 */
@Slf4j
@RestController
@RequestMapping(MarketTableApi.rootEndPoint)
public class MarketTableApi extends AbstractApi {
    /** Tag for this API. */
    public static final String API_TAG = "MarketTables";

    /** Root end point. */
    public static final String rootEndPoint = "/sales-marketing";

    /** Service implementation of type {@link MarketTableService}. */
    private final MarketTableService marketTableService;

    /**
     * Constructor.
     *
     * @param marketTableService Service instance of type {@link MarketTableService}.
     */
    public MarketTableApi(final MarketTableService marketTableService) {
        this.marketTableService = marketTableService;
    }

    /**
     * This API provides the capability to add a new instance of type {@link
     * com.test.features.platform.data.model.persistence.MarketTableEntity} into the system.
     *
     * @param payload Payload containing the details required to create an instance of type {@link
     *     com.test.features.platform.data.model.persistence.MarketTableEntity}.
     * @return Response of type {@link ResponseEntity} that wraps an instance of type {@link
     *     MarketTable}.
     */
    @Operation(
            method = "createMarketTable",
            summary = "Create a new MarketTable.",
            description = "This API is used to create a new MarketTable in the system.",
            tags = {MarketTableApi.API_TAG},
            security = {
                @SecurityRequirement(
                        name =
                                ApiDocumentationSettings.ApiSecurityScheme
                                        .DEFAULT_SECURITY_SCHEME_NAME)
            })
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "201",
                        description = "Successfully created a new MarketTable in the system.",
                        content = @Content),
                @ApiResponse(
                        responseCode = "403",
                        description = "You do not have permissions to perform this operation.",
                        content = @Content)
            })
    @PreAuthorize(value = "isAuthenticated()")
    @PostMapping(value = "/marketTables")
    public ResponseEntity<MarketTable> createMarketTable(
            @Valid @RequestBody final CreateMarketTableRequest payload) {
        // Delegate to the service layer.
        final MarketTable newInstance = marketTableService.createMarketTable(payload);

        // Build a response entity object and return it.
        return ResponseEntity.status(HttpStatus.CREATED).body(newInstance);
    }

    /**
     * This API provides the capability to update an existing instance of type {@link
     * com.test.features.platform.data.model.persistence.MarketTableEntity} in the system.
     *
     * @param marketTableId Unique identifier of MarketTable in the system, which needs to be
     *     updated.
     * @param payload Request payload containing the details of an existing MarketTable, which needs
     *     to be updated in the system.
     * @return Response of type {@link ResponseEntity} that wraps an instance of type {@link
     *     MarketTable}.
     */
    @Operation(
            method = "updateMarketTable",
            summary = "Update an existing MarketTable.",
            description = "This API is used to update an existing MarketTable in the system.",
            tags = {MarketTableApi.API_TAG},
            security = {
                @SecurityRequirement(
                        name =
                                ApiDocumentationSettings.ApiSecurityScheme
                                        .DEFAULT_SECURITY_SCHEME_NAME)
            })
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Successfully updated an existing MarketTable in the system.",
                        content = @Content),
                @ApiResponse(
                        responseCode = "403",
                        description = "You do not have permissions to perform this operation.",
                        content = @Content)
            })
    @PreAuthorize(value = "isAuthenticated()")
    @PutMapping(value = "/marketTables/{marketTableId}")
    public ResponseEntity<MarketTable> updateMarketTable(
            @PathVariable(name = "marketTableId") final Integer marketTableId,
            @Valid @RequestBody final UpdateMarketTableRequest payload) {
        // Delegate to the service layer.
        final MarketTable updatedInstance =
                marketTableService.updateMarketTable(marketTableId, payload);

        // Build a response entity object and return it.
        return ResponseEntity.ok(updatedInstance);
    }

    /**
     * This API provides the capability to retrieve the details of an existing {@link
     * com.test.features.platform.data.model.persistence.MarketTableEntity} in the system.
     *
     * @param marketTableId Unique identifier of MarketTable in the system, whose details have to be
     *     retrieved.
     * @return Response of type {@link ResponseEntity} that wraps an instance of type {@link
     *     MarketTable}.
     */
    @Operation(
            method = "findMarketTable",
            summary = "Find an existing MarketTable.",
            description = "This API is used to find an existing MarketTable in the system.",
            tags = {MarketTableApi.API_TAG},
            security = {
                @SecurityRequirement(
                        name =
                                ApiDocumentationSettings.ApiSecurityScheme
                                        .DEFAULT_SECURITY_SCHEME_NAME)
            })
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description =
                                "Successfully retrieved the details of an existing MarketTable in the system.",
                        content = @Content),
                @ApiResponse(
                        responseCode = "403",
                        description = "You do not have permissions to perform this operation.",
                        content = @Content)
            })
    @PreAuthorize(value = "isAuthenticated()")
    @GetMapping(value = "/marketTables/{marketTableId}")
    public ResponseEntity<MarketTable> findMarketTable(
            @PathVariable(name = "marketTableId") final Integer marketTableId) {
        // Delegate to the service layer.
        final MarketTable matchingInstance = marketTableService.findMarketTable(marketTableId);

        // Build a response entity object and return it.
        return ResponseEntity.ok(matchingInstance);
    }

    /**
     * This API provides the capability to retrieve all instances of type {@link
     * com.test.features.platform.data.model.persistence.MarketTableEntity} in the system in a
     * paginated manner.
     *
     * @param page Page number.
     * @param size Page size.
     * @return Response of type {@link ResponseEntity} that holds a page of instances of type
     *     MarketTable based on the provided pagination settings.
     */
    @Operation(
            method = "findAllMarketTables",
            summary = "Find all MarketTables.",
            description = "This API is used to find all MarketTables in the system.",
            tags = {MarketTableApi.API_TAG},
            security = {
                @SecurityRequirement(
                        name =
                                ApiDocumentationSettings.ApiSecurityScheme
                                        .DEFAULT_SECURITY_SCHEME_NAME)
            })
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description =
                                "Successfully retrieved the MarketTables in the system based on the provided pagination settings.",
                        content = @Content),
                @ApiResponse(
                        responseCode = "403",
                        description = "You do not have permissions to perform this operation.",
                        content = @Content)
            })
    @PreAuthorize(value = "isAuthenticated()")
    @GetMapping(value = "/marketTables")
    public ResponseEntity<Page<MarketTable>> findAllMarketTables(
            @RequestParam(name = "page", required = false, defaultValue = "0") final Integer page,
            @RequestParam(name = "size", required = false, defaultValue = "20")
                    final Integer size) {
        // Delegate to the service layer.
        final Pageable pageSettings = PageUtils.createPaginationConfiguration(page, size);
        final Page<MarketTable> matchingInstances =
                marketTableService.findAllMarketTables(pageSettings);

        // Build a response entity object and return it.
        return ResponseEntity.ok(matchingInstances);
    }

    /**
     * This API provides the capability to delete an existing instance of type {@link
     * com.test.features.platform.data.model.persistence.MarketTableEntity} in the system.
     *
     * @param marketTableId Unique identifier of MarketTable in the system, which needs to be
     *     deleted.
     * @return Response of type {@link ResponseEntity} that holds the unique identifier of the
     *     {@link com.test.features.platform.data.model.persistence.MarketTableEntity} that was
     *     deleted from the system.
     */
    @Operation(
            method = "deleteMarketTable",
            summary = "Delete an existing MarketTable.",
            description = "This API is used to delete an existing MarketTable in the system.",
            tags = {MarketTableApi.API_TAG},
            security = {
                @SecurityRequirement(
                        name =
                                ApiDocumentationSettings.ApiSecurityScheme
                                        .DEFAULT_SECURITY_SCHEME_NAME)
            })
    @ApiResponses(
            value = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Successfully deleted an existing MarketTable in the system.",
                        content = @Content),
                @ApiResponse(
                        responseCode = "403",
                        description = "You do not have permissions to perform this operation.",
                        content = @Content)
            })
    @PreAuthorize(value = "isAuthenticated()")
    @DeleteMapping(value = "/marketTables/{marketTableId}")
    public ResponseEntity<Integer> deleteMarketTable(
            @PathVariable(name = "marketTableId") final Integer marketTableId) {
        // Delegate to the service layer.
        final Integer deletedInstance = marketTableService.deleteMarketTable(marketTableId);

        // Build a response entity object and return it.
        return ResponseEntity.ok(deletedInstance);
    }
}
