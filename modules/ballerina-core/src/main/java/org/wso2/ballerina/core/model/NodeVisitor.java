/*
*  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.ballerina.core.model;

import org.wso2.ballerina.core.interpreter.ConnectorVarLocation;
import org.wso2.ballerina.core.interpreter.ConstantLocation;
import org.wso2.ballerina.core.interpreter.ServiceVarLocation;
import org.wso2.ballerina.core.interpreter.StackVarLocation;
import org.wso2.ballerina.core.interpreter.StructVarLocation;
import org.wso2.ballerina.core.interpreter.WorkerVarLocation;
import org.wso2.ballerina.core.model.expressions.ActionInvocationExpr;
import org.wso2.ballerina.core.model.expressions.AddExpression;
import org.wso2.ballerina.core.model.expressions.AndExpression;
import org.wso2.ballerina.core.model.expressions.ArrayInitExpr;
import org.wso2.ballerina.core.model.expressions.ArrayMapAccessExpr;
import org.wso2.ballerina.core.model.expressions.BacktickExpr;
import org.wso2.ballerina.core.model.expressions.BasicLiteral;
import org.wso2.ballerina.core.model.expressions.ConnectorInitExpr;
import org.wso2.ballerina.core.model.expressions.DivideExpr;
import org.wso2.ballerina.core.model.expressions.EqualExpression;
import org.wso2.ballerina.core.model.expressions.FunctionInvocationExpr;
import org.wso2.ballerina.core.model.expressions.GreaterEqualExpression;
import org.wso2.ballerina.core.model.expressions.GreaterThanExpression;
import org.wso2.ballerina.core.model.expressions.InstanceCreationExpr;
import org.wso2.ballerina.core.model.expressions.LessEqualExpression;
import org.wso2.ballerina.core.model.expressions.LessThanExpression;
import org.wso2.ballerina.core.model.expressions.MapInitExpr;
import org.wso2.ballerina.core.model.expressions.MapStructInitKeyValueExpr;
import org.wso2.ballerina.core.model.expressions.ModExpression;
import org.wso2.ballerina.core.model.expressions.MultExpression;
import org.wso2.ballerina.core.model.expressions.NotEqualExpression;
import org.wso2.ballerina.core.model.expressions.OrExpression;
import org.wso2.ballerina.core.model.expressions.RefTypeInitExpr;
import org.wso2.ballerina.core.model.expressions.ResourceInvocationExpr;
import org.wso2.ballerina.core.model.expressions.StructFieldAccessExpr;
import org.wso2.ballerina.core.model.expressions.StructInitExpr;
import org.wso2.ballerina.core.model.expressions.SubtractExpression;
import org.wso2.ballerina.core.model.expressions.TypeCastExpression;
import org.wso2.ballerina.core.model.expressions.UnaryExpression;
import org.wso2.ballerina.core.model.expressions.VariableRefExpr;
import org.wso2.ballerina.core.model.invokers.MainInvoker;
import org.wso2.ballerina.core.model.statements.ActionInvocationStmt;
import org.wso2.ballerina.core.model.statements.AssignStmt;
import org.wso2.ballerina.core.model.statements.BlockStmt;
import org.wso2.ballerina.core.model.statements.BreakStmt;
import org.wso2.ballerina.core.model.statements.CommentStmt;
import org.wso2.ballerina.core.model.statements.ForkJoinStmt;
import org.wso2.ballerina.core.model.statements.FunctionInvocationStmt;
import org.wso2.ballerina.core.model.statements.IfElseStmt;
import org.wso2.ballerina.core.model.statements.ReplyStmt;
import org.wso2.ballerina.core.model.statements.ReturnStmt;
import org.wso2.ballerina.core.model.statements.ThrowStmt;
import org.wso2.ballerina.core.model.statements.TryCatchStmt;
import org.wso2.ballerina.core.model.statements.VariableDefStmt;
import org.wso2.ballerina.core.model.statements.WhileStmt;
import org.wso2.ballerina.core.model.statements.WorkerInvocationStmt;
import org.wso2.ballerina.core.model.statements.WorkerReplyStmt;

/**
 * {@code NodeVisitor} responsible for executing a Ballerina applications by traversing statements and expressions.
 *
 * @since 0.8.0
 */
