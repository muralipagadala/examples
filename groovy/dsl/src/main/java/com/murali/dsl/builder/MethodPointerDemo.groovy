def list = ['A', 'B', 'C']
def listAdd = list.&add
listAdd  'D'

assert list == ['A', 'B', 'C', 'D']