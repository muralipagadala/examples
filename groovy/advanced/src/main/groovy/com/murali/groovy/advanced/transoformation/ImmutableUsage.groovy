package com.murali.groovy.advanced.transoformation

import groovy.transform.*

@Immutable
class CreditCard {
	String cardNumber
	int creditLimit
}


def card_1 = new CreditCard("4000-1111-2222-3333", 1000)
def card_2 = ["4000-1111-2222-3333", 1000] as CreditCard

assert card_1 == card_2