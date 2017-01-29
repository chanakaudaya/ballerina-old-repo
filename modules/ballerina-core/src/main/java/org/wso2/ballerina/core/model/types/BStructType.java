/*
*  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.wso2.ballerina.core.model.types;

import org.wso2.ballerina.core.model.values.BStruct;
import org.wso2.ballerina.core.model.values.BValue;

/**
 * {@code BStructType} represents a user defined {@link org.wso2.ballerina.core.model.Struct} in Ballerina
 *
 * @since 1.0.0
 */
public class BStructType extends BType {

    /**
     * Create a {@code BStructType} which represents the boolean type
     *
     * @param typeName string name of the type
     */
    public BStructType(String typeName) {
        super(typeName, BStruct.class);
    }

    @SuppressWarnings("unchecked")
    public <V extends BValue> V getDefaultValue() {
        return (V) new BStruct();
    }
}
