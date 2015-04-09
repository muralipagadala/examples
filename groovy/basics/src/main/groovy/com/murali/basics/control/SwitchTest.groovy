def x = 1
def log = ''
switch(x){
	case 0 : log += 0
	case 1 : log += 1
	case 2 : log += 2
	         break
	default : log += 'default'
}

assert log == '12'

switch(10){
	case 0 			: assert false; break
	case 0..9 		: assert false; break
	case[2, 8, 11] 	: assert false; break
	case Float 		: assert false; break
	case {it%3 == 0}: assert false; break
	case ~/../ 		: assert true; break
	default 		: assert false; break;
}