
_main:
	LDI        R27, 255
	OUT        SPL+0, R27
	LDI        R27, 0
	OUT        SPL+1, R27

;WiRRobot.c,1 :: 		void main(){
;WiRRobot.c,2 :: 		DDRB = 0x3F;
	LDI        R27, 63
	OUT        DDRB+0, R27
;WiRRobot.c,3 :: 		PORTB = 0X30;
	LDI        R27, 48
	OUT        PORTB+0, R27
;WiRRobot.c,5 :: 		while(1) {
L_main0:
;WiRRobot.c,7 :: 		PORTB |= 0x0A;
	IN         R16, PORTB+0
	ORI        R16, 10
	OUT        PORTB+0, R16
;WiRRobot.c,8 :: 		Delay_ms(2000);
	LDI        R18, 82
	LDI        R17, 43
	LDI        R16, 0
L_main2:
	DEC        R16
	BRNE       L_main2
	DEC        R17
	BRNE       L_main2
	DEC        R18
	BRNE       L_main2
	NOP
	NOP
	NOP
	NOP
;WiRRobot.c,9 :: 		PORTB &= 0xF0;
	IN         R16, PORTB+0
	ANDI       R16, 240
	OUT        PORTB+0, R16
;WiRRobot.c,11 :: 		PORTB |= 0x05;
	ORI        R16, 5
	OUT        PORTB+0, R16
;WiRRobot.c,12 :: 		Delay_ms(2000);
	LDI        R18, 82
	LDI        R17, 43
	LDI        R16, 0
L_main4:
	DEC        R16
	BRNE       L_main4
	DEC        R17
	BRNE       L_main4
	DEC        R18
	BRNE       L_main4
	NOP
	NOP
	NOP
	NOP
;WiRRobot.c,13 :: 		PORTB &= 0xF0;
	IN         R16, PORTB+0
	ANDI       R16, 240
	OUT        PORTB+0, R16
;WiRRobot.c,15 :: 		PORTB |= 0x02;
	ORI        R16, 2
	OUT        PORTB+0, R16
;WiRRobot.c,16 :: 		Delay_ms(2000);
	LDI        R18, 82
	LDI        R17, 43
	LDI        R16, 0
L_main6:
	DEC        R16
	BRNE       L_main6
	DEC        R17
	BRNE       L_main6
	DEC        R18
	BRNE       L_main6
	NOP
	NOP
	NOP
	NOP
;WiRRobot.c,17 :: 		PORTB &= 0xF0;
	IN         R16, PORTB+0
	ANDI       R16, 240
	OUT        PORTB+0, R16
;WiRRobot.c,19 :: 		PORTB |= 0x08;
	ORI        R16, 8
	OUT        PORTB+0, R16
;WiRRobot.c,20 :: 		Delay_ms(2000);
	LDI        R18, 82
	LDI        R17, 43
	LDI        R16, 0
L_main8:
	DEC        R16
	BRNE       L_main8
	DEC        R17
	BRNE       L_main8
	DEC        R18
	BRNE       L_main8
	NOP
	NOP
	NOP
	NOP
;WiRRobot.c,21 :: 		PORTB &= 0xF0;
	IN         R16, PORTB+0
	ANDI       R16, 240
	OUT        PORTB+0, R16
;WiRRobot.c,22 :: 		}
	JMP        L_main0
;WiRRobot.c,23 :: 		}
L_end_main:
L__main_end_loop:
	JMP        L__main_end_loop
; end of _main
