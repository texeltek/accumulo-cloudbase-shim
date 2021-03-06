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
package org.apache.accumulo.core.client.mock;

import cloudbase.core.client.CBException;
import cloudbase.core.client.CBSecurityException;
import org.apache.accumulo.core.client.AccumuloException;
import org.apache.accumulo.core.client.AccumuloSecurityException;
import org.apache.accumulo.core.client.TableExistsException;
import org.apache.accumulo.core.client.TableNotFoundException;
import org.apache.accumulo.core.client.admin.TimeType;
import org.apache.accumulo.core.data.Range;
import org.apache.accumulo.core.security.Authorizations;
import org.apache.hadoop.io.Text;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public class MockTableOperations {

    public final cloudbase.core.client.mock.MockTableOperations impl;

    public MockTableOperations(cloudbase.core.client.mock.MockTableOperations impl) {
        this.impl = impl;
    }

    public SortedSet<String> list() {
        return impl.list();
    }

    public boolean exists(String tableName) {
        return impl.exists(tableName);
    }

    public void create(String tableName) throws AccumuloException, AccumuloSecurityException, TableExistsException {
        try {
            impl.create(tableName);
        } catch (CBException e) {
            throw new AccumuloException(e);
        } catch (CBSecurityException e) {
            throw new AccumuloSecurityException(e);
        } catch (cloudbase.core.client.TableExistsException e) {
            throw new TableExistsException(e);
        }
    }

    public void create(String tableName, boolean versioningIter) throws AccumuloException, AccumuloSecurityException, TableExistsException {
        throw new UnsupportedOperationException();
    }

    public void create(String tableName, boolean versioningIter, TimeType timeType) throws AccumuloException, AccumuloSecurityException, TableExistsException {
        throw new UnsupportedOperationException();
    }

    public void addSplits(String tableName, SortedSet<Text> partitionKeys) throws TableNotFoundException, AccumuloException, AccumuloSecurityException {
        try {
            impl.addSplits(tableName, partitionKeys);
        } catch (cloudbase.core.client.TableNotFoundException e) {
            throw new TableNotFoundException(e);
        } catch (CBException e) {
            throw new AccumuloException(e);
        } catch (CBSecurityException e) {
            throw new AccumuloSecurityException(e);
        }
    }

    public Collection<Text> getSplits(String tableName) throws TableNotFoundException {
        return impl.getSplits(tableName);
    }

    public Collection<Text> getSplits(String tableName, int maxSplits) throws TableNotFoundException {
        return impl.getSplits(tableName, maxSplits);
    }

    public void delete(String tableName) throws AccumuloException, AccumuloSecurityException, TableNotFoundException {
        try {
            impl.delete(tableName);
        } catch (CBException e) {
            throw new AccumuloException(e);
        } catch (CBSecurityException e) {
            throw new AccumuloSecurityException(e);
        } catch (cloudbase.core.client.TableNotFoundException e) {
            throw new TableNotFoundException(e);
        }
    }

    public void rename(String oldTableName, String newTableName) throws AccumuloSecurityException, TableNotFoundException, AccumuloException,
            TableExistsException {
        try {
            impl.rename(oldTableName, newTableName);
        } catch (CBSecurityException e) {
            throw new AccumuloSecurityException(e);
        } catch (cloudbase.core.client.TableNotFoundException e) {
            throw new TableNotFoundException(e);
        } catch (CBException e) {
            throw new AccumuloException(e);
        } catch (cloudbase.core.client.TableExistsException e) {
            throw new TableExistsException(e);
        }
    }

    public void flush(String tableName) throws AccumuloException, AccumuloSecurityException {
        try {
            impl.flush(tableName);
        } catch (CBException e) {
            throw new AccumuloException(e);
        } catch (CBSecurityException e) {
            throw new AccumuloSecurityException(e);
        }
    }

    public void setProperty(String tableName, String property, String value) throws AccumuloException, AccumuloSecurityException {
        try {
            impl.setProperty(tableName, property, value);
        } catch (CBException e) {
            throw new AccumuloException(e);
        } catch (CBSecurityException e) {
            throw new AccumuloSecurityException(e);
        }
    }

    public void removeProperty(String tableName, String property) throws AccumuloException, AccumuloSecurityException {
        throw new UnsupportedOperationException();
    }

    public Iterable<Map.Entry<String, String>> getProperties(String tableName) throws TableNotFoundException {
        try {
            return impl.getProperties(tableName);
        } catch (cloudbase.core.client.TableNotFoundException e) {
            throw new TableNotFoundException(e);
        }
    }

    public void setLocalityGroups(String tableName, Map<String, Set<Text>> groups) throws AccumuloException, AccumuloSecurityException, TableNotFoundException {
        try {
            impl.setLocalityGroups(tableName, groups);
        } catch (CBException e) {
            throw new AccumuloException(e);
        } catch (CBSecurityException e) {
            throw new AccumuloSecurityException(e);
        } catch (cloudbase.core.client.TableNotFoundException e) {
            throw new TableNotFoundException(e);
        }
    }

    public Map<String, Set<Text>> getLocalityGroups(String tableName) throws AccumuloException, TableNotFoundException {
        try {
            return impl.getLocalityGroups(tableName);
        } catch (CBException e) {
            throw new AccumuloException(e);
        } catch (cloudbase.core.client.TableNotFoundException e) {
            throw new TableNotFoundException(e);
        }
    }

    public Set<Range> splitRangeByTablets(String tableName, Range range, int maxSplits) throws AccumuloException, AccumuloSecurityException,
            TableNotFoundException {
        throw new UnsupportedOperationException();
    }

    public void importDirectory(String tableName, String dir, String failureDir, boolean setTime) throws IOException, AccumuloException,
            AccumuloSecurityException, TableNotFoundException {
        throw new UnsupportedOperationException();
    }

    public void offline(String tableName) throws AccumuloSecurityException, AccumuloException {
        try {
            impl.offline(tableName);
        } catch (CBSecurityException e) {
            throw new AccumuloSecurityException(e);
        } catch (CBException e) {
            throw new AccumuloException(e);
        }
    }

    public void online(String tableName) throws AccumuloSecurityException, AccumuloException {
        try {
            impl.online(tableName);
        } catch (CBSecurityException e) {
            throw new AccumuloSecurityException(e);
        } catch (CBException e) {
            throw new AccumuloException(e);
        }
    }

    public void clearLocatorCache(String tableName) throws TableNotFoundException {
        try {
            impl.clearLocatorCache(tableName);
        } catch (cloudbase.core.client.TableNotFoundException e) {
            throw new TableNotFoundException(e);
        }
    }

    public Map<String, String> tableIdMap() {
        return impl.tableIdMap();
    }

    public void merge(String tableName, Text start, Text end) throws AccumuloException, AccumuloSecurityException, TableNotFoundException {
        throw new UnsupportedOperationException();
    }

    public void deleteRows(String tableName, Text start, Text end) throws AccumuloException, AccumuloSecurityException, TableNotFoundException {
        throw new UnsupportedOperationException();
    }

    public void compact(String tableName, Text start, Text end, boolean flush, boolean wait) throws AccumuloSecurityException, TableNotFoundException,
            AccumuloException {
        throw new UnsupportedOperationException();
    }

    public void clone(String srcTableName, String newTableName, boolean flush, Map<String, String> propertiesToSet, Set<String> propertiesToExclude)
            throws AccumuloException, AccumuloSecurityException, TableNotFoundException, TableExistsException {
        throw new UnsupportedOperationException();
    }

    public void flush(String tableName, Text start, Text end, boolean wait) throws AccumuloException, AccumuloSecurityException, TableNotFoundException {
        throw new UnsupportedOperationException();
    }

    public Text getMaxRow(String tableName, Authorizations auths, Text startRow, boolean startInclusive, Text endRow, boolean endInclusive)
            throws TableNotFoundException, AccumuloException, AccumuloSecurityException {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return impl.toString();
    }
}
