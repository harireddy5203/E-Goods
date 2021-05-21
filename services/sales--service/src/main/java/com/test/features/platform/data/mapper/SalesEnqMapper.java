/*
 * Copyright (c) 2020-2021 Innominds inc. All Rights Reserved. This software is
 * confidential and proprietary information of Innominds inc. You shall not disclose
 * Confidential Information and shall use it only in accordance with the terms
 *
 */
package com.test.features.platform.data.mapper;

import com.test.features.platform.data.model.experience.salesenq.CreateSalesEnqRequest;
import com.test.features.platform.data.model.experience.salesenq.SalesEnq;
import com.test.features.platform.data.model.experience.salesenq.UpdateSalesEnqRequest;
import com.test.features.platform.data.model.persistence.SalesEnqEntity;
import java.util.Collection;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper contract that maps / transforms data from an instance of type {@link SalesEnqEntity to {@link SalesEnq and vice-versa.
 *
 * @author Admin
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface SalesEnqMapper {

    /**
     * This method transforms an instance of type {@link CreateSalesEnqRequest} to an instance of
     * type {@link SalesEnqEntity}.
     *
     * @param source Instance of type {@link CreateSalesEnqRequest} that needs to be transformed to
     *     {@link SalesEnqEntity}.
     * @return Instance of type {@link SalesEnqEntity}.
     */
    SalesEnqEntity transform(CreateSalesEnqRequest source);

    /**
     * This method transforms an instance of type {@link SalesEnqEntity} to an instance of type
     * {@link SalesEnq}.
     *
     * @param source Instance of type {@link SalesEnqEntity} that needs to be transformed to {@link
     *     SalesEnq}.
     * @return Instance of type {@link SalesEnq}.
     */
    SalesEnq transform(SalesEnqEntity source);

    /**
     * This method converts / transforms the provided collection of {@link SalesEnqEntity} instances
     * to a collection of instances of type {@link SalesEnq}.
     *
     * @param source Instance of type {@link SalesEnqEntity} that needs to be transformed to {@link
     *     SalesEnq}.
     * @return Collection of instance of type {@link SalesEnq}.
     */
    default Collection<SalesEnq> transformListTo(Collection<SalesEnqEntity> source) {
        return source.stream().map(this::transform).collect(Collectors.toSet());
    }
    /**
     * This method transforms an instance of type {@link UpdateSalesEnqRequest} to an instance of
     * type {@link SalesEnqEntity}.
     *
     * <p>The provided instance ({@code target}) will be updated instead of creating a new instance.
     *
     * @param source Instance of type {@link UpdateSalesEnqRequest} that needs to be transformed to
     *     {@link SalesEnqEntity}.
     * @param target Instance of type {@link SalesEnqEntity} that will be updated instead of
     *     creating and returning a new instance.
     */
    void transform(UpdateSalesEnqRequest source, @MappingTarget SalesEnqEntity target);

    /**
     * This method transforms an instance of type {@link UpdateSalesEnqRequest} to an instance of
     * type {@link SalesEnqEntity}.
     *
     * @param source Instance of type {@link UpdateSalesEnqRequest} that needs to be transformed to
     *     {@link SalesEnqEntity}.
     * @return Instance of type {@link SalesEnqEntity}.
     */
    SalesEnqEntity transform(UpdateSalesEnqRequest source);

    /**
     * This method converts / transforms the provided collection of {@link UpdateSalesEnqRequest}
     * instances to a collection of instances of type {@link SalesEnqEntity}.
     *
     * @param source Instance of type {@link UpdateSalesEnqRequest} that needs to be transformed to
     *     {@link SalesEnqEntity}.
     * @return Instance of type {@link SalesEnqEntity}.
     */
    default Collection<SalesEnqEntity> transformList(Collection<UpdateSalesEnqRequest> source) {
        return source.stream().map(this::transform).collect(Collectors.toSet());
    }
}
