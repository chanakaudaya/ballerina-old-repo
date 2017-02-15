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
package org.wso2.ballerina.core.model.expressions;

import org.wso2.ballerina.core.model.CallableUnit;
import org.wso2.ballerina.core.model.ExecutableMultiReturnExpr;
import org.wso2.ballerina.core.model.types.BType;

/**
 * {@code CallableUnitInvocationExpr} represents a function, action or a resource invocation expression.
 *
 * @param <T> type of the invocation expression
 * @see FunctionInvocationExpr
 * @see ActionInvocationExpr
 * @see ResourceInvocationExpr
 * @since 0.8.0
 */
public interface CallableUnitInvocationExpr<T extends CallableUnit> extends ExecutableMultiReturnExpr {

    String getName();

    String getPackageName();

    String getPackagePath();

    /**
     * Returns an array of arguments of this callable unit invocation expression.
     *
     * @return the array of arguments
     */
    Expression[] getArgExprs();

    /**
     * Returns the {@code CallableUnit} linked with this callable unit invocation expression.
     *
     * @return the linked {@code CallableUnit}
     */
    T getCallableUnit();

    /**
     * Sets the {@code CallableUnit.
     *
     * @param callableUnit type of the callable unit
     */
    void setCallableUnit(T callableUnit);

    /**
     * Returns an array of argument types of this callable unit invocation expression.
     *
     * @return an array of argument types
     */
    BType[] getTypes();

    /**
     * Sets an array of argument types.
     *
     * @param types array of argument types
     */
    void setTypes(BType[] types);

    int getGotoBranchID();

    void setGotoBranchID(int retuningBranchID);

    boolean hasGotoBranchID();

    void setHasGotoBranchID(boolean hasReturningBranch);
}
