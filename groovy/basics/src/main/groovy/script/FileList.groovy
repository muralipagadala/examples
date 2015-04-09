def price = 8
println "Item prices is :$price"

def currentDirectory = new File('.')
println "Current Directory : $currentDirectory.absolutePath"
def files = currentDirectory.listFiles()
for(def file : files)
    println file.name

