class NoParenthesis {
	def getProperty(String propertyName) {
		if (metaClass.hasProperty(this, propertyName)) {
			return metaClass.getProperty(this, propertyName)
		}
		invokeMethod propertyName, null
	}
}

class PropUser extends NoParenthesis{
	boolean existingProperty = true
}

def user = new PropUser()
assert user.existingProperty
assert user.toString() == user.toString