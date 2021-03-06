/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cloudbase.core.client.mock;

import cloudbase.core.client.BatchDeleter;
import cloudbase.core.client.MultiTableBatchWriter;
import cloudbase.core.client.TableNotFoundException;
import cloudbase.core.security.Authorizations;

/**
 * Subclass to make package-private methods public for use by other classes.
 */
public class MockConnectorShim extends MockConnector {

    public final MockCloudbase cb;

    public MockConnectorShim(String username) {
        this(username, new MockCloudbase());
    }

    public MockConnectorShim(String username, MockInstance instance) {
        this(username, instance.cb);
    }

    public MockConnectorShim(String username, MockCloudbase mockCloudbase) {
        super(username, mockCloudbase);
        this.cb = mockCloudbase;
    }

    @Override
    public MultiTableBatchWriter createMultiTableBatchWriter(final long maxMemory, final int maxLatency,
                                                             final int maxWriteThreads) {
        return new MockMultiTableBatchWriter(cb);
    }

    @Override
    public BatchDeleter createBatchDeleter(String tableName, Authorizations authorizations, int numQueryThreads, long maxMemory, long maxLatency,
                                           int maxWriteThreads) throws TableNotFoundException {
        return new MockBatchDeleter(cb, tableName, authorizations);
    }
}
