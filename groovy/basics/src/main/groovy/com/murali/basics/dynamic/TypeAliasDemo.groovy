import math.MathLib as OrigMathLib

class MathLib extends OrigMathLib{
	Integer twice(Integer value) {
		return value * 2
	}
}

def mathLib = new MathLib()

assert 10 == mathLib.twice(5)
assert 4 == mathLib.twice(2)