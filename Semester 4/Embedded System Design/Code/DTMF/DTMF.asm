
_main:
	LDI        R27, 255
	OUT        SPL+0, R27
	LDI        R27, 0
	OUT        SPL+1, R27

;DTMF.c,1 :: 		void main() {
;DTMF.c,3 :: 		DDRC = 0x00;
	LDI        R27, 0
	OUT        DDRC+0, R27
;DTMF.c,4 :: 		DDRA = 0xFF;
	LDI        R27, 255
	OUT        DDRA+0, R27
;DTMF.c,5 :: 		PINC = 0x00;
	LDI        R27, 0
	OUT        PINC+0, R27
;DTMF.c,6 :: 		delay_ms(2000);
	LDI        R18, 82
	LDI        R17, 43
	LDI        R16, 0
L_main0:
	DEC        R16
	BRNE       L_main0
	DEC        R17
	BRNE       L_main0
	DEC        R18
	BRNE       L_main0
	NOP
	NOP
	NOP
	NOP
;DTMF.c,7 :: 		while(1)
L_main2:
;DTMF.c,9 :: 		PORTC = PINC & 0x0F;
	IN         R16, PINC+0
	ANDI       R16, 15
	OUT        PORTC+0, R16
;DTMF.c,10 :: 		if(PINC == 0x02 || PINC == 0xF2)
	IN         R16, PINC+0
	CPI        R16, 2
	BRNE       L__main19
	JMP        L__main17
L__main19:
	IN         R16, PINC+0
	CPI        R16, 242
	BRNE       L__main20
	JMP        L__main16
L__main20:
	JMP        L_main6
L__main17:
L__main16:
;DTMF.c,12 :: 		PORTA = 0x35;
	LDI        R27, 53
	OUT        PORTA+0, R27
;DTMF.c,13 :: 		delay_ms(2000);
	LDI        R18, 82
	LDI        R17, 43
	LDI        R16, 0
L_main7:
	DEC        R16
	BRNE       L_main7
	DEC        R17
	BRNE       L_main7
	DEC        R18
	BRNE       L_main7
	NOP
	NOP
	NOP
	NOP
;DTMF.c,14 :: 		}
	JMP        L_main9
L_main6:
;DTMF.c,15 :: 		else if(PORTC == 0x08)
	IN         R16, PORTC+0
	CPI        R16, 8
	BREQ       L__main21
	JMP        L_main10
L__main21:
;DTMF.c,17 :: 		PORTA = 0x3A;
	LDI        R27, 58
	OUT        PORTA+0, R27
;DTMF.c,18 :: 		}
	JMP        L_main11
L_main10:
;DTMF.c,19 :: 		else if(PORTC == 0x06)
	IN         R16, PORTC+0
	CPI        R16, 6
	BREQ       L__main22
	JMP        L_main12
L__main22:
;DTMF.c,21 :: 		PORTA = 0x32;
	LDI        R27, 50
	OUT        PORTA+0, R27
;DTMF.c,22 :: 		}
	JMP        L_main13
L_main12:
;DTMF.c,23 :: 		else if(PORTC == 0x04)
	IN         R16, PORTC+0
	CPI        R16, 4
	BREQ       L__main23
	JMP        L_main14
L__main23:
;DTMF.c,25 :: 		PORTA = 0x38;
	LDI        R27, 56
	OUT        PORTA+0, R27
;DTMF.c,26 :: 		}
L_main14:
L_main13:
L_main11:
L_main9:
;DTMF.c,27 :: 		}
	JMP        L_main2
;DTMF.c,29 :: 		}
L_end_main:
L__main_end_loop:
	JMP        L__main_end_loop
; end of _main
