/*
 * Copyright (c) 2020-2021 Innominds inc. All Rights Reserved. This software is
 * confidential and proprietary information of Innominds inc. You shall not disclose
 * Confidential Information and shall use it only in accordance with the terms
 *
 */
package com.test.features.platform.data.mapper;

import com.test.features.platform.data.model.experience.markettable.CreateMarketTableRequest;
import com.test.features.platform.data.model.experience.markettable.MarketTable;
import com.test.features.platform.data.model.experience.markettable.UpdateMarketTableRequest;
import com.test.features.platform.data.model.persistence.MarketTableEntity;
import java.util.Collection;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper contract that maps / transforms data from an instance of type {@link MarketTableEntity to {@link MarketTable and vice-versa.
 *
 * @author Admin
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface MarketTableMapper {

    /**
     * This method transforms an instance of type {@link CreateMarketTableRequest} to an instance of
     * type {@link MarketTableEntity}.
     *
     * @param source Instance of type {@link CreateMarketTableRequest} that needs to be transformed
     *     to {@link MarketTableEntity}.
     * @return Instance of type {@link MarketTableEntity}.
     */
    MarketTableEntity transform(CreateMarketTableRequest source);

    /**
     * This method transforms an instance of type {@link MarketTableEntity} to an instance of type
     * {@link MarketTable}.
     *
     * @param source Instance of type {@link MarketTableEntity} that needs to be transformed to
     *     {@link MarketTable}.
     * @return Instance of type {@link MarketTable}.
     */
    MarketTable transform(MarketTableEntity source);

    /**
     * This method converts / transforms the provided collection of {@link MarketTableEntity}
     * instances to a collection of instances of type {@link MarketTable}.
     *
     * @param source Instance of type {@link MarketTableEntity} that needs to be transformed to
     *     {@link MarketTable}.
     * @return Collection of instance of type {@link MarketTable}.
     */
    default Collection<MarketTable> transformListTo(Collection<MarketTableEntity> source) {
        return source.stream().map(this::transform).collect(Collectors.toSet());
    }
    /**
     * This method transforms an instance of type {@link UpdateMarketTableRequest} to an instance of
     * type {@link MarketTableEntity}.
     *
     * <p>The provided instance ({@code target}) will be updated instead of creating a new instance.
     *
     * @param source Instance of type {@link UpdateMarketTableRequest} that needs to be transformed
     *     to {@link MarketTableEntity}.
     * @param target Instance of type {@link MarketTableEntity} that will be updated instead of
     *     creating and returning a new instance.
     */
    void transform(UpdateMarketTableRequest source, @MappingTarget MarketTableEntity target);

    /**
     * This method transforms an instance of type {@link UpdateMarketTableRequest} to an instance of
     * type {@link MarketTableEntity}.
     *
     * @param source Instance of type {@link UpdateMarketTableRequest} that needs to be transformed
     *     to {@link MarketTableEntity}.
     * @return Instance of type {@link MarketTableEntity}.
     */
    MarketTableEntity transform(UpdateMarketTableRequest source);

    /**
     * This method converts / transforms the provided collection of {@link UpdateMarketTableRequest}
     * instances to a collection of instances of type {@link MarketTableEntity}.
     *
     * @param source Instance of type {@link UpdateMarketTableRequest} that needs to be transformed
     *     to {@link MarketTableEntity}.
     * @return Instance of type {@link MarketTableEntity}.
     */
    default Collection<MarketTableEntity> transformList(
            Collection<UpdateMarketTableRequest> source) {
        return source.stream().map(this::transform).collect(Collectors.toSet());
    }
}
