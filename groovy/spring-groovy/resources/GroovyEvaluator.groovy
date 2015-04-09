import groovy.transform.CompileStatic;

import com.murali.spring.groovy.bank.*

@CompileStatic
class GroovyEvaluator implements Evaluator {
    boolean approve(MortgageApplication application) { 
	true
    }
}
