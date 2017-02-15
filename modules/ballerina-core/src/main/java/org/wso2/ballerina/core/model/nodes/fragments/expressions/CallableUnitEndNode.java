/*
*   Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*/
package org.wso2.ballerina.core.model.nodes.fragments.expressions;

import org.wso2.ballerina.core.model.LinkedNodeVisitor;
import org.wso2.ballerina.core.model.expressions.Expression;
import org.wso2.ballerina.core.model.nodes.AbstractLinkedNode;

/**
 * Statement that enclose previous Callable Unit invocation.
 */
public class CallableUnitEndNode extends AbstractLinkedNode {

    private Expression expression;
    private boolean nativeInvocation;

    public CallableUnitEndNode(Expression expression) {
        this.expression = expression;
        this.parent = expression;
    }

    @Override
    public void accept(LinkedNodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    public boolean isNativeInvocation() {
        return nativeInvocation;
    }

    public void setNativeInvocation(boolean nativeInvocation) {
        this.nativeInvocation = nativeInvocation;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
