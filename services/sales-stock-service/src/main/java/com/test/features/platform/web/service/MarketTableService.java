/*
 * Copyright (c) 2020-2021 Innominds inc. All Rights Reserved. This software is
 * confidential and proprietary information of Innominds inc. You shall not disclose
 * Confidential Information and shall use it only in accordance with the terms
 *
 */
package com.test.features.platform.web.service;

import com.test.commons.data.utils.PageUtils;
import com.test.commons.instrumentation.Instrument;
import com.test.features.platform.data.mapper.MarketTableMapper;
import com.test.features.platform.data.model.experience.markettable.CreateMarketTableRequest;
import com.test.features.platform.data.model.experience.markettable.MarketTable;
import com.test.features.platform.data.model.experience.markettable.UpdateMarketTableRequest;
import com.test.features.platform.data.model.persistence.MarketTableEntity;
import com.test.features.platform.data.repository.MarketTableRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * Service implementation that provides CRUD (Create, Read, Update, Delete) capabilities for
 * entities of type {@link MarketTableEntity}.
 *
 * @author Admin
 */
@Slf4j
@Validated
@Service
public class MarketTableService {
    /** Repository implementation of type {@link MarketTableRepository}. */
    private final MarketTableRepository marketTableRepository;

    /**
     * Mapper implementation of type {@link MarketTableMapper} to transform between different types.
     */
    private final MarketTableMapper marketTableMapper;

    /**
     * Constructor.
     *
     * @param marketTableRepository Repository instance of type {@link MarketTableRepository}.
     * @param marketTableMapper Mapper instance of type {@link MarketTableMapper}.
     */
    public MarketTableService(
            final MarketTableRepository marketTableRepository,
            final MarketTableMapper marketTableMapper) {
        this.marketTableRepository = marketTableRepository;
        this.marketTableMapper = marketTableMapper;
    }

    /**
     * This method attempts to create an instance of type {@link MarketTableEntity} in the system
     * based on the provided payload.
     *
     * @param payload Payload containing the details required to create an instance of type {@link
     *     MarketTableEntity}.
     * @return An experience model of type {@link MarketTable} that represents the newly created
     *     entity of type {@link MarketTableEntity}.
     */
    @Instrument
    @Transactional
    public MarketTable createMarketTable(@Valid final CreateMarketTableRequest payload) {
        // 1. Transform the experience model to a persistence model.
        final MarketTableEntity marketTableEntity = marketTableMapper.transform(payload);

        // 2. Save the entity.
        MarketTableService.LOGGER.debug("Saving a new instance of type - MarketTableEntity");
        final MarketTableEntity newInstance = marketTableRepository.save(marketTableEntity);

        // 3. Transform the created entity to an experience model and return it.
        return marketTableMapper.transform(newInstance);
    }

    /**
     * This method attempts to update an existing instance of type {@link MarketTableEntity} using
     * the details from the provided input, which is an instance of type {@link
     * UpdateMarketTableRequest}.
     *
     * @param marketTableId Unique identifier of MarketTable in the system, which needs to be
     *     updated.
     * @param payload Request payload containing the details of an existing MarketTable, which needs
     *     to be updated in the system.
     * @return A instance of type {@link MarketTable} containing the updated details.
     */
    @Instrument
    @Transactional
    public MarketTable updateMarketTable(
            final Integer marketTableId, @Valid final UpdateMarketTableRequest payload) {
        // 1. Verify that the entity being updated truly exists.
        final MarketTableEntity matchingInstance =
                marketTableRepository.findByIdOrThrow(marketTableId);

        // 2. Transform the experience model to a persistence model and delegate to the save()
        // method.
        marketTableMapper.transform(payload, matchingInstance);

        // 3. Save the entity
        MarketTableService.LOGGER.debug("Saving the updated entity - MarketTableEntity");
        final MarketTableEntity updatedInstance = marketTableRepository.save(matchingInstance);

        // 4. Transform updated entity to output object
        return marketTableMapper.transform(updatedInstance);
    }

    /**
     * This method attempts to find a {@link MarketTableEntity} whose unique identifier matches the
     * provided identifier.
     *
     * @param marketTableId Unique identifier of MarketTable in the system, whose details have to be
     *     retrieved.
     * @return Matching entity of type {@link MarketTable} if found, else returns null.
     */
    @Instrument
    @Transactional(readOnly = true)
    public MarketTable findMarketTable(final Integer marketTableId) {
        // 1. Find a matching entity and throw an exception if not found.
        final MarketTableEntity matchingInstance =
                marketTableRepository.findByIdOrThrow(marketTableId);

        // 2. Transform the matching entity to the desired output.
        return marketTableMapper.transform(matchingInstance);
    }

    /**
     * This method attempts to find instances of type MarketTableEntity based on the provided page
     * definition. If the page definition is null or contains invalid values, this method attempts
     * to return the data for the first page (i.e. page index is 0) with a default page size as 20.
     *
     * @return Returns a page of objects based on the provided page definition. Each object in the
     *     returned page is an instance of type {@link MarketTable}.
     */
    @Instrument
    @Transactional(readOnly = true)
    public Page<MarketTable> findAllMarketTables(final Pageable page) {
        // 1. Validate the provided pagination settings.
        final Pageable pageSettings = PageUtils.validateAndUpdatePaginationConfiguration(page);
        MarketTableService.LOGGER.debug(
                "Page settings: page number {}, page size {}",
                pageSettings.getPageNumber(),
                pageSettings.getPageSize());

        // 2. Delegate to the super class method to find the data (page settings are verified in
        // that method).
        final Page<MarketTableEntity> pageData = marketTableRepository.findAll(pageSettings);

        // 3. If the page has data, transform each element into target type.
        if (pageData.hasContent()) {
            final List<MarketTable> dataToReturn =
                    pageData.getContent().stream()
                            .map(marketTableMapper::transform)
                            .collect(Collectors.toList());

            return PageUtils.createPage(dataToReturn, pageSettings, pageData.getTotalElements());
        }

        // Return empty page.
        return PageUtils.emptyPage(pageSettings);
    }

    /**
     * This method attempts to delete an existing instance of type {@link MarketTableEntity} whose
     * unique identifier matches the provided identifier.
     *
     * @param marketTableId Unique identifier of MarketTable in the system, which needs to be
     *     deleted.
     * @return Unique identifier of the instance of type MarketTableEntity that was deleted.
     */
    @Instrument
    @Transactional
    public Integer deleteMarketTable(final Integer marketTableId) {
        // 1. Delegate to our repository method to handle the deletion.
        return marketTableRepository.deleteOne(marketTableId);
    }
}
