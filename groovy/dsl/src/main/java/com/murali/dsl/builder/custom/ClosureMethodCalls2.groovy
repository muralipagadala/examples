def current

def root(Closure closure){
	def tree = [:]
	def root = [:]
	tree['root'] = root
	def parent = current
	current = root
	closure.call()
	current = parent

	return tree
}

def node(key, Closure closure){
	def node = [:]
	current[key] = node
	def parent = current
	current = node
	closure.call()
	current = parent
}

def leaf (key, value ) {
	current[key] = value
}

// pseudo builder code
def tree = root {
	node ("sub-tree-1") { leaf "leaf-1", "leaf object 1" }
	node ("sub-tree-2"){
		node ("node-1"){ leaf "leaf-2", "leaf object 2" }
	}
}

assert tree == [
	root: [
		"sub-tree-1": [
			"leaf-1": "leaf object 1"
		],
		"sub-tree-2": [
			"node-1": [
				"leaf-2": "leaf object 2"
			]
		]
	]
]