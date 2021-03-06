package com.murali.groovy.advanced.compile.mop

import org.codehaus.groovy.transform.GroovyASTTransformation
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.syntax.SyntaxException
import org.codehaus.groovy.ast.*

@GroovyASTTransformation(phase=CompilePhase.SEMANTIC_ANALYSIS)
class CodeCheck implements ASTTransformation{
	@Override
	public void visit(ASTNode[] nodes, SourceUnit source) {
		source.ast.classes.each{classNode ->
			classNode.visitContents(new OurClassVisitor(source))
		}
	}
}

class OurClassVisitor implements GroovyClassVisitor {
	SourceUnit sourceUnit
	OurClassVisitor(theSourceUnit) { sourceUnit = theSourceUnit }
	private void reportError(message, lineNumber, columnNumber) {
	  sourceUnit.addError(new SyntaxException(message, lineNumber, columnNumber))
	}
	
	void visitMethod(MethodNode node) {
	  if(node.name.size() == 1)
		reportError "Make method name descriptive, avoid single letter names",
			node.lineNumber, node.columnNumber
   
	  node.parameters.each { parameter ->
		if(parameter.name.size() == 1)
		  reportError "Single letter parameters are morally wrong!",
			  parameter.lineNumber, parameter.columnNumber
	  }
	}
   
	void visitClass(ClassNode node) {}
	void visitConstructor(ConstructorNode node) {}
	void visitField(FieldNode node) {}
	void visitProperty(PropertyNode node) {}
 }