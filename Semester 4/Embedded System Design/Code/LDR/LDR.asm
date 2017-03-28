
_ADC:
	PUSH       R30
	PUSH       R31
	PUSH       R27
	IN         R27, SREG+0
	PUSH       R27

;LDR.c,1 :: 		void ADC() org 0x020
;LDR.c,5 :: 		low = ADCL; //Diplay ADCL value @ PORTC
; low start address is: 20 (R20)
	IN         R20, ADCL+0
;LDR.c,6 :: 		high = ADCH; //Diplay ADCH value @ PORTB
; high start address is: 16 (R16)
	IN         R16, ADCH+0
;LDR.c,9 :: 		num = high;
; num start address is: 18 (R18)
	MOV        R18, R16
	LDI        R19, 0
; high end address is: 16 (R16)
;LDR.c,10 :: 		num = num << 8;
	MOV        R17, R18
	CLR        R16
; num end address is: 18 (R18)
;LDR.c,11 :: 		num = num | low;
	OR         R16, R20
	ORI        R17, 0
; low end address is: 20 (R20)
;LDR.c,12 :: 		num = num & 0X03FF;
	ANDI       R16, 255
	ANDI       R17, 3
;LDR.c,13 :: 		num = num * 4882.8;                        //(5/1024*1000) = 4.8828
	LDI        R18, 0
	SBRC       R17, 7
	LDI        R18, 255
	MOV        R19, R18
	CALL       _float_slong2fp+0
	LDI        R20, 102
	LDI        R21, 150
	LDI        R22, 152
	LDI        R23, 69
	CALL       _float_fpmul1+0
	CALL       _float_fpint+0
;LDR.c,15 :: 		if(num < 3300)
	LDI        R18, 228
	LDI        R19, 12
	CP         R16, R18
	CPC        R17, R19
	BRLT       L__ADC3
	JMP        L_ADC0
L__ADC3:
;LDR.c,17 :: 		PORTB = 0XFF;
	LDI        R27, 255
	OUT        PORTB+0, R27
;LDR.c,18 :: 		}
	JMP        L_ADC1
L_ADC0:
;LDR.c,21 :: 		PORTB = 0X00;
	LDI        R27, 0
	OUT        PORTB+0, R27
;LDR.c,22 :: 		}
L_ADC1:
;LDR.c,23 :: 		ADCSRA.B6=1; // After completion of earlier conversion, start                 //new conversion
	IN         R27, ADCSRA+0
	SBR        R27, 64
	OUT        ADCSRA+0, R27
;LDR.c,24 :: 		}
L_end_ADC:
	POP        R27
	OUT        SREG+0, R27
	POP        R27
	POP        R31
	POP        R30
	RETI
; end of _ADC

_main:
	LDI        R27, 255
	OUT        SPL+0, R27
	LDI        R27, 0
	OUT        SPL+1, R27

;LDR.c,27 :: 		int main()
;LDR.c,31 :: 		DDRA.B4=0;  // Set PinA.0 as input
	IN         R27, DDRA+0
	CBR        R27, 16
	OUT        DDRA+0, R27
;LDR.c,32 :: 		DDRB = 0XFF;
	LDI        R27, 255
	OUT        DDRB+0, R27
;LDR.c,33 :: 		ADMUX=0b00000100;      //Reference Voltage Vcc, Left Adjust, ADC0
	LDI        R27, 4
	OUT        ADMUX+0, R27
;LDR.c,34 :: 		ADCSRA=0b10001111;     //ADC enable,ADC interrupt enable,Presclaer 128
	LDI        R27, 143
	OUT        ADCSRA+0, R27
;LDR.c,36 :: 		SREG.B7=1; // Global Interrupt enable
	IN         R27, SREG+0
	SBR        R27, 128
	OUT        SREG+0, R27
;LDR.c,38 :: 		ADCSRA.B6=1;  //Start ADC conversion
	IN         R27, ADCSRA+0
	SBR        R27, 64
	OUT        ADCSRA+0, R27
;LDR.c,40 :: 		}
L_end_main:
L__main_end_loop:
	JMP        L__main_end_loop
; end of _main
