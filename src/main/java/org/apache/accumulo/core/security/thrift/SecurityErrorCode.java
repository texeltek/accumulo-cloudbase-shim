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
package org.apache.accumulo.core.security.thrift;

public enum SecurityErrorCode implements org.apache.thrift.TEnum {
    DEFAULT_SECURITY_ERROR(0),
    BAD_CREDENTIALS(1),
    PERMISSION_DENIED(2),
    USER_DOESNT_EXIST(3),
    CONNECTION_ERROR(4),
    USER_EXISTS(5),
    GRANT_INVALID(6),
    BAD_AUTHORIZATIONS(7),
    INVALID_INSTANCEID(8),
    TABLE_DOESNT_EXIST(9);

    private final int value;

    private SecurityErrorCode(int value) {
        this.value = value;
    }

    /**
     * Get the integer value of this enum value, as defined in the Thrift IDL.
     */
    public int getValue() {
        return value;
    }

    /**
     * Find a the enum type by its integer value, as defined in the Thrift IDL.
     *
     * @return null if the value is not found.
     */
    public static SecurityErrorCode findByValue(int value) {
        switch (value) {
            case 0:
                return DEFAULT_SECURITY_ERROR;
            case 1:
                return BAD_CREDENTIALS;
            case 2:
                return PERMISSION_DENIED;
            case 3:
                return USER_DOESNT_EXIST;
            case 4:
                return CONNECTION_ERROR;
            case 5:
                return USER_EXISTS;
            case 6:
                return GRANT_INVALID;
            case 7:
                return BAD_AUTHORIZATIONS;
            case 8:
                return INVALID_INSTANCEID;
            case 9:
                return TABLE_DOESNT_EXIST;
            default:
                return null;
        }
    }
}
