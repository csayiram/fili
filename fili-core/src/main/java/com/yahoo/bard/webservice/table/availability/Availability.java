// Copyright 2017 Yahoo Inc.
// Licensed under the terms of the Apache license. Please see LICENSE.md file distributed with this work for terms.
package com.yahoo.bard.webservice.table.availability;

import com.yahoo.bard.webservice.data.config.names.TableName;
import com.yahoo.bard.webservice.table.Column;
import com.yahoo.bard.webservice.table.resolver.DataSourceConstraint;
import com.yahoo.bard.webservice.util.SimplifiedIntervalList;

import org.joda.time.Interval;

import java.util.Map;
import java.util.Set;

/**
 * Availability describes the intervals available by column for a table.
 */
public interface Availability {

    /**
     * The names of the data sources backing this availability.
     *
     * @return A set of names for datasources backing this table
     */
    Set<TableName> getDataSourceNames();

    /**
     * The availability of all columns.
     *
     * @return The intervals, by column, available.
     */
    Map<Column, Set<Interval>> getAllAvailableIntervals();

    /**
     * Fetch a set of intervals given a set of column name in DataSourceConstraint.
     *
     * @param constraints  Data constraint containing columns and api filters
     *
     * @return Set of intervals associated with each corresponding column in a map, empty if column is missing
     */
    SimplifiedIntervalList getAvailableIntervals(DataSourceConstraint constraints);
}
