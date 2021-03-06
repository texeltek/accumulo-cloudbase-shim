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
package cloudbase.core.client.mapreduce;

import cloudbase.core.client.Instance;
import cloudbase.core.client.TableNotFoundException;
import cloudbase.core.client.impl.TabletLocator;
import cloudbase.core.data.Range;
import cloudbase.core.security.Authorizations;
import cloudbase.core.util.Pair;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.log4j.Level;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class CloudbaseInputFormatShim extends CloudbaseInputFormat {

    public static boolean isIsolated(JobContext job) {
        return CloudbaseInputFormat.isIsolated(job);
    }

    public static String getUsername(JobContext job) {
        return CloudbaseInputFormat.getUsername(job);
    }

    public static byte[] getPassword(JobContext job) {
        return CloudbaseInputFormat.getPassword(job);
    }

    public static String getTablename(JobContext job) {
        return CloudbaseInputFormat.getTablename(job);
    }

    public static Authorizations getAuthorizations(JobContext job) {
        return CloudbaseInputFormat.getAuthorizations(job);
    }

    public static Instance getInstance(JobContext job) {
        return CloudbaseInputFormat.getInstance(job);
    }

    public static TabletLocator getTabletLocator(JobContext job) throws TableNotFoundException {
        return CloudbaseInputFormat.getTabletLocator(job);
    }

    public static List<Range> getRanges(JobContext job) throws IOException {
        return CloudbaseInputFormat.getRanges(job);
    }

    public static String getRegex(JobContext job, RegexType type) {
        return CloudbaseInputFormat.getRegex(job, type);
    }

    public static Set<Pair<Text, Text>> getFetchedColumns(JobContext job) {
        return CloudbaseInputFormat.getFetchedColumns(job);
    }

    public static boolean getAutoAdjustRanges(JobContext job) {
        return CloudbaseInputFormat.getAutoAdjustRanges(job);
    }

    public static Level getLogLevel(JobContext job) {
        return CloudbaseInputFormat.getLogLevel(job);
    }

    public static void validateOptions(JobContext job) throws IOException {
        CloudbaseInputFormat.validateOptions(job);
    }

    public static int getMaxVersions(JobContext job) {
        return CloudbaseInputFormat.getMaxVersions(job);
    }

    public static List<CBIterator> getIterators(JobContext job) {
        return CloudbaseInputFormat.getIterators(job);
    }

    public static List<CBIteratorOption> getIteratorOptions(JobContext job) {
        return CloudbaseInputFormat.getIteratorOptions(job);
    }
}
