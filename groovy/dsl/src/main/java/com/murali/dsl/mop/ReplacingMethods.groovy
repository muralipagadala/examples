package com.murali.dsl.mop

class BankManager{
	boolean loanApprovalStatus = false
	
	boolean approveLoan(){
		return loanApprovalStatus
	}
}

def bankManager = new BankManager()
assert bankManager.approveLoan() == false

BankManager.metaClass.approveLoan = {true}

bankManager = new BankManager()
assert bankManager.approveLoan() == true

////////////////////////////////////////////////////////

class MuraliCalendar{
	def time = 'Time String'
}

println "Before ${Calendar.getInstance().time}"

//Calendar.metaClass.static.getInstance = { new MuraliCalendar()}

println "After ${Calendar.getInstance().time}"

Calendar.metaClass.static.now = { Calendar.getInstance().getTime() }

println Calendar.now()