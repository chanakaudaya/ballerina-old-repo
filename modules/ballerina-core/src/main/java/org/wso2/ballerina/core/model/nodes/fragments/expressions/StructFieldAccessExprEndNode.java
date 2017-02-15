/*
*   Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.ballerina.core.model.nodes.fragments.expressions;

import org.wso2.ballerina.core.model.LinkedNodeVisitor;
import org.wso2.ballerina.core.model.expressions.StructFieldAccessExpr;
import org.wso2.ballerina.core.model.nodes.AbstractLinkedNode;

/**
 * Represents node Where StructFieldAccessExpr ends.
 */
public class StructFieldAccessExprEndNode extends AbstractLinkedNode {

    private StructFieldAccessExpr expression;

    public StructFieldAccessExprEndNode(StructFieldAccessExpr expression) {
        this.expression = expression;
        this.parent = expression;
    }

    public StructFieldAccessExpr getExpression() {
        return expression;
    }

    @Override
    public void accept(LinkedNodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
