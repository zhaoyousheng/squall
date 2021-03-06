/*
 * Copyright (c) 2011-2015 EPFL DATA Laboratory
 * Copyright (c) 2014-2015 The Squall Collaboration (see NOTICE)
 *
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ch.epfl.data.squall.api.sql.optimizers.name;

import java.io.Serializable;

import ch.epfl.data.squall.api.sql.util.TupleSchema;

/*
 * parallelism also has to be inside,
 *   we cannot use Config maps to exchange parallelism,
 *   because there are many query plans building in parallel (Selinger-style optimization)
 * From the final choosen query plan, we fill in config maps.
 */
public class CostParams implements Serializable {
    private static final long serialVersionUID = 1L;

    // unless otherwise specified, there is no pruning tuples from a relation
    private double _selectivity = 1.0;
    private long _cardinality; // total number of tuples at the output of a
    // component
    private TupleSchema _schema;
    private int _parallelism;

    // only used in manual batching
    private int _batchSize;
    private double _latency; // in millis
    private double _totalAvgLatency; // in millis

    /**
     * @return the _batchSize
     */
    public int getBatchSize() {
	return _batchSize;
    }

    /**
     * @return the _cardinality
     */
    public long getCardinality() {
	return _cardinality;
    }

    /**
     * @return the _latency
     */
    public double getLatency() {
	return _latency;
    }

    /**
     * @return the _parallelism
     */
    public int getParallelism() {
	return _parallelism;
    }

    /**
     * @return the _schema
     */
    public TupleSchema getSchema() {
	return _schema;
    }

    /**
     * @return the _selectivity
     */
    public double getSelectivity() {
	return _selectivity;
    }

    /**
     * @return the _totalAvgLatency
     */
    public double getTotalAvgLatency() {
	return _totalAvgLatency;
    }

    /**
     * @param batchSize
     *            the _batchSize to set
     */
    public void setBatchSize(int batchSize) {
	_batchSize = batchSize;
    }

    /**
     * @param cardinality
     *            the _cardinality to set
     */
    public void setCardinality(long cardinality) {
	_cardinality = cardinality;
    }

    /**
     * @param latency
     *            the _latency to set
     */
    public void setLatency(double latency) {
	_latency = latency;
    }

    /**
     * @param parallelism
     *            the _parallelism to set
     */
    public void setParallelism(int parallelism) {
	_parallelism = parallelism;
    }

    /**
     * @param schema
     *            the _schema to set
     */
    public void setSchema(TupleSchema schema) {
	_schema = schema;
    }

    /**
     * @param selectivity
     *            the _selectivity to set
     */
    public void setSelectivity(double selectivity) {
	_selectivity = selectivity;
    }

    /**
     * @param totalAvgLatency
     *            the _totalAvgLatency to set
     */
    public void setTotalAvgLatency(double totalAvgLatency) {
	_totalAvgLatency = totalAvgLatency;
    }

}