public interface NodeVisitor {

    void visit(BallerinaFile bFile);

    void visit(ImportPackage importPkg);

    void visit(ConstDef constant);

    void visit(Service service);

    void visit(BallerinaConnectorDef connector);

    void visit(Resource resource);

    void visit(BallerinaFunction function);

    void visit(BTypeMapper typeMapper);

    void visit(BallerinaAction action);

    void visit(Worker worker);

    void visit(Annotation annotation);

    void visit(ParameterDef parameterDef);

    void visit(ConnectorDcl connectorDcl);

    void visit(VariableDef variableDef);
    
    void visit(StructDef structDef);


    // Statements

    void visit(VariableDefStmt varDefStmt);

    void visit(AssignStmt assignStmt);

    void visit(BlockStmt blockStmt);

    void visit(CommentStmt commentStmt);

    void visit(IfElseStmt ifElseStmt);

    void visit(ReplyStmt replyStmt);

    void visit(ReturnStmt returnStmt);

    void visit(WhileStmt whileStmt);

    void visit(BreakStmt breakStmt);

    void visit(TryCatchStmt tryCatchStmt);

    void visit(ThrowStmt throwStmt);

    void visit(FunctionInvocationStmt functionInvocationStmt);

    void visit(ActionInvocationStmt actionInvocationStmt);

    void visit(WorkerInvocationStmt workerInvocationStmt);

    void visit(WorkerReplyStmt workerReplyStmt);

    void visit(ForkJoinStmt forkJoinStmt);

    // Expressions

    void visit(AddExpression addExpr);

    void visit(AndExpression andExpression);

    void visit(BasicLiteral basicLiteral);

    void visit(DivideExpr divideExpr);

    void visit(ModExpression modExpression);

    void visit(EqualExpression equalExpression);

    void visit(FunctionInvocationExpr functionInvocationExpr);

    void visit(ActionInvocationExpr actionInvocationExpr);

    void visit(GreaterEqualExpression greaterEqualExpression);

    void visit(GreaterThanExpression greaterThanExpression);

    void visit(LessEqualExpression lessEqualExpression);

    void visit(LessThanExpression lessThanExpression);

    void visit(MultExpression multExpression);

    void visit(InstanceCreationExpr instanceCreationExpr);

    void visit(NotEqualExpression notEqualExpression);

    void visit(OrExpression orExpression);

    void visit(SubtractExpression subtractExpression);

    void visit(UnaryExpression unaryExpression);

    void visit(TypeCastExpression typeCastExpression);

    void visit(ArrayMapAccessExpr arrayMapAccessExpr);

    void visit(StructFieldAccessExpr structAttributeAccessExpr);

    void visit(BacktickExpr backtickExpr);

    void visit(ArrayInitExpr arrayInitExpr);

    void visit(RefTypeInitExpr refTypeInitExpr);

    void visit(ConnectorInitExpr connectorInitExpr);

    void visit(StructInitExpr structInitExpr);

    void visit(MapInitExpr mapInitExpr);

    void visit(MapStructInitKeyValueExpr keyValueExpr);

    void visit(VariableRefExpr variableRefExpr);


    void visit(StackVarLocation stackVarLocation);

    void visit(ServiceVarLocation serviceVarLocation);

    void visit(ConnectorVarLocation connectorVarLocation);

    void visit(ConstantLocation constantLocation);

    void visit(ResourceInvocationExpr resourceIExpr);

    void visit(MainInvoker mainInvoker);

    void visit(StructVarLocation structVarLocation);

    void visit(WorkerVarLocation workerVarLocation);
}
