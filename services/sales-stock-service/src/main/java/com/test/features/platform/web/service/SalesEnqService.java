/*
 * Copyright (c) 2020-2021 Innominds inc. All Rights Reserved. This software is
 * confidential and proprietary information of Innominds inc. You shall not disclose
 * Confidential Information and shall use it only in accordance with the terms
 *
 */
package com.test.features.platform.web.service;

import com.test.commons.data.utils.PageUtils;
import com.test.commons.instrumentation.Instrument;
import com.test.features.platform.data.mapper.SalesEnqMapper;
import com.test.features.platform.data.model.experience.salesenq.CreateSalesEnqRequest;
import com.test.features.platform.data.model.experience.salesenq.SalesEnq;
import com.test.features.platform.data.model.experience.salesenq.UpdateSalesEnqRequest;
import com.test.features.platform.data.model.persistence.SalesEnqEntity;
import com.test.features.platform.data.repository.SalesEnqRepository;
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
 * entities of type {@link SalesEnqEntity}.
 *
 * @author Admin
 */
@Slf4j
@Validated
@Service
public class SalesEnqService {
    /** Repository implementation of type {@link SalesEnqRepository}. */
    private final SalesEnqRepository salesEnqRepository;

    /**
     * Mapper implementation of type {@link SalesEnqMapper} to transform between different types.
     */
    private final SalesEnqMapper salesEnqMapper;

    /**
     * Constructor.
     *
     * @param salesEnqRepository Repository instance of type {@link SalesEnqRepository}.
     * @param salesEnqMapper Mapper instance of type {@link SalesEnqMapper}.
     */
    public SalesEnqService(
            final SalesEnqRepository salesEnqRepository, final SalesEnqMapper salesEnqMapper) {
        this.salesEnqRepository = salesEnqRepository;
        this.salesEnqMapper = salesEnqMapper;
    }

    /**
     * This method attempts to create an instance of type {@link SalesEnqEntity} in the system based
     * on the provided payload.
     *
     * @param payload Payload containing the details required to create an instance of type {@link
     *     SalesEnqEntity}.
     * @return An experience model of type {@link SalesEnq} that represents the newly created entity
     *     of type {@link SalesEnqEntity}.
     */
    @Instrument
    @Transactional
    public SalesEnq createSalesEnq(@Valid final CreateSalesEnqRequest payload) {
        // 1. Transform the experience model to a persistence model.
        final SalesEnqEntity salesEnqEntity = salesEnqMapper.transform(payload);

        // 2. Save the entity.
        SalesEnqService.LOGGER.debug("Saving a new instance of type - SalesEnqEntity");
        final SalesEnqEntity newInstance = salesEnqRepository.save(salesEnqEntity);

        // 3. Transform the created entity to an experience model and return it.
        return salesEnqMapper.transform(newInstance);
    }

    /**
     * This method attempts to update an existing instance of type {@link SalesEnqEntity} using the
     * details from the provided input, which is an instance of type {@link UpdateSalesEnqRequest}.
     *
     * @param salesEnqId Unique identifier of SalesEnq in the system, which needs to be updated.
     * @param payload Request payload containing the details of an existing SalesEnq, which needs to
     *     be updated in the system.
     * @return A instance of type {@link SalesEnq} containing the updated details.
     */
    @Instrument
    @Transactional
    public SalesEnq updateSalesEnq(
            final Integer salesEnqId, @Valid final UpdateSalesEnqRequest payload) {
        // 1. Verify that the entity being updated truly exists.
        final SalesEnqEntity matchingInstance = salesEnqRepository.findByIdOrThrow(salesEnqId);

        // 2. Transform the experience model to a persistence model and delegate to the save()
        // method.
        salesEnqMapper.transform(payload, matchingInstance);

        // 3. Save the entity
        SalesEnqService.LOGGER.debug("Saving the updated entity - SalesEnqEntity");
        final SalesEnqEntity updatedInstance = salesEnqRepository.save(matchingInstance);

        // 4. Transform updated entity to output object
        return salesEnqMapper.transform(updatedInstance);
    }

    /**
     * This method attempts to find a {@link SalesEnqEntity} whose unique identifier matches the
     * provided identifier.
     *
     * @param salesEnqId Unique identifier of SalesEnq in the system, whose details have to be
     *     retrieved.
     * @return Matching entity of type {@link SalesEnq} if found, else returns null.
     */
    @Instrument
    @Transactional(readOnly = true)
    public SalesEnq findSalesEnq(final Integer salesEnqId) {
        // 1. Find a matching entity and throw an exception if not found.
        final SalesEnqEntity matchingInstance = salesEnqRepository.findByIdOrThrow(salesEnqId);

        // 2. Transform the matching entity to the desired output.
        return salesEnqMapper.transform(matchingInstance);
    }

    /**
     * This method attempts to find instances of type SalesEnqEntity based on the provided page
     * definition. If the page definition is null or contains invalid values, this method attempts
     * to return the data for the first page (i.e. page index is 0) with a default page size as 20.
     *
     * @return Returns a page of objects based on the provided page definition. Each object in the
     *     returned page is an instance of type {@link SalesEnq}.
     */
    @Instrument
    @Transactional(readOnly = true)
    public Page<SalesEnq> findAllSalesEnqs(final Pageable page) {
        // 1. Validate the provided pagination settings.
        final Pageable pageSettings = PageUtils.validateAndUpdatePaginationConfiguration(page);
        SalesEnqService.LOGGER.debug(
                "Page settings: page number {}, page size {}",
                pageSettings.getPageNumber(),
                pageSettings.getPageSize());

        // 2. Delegate to the super class method to find the data (page settings are verified in
        // that method).
        final Page<SalesEnqEntity> pageData = salesEnqRepository.findAll(pageSettings);

        // 3. If the page has data, transform each element into target type.
        if (pageData.hasContent()) {
            final List<SalesEnq> dataToReturn =
                    pageData.getContent().stream()
                            .map(salesEnqMapper::transform)
                            .collect(Collectors.toList());

            return PageUtils.createPage(dataToReturn, pageSettings, pageData.getTotalElements());
        }

        // Return empty page.
        return PageUtils.emptyPage(pageSettings);
    }

    /**
     * This method attempts to delete an existing instance of type {@link SalesEnqEntity} whose
     * unique identifier matches the provided identifier.
     *
     * @param salesEnqId Unique identifier of SalesEnq in the system, which needs to be deleted.
     * @return Unique identifier of the instance of type SalesEnqEntity that was deleted.
     */
    @Instrument
    @Transactional
    public Integer deleteSalesEnq(final Integer salesEnqId) {
        // 1. Delegate to our repository method to handle the deletion.
        return salesEnqRepository.deleteOne(salesEnqId);
    }
}
