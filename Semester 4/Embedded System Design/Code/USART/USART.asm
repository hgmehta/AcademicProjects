
_uart_init:

;USART.c,1 :: 		void uart_init()
;USART.c,3 :: 		UCSRA=0x00;
	LDI        R27, 0
	OUT        UCSRA+0, R27
;USART.c,4 :: 		UCSRB=0x18;//if receive complete interupt enabled 0x98  //if disabled 0x18
	LDI        R27, 24
	OUT        UCSRB+0, R27
;USART.c,5 :: 		UCSRC=0x86;
	LDI        R27, 134
	OUT        UCSRC+0, R27
;USART.c,6 :: 		UBRRH=0x00;
	LDI        R27, 0
	OUT        UBRRH+0, R27
;USART.c,7 :: 		UBRRL=0X33;
	LDI        R27, 51
	OUT        UBRRL+0, R27
;USART.c,8 :: 		delay_ms(1000);
	LDI        R18, 41
	LDI        R17, 150
	LDI        R16, 128
L_uart_init0:
	DEC        R16
	BRNE       L_uart_init0
	DEC        R17
	BRNE       L_uart_init0
	DEC        R18
	BRNE       L_uart_init0
;USART.c,9 :: 		}
L_end_uart_init:
	RET
; end of _uart_init

_tx_char:

;USART.c,11 :: 		void tx_char(unsigned char uchar)
;USART.c,13 :: 		UDR=uchar;
	OUT        UDR+0, R2
;USART.c,14 :: 		while((UCSRA&0x40)==0x00);
L_tx_char2:
	IN         R16, UCSRA+0
	ANDI       R16, 64
	CPI        R16, 0
	BREQ       L__tx_char41
	JMP        L_tx_char3
L__tx_char41:
	JMP        L_tx_char2
L_tx_char3:
;USART.c,15 :: 		delay_ms(1000);
	LDI        R18, 41
	LDI        R17, 150
	LDI        R16, 128
L_tx_char4:
	DEC        R16
	BRNE       L_tx_char4
	DEC        R17
	BRNE       L_tx_char4
	DEC        R18
	BRNE       L_tx_char4
;USART.c,16 :: 		}
L_end_tx_char:
	RET
; end of _tx_char

_tx_string:

;USART.c,18 :: 		void tx_string(const unsigned char *ustring)
;USART.c,20 :: 		while ( *ustring )
L_tx_string6:
	MOVW       R30, R2
	LPM        R16, Z
	TST        R16
	BRNE       L__tx_string43
	JMP        L_tx_string7
L__tx_string43:
;USART.c,22 :: 		UDR=*ustring++;
	MOVW       R30, R2
	LPM        R16, Z
	OUT        UDR+0, R16
	MOVW       R16, R2
	SUBI       R16, 255
	SBCI       R17, 255
	MOVW       R2, R16
;USART.c,23 :: 		while((UCSRA&0x40)==0x00);
L_tx_string8:
	IN         R16, UCSRA+0
	ANDI       R16, 64
	CPI        R16, 0
	BREQ       L__tx_string44
	JMP        L_tx_string9
L__tx_string44:
	JMP        L_tx_string8
L_tx_string9:
;USART.c,24 :: 		delay_ms(1000);
	LDI        R18, 41
	LDI        R17, 150
	LDI        R16, 128
L_tx_string10:
	DEC        R16
	BRNE       L_tx_string10
	DEC        R17
	BRNE       L_tx_string10
	DEC        R18
	BRNE       L_tx_string10
;USART.c,26 :: 		}
	JMP        L_tx_string6
L_tx_string7:
;USART.c,27 :: 		}
L_end_tx_string:
	RET
; end of _tx_string

_tx_num:
	PUSH       R28
	PUSH       R29
	IN         R28, SPL+0
	IN         R29, SPL+1
	SBIW       R28, 10
	OUT        SPL+0, R28
	OUT        SPL+1, R29
	ADIW       R28, 1

;USART.c,30 :: 		void tx_num(unsigned int num)
;USART.c,32 :: 		unsigned char paa=0, H=0,T=0,O=0;
	PUSH       R2
	PUSH       R3
;USART.c,33 :: 		paa=num/1000;
	LDI        R20, 232
	LDI        R21, 3
	MOVW       R16, R2
	CALL       _Div_16x16_U+0
	MOVW       R16, R24
	STD        Y+0, R16
;USART.c,35 :: 		H=(num-(paa*1000))/100;
	LDI        R17, 0
	LDI        R20, 232
	LDI        R21, 3
	CALL       _HWMul_16x16+0
	MOVW       R0, R16
	MOVW       R16, R2
	SUB        R16, R0
	SBC        R17, R1
	LDI        R20, 100
	LDI        R21, 0
	CALL       _Div_16x16_U+0
	MOVW       R16, R24
; H start address is: 22 (R22)
	MOV        R22, R16
;USART.c,36 :: 		T=(num -(paa*1000) -(H*100))/10;
	LDD        R16, Y+0
	LDI        R17, 0
	LDI        R20, 232
	LDI        R21, 3
	CALL       _HWMul_16x16+0
	MOVW       R18, R2
	SUB        R18, R16
	SBC        R19, R17
	STD        Y+8, R18
	STD        Y+9, R19
	LDI        R16, 100
	MUL        R22, R16
	MOVW       R16, R0
	STD        Y+6, R16
	STD        Y+7, R17
	MOVW       R0, R16
	MOVW       R16, R18
	SUB        R16, R0
	SBC        R17, R1
	PUSH       R22
	LDI        R20, 10
	LDI        R21, 0
	CALL       _Div_16x16_U+0
	MOVW       R16, R24
	POP        R22
; T start address is: 23 (R23)
	MOV        R23, R16
;USART.c,37 :: 		O=(num - (paa*1000) -(H*100) - (T*10));
	LDD        R20, Y+8
	LDD        R21, Y+9
	LDD        R18, Y+6
	LDD        R19, Y+7
	MOV        R19, R20
	SUB        R19, R18
	LDI        R18, 10
	MUL        R16, R18
	MOV        R16, R0
	MOV        R0, R16
	MOV        R16, R19
	SUB        R16, R0
	STD        Y+1, R16
;USART.c,39 :: 		if(paa!=0)
	LDD        R16, Y+0
	CPI        R16, 0
	BRNE       L__tx_num46
	JMP        L_tx_num12
L__tx_num46:
;USART.c,40 :: 		{tx_char(paa+48);}
	LDD        R16, Y+0
	SUBI       R16, 208
	MOV        R2, R16
	CALL       _tx_char+0
L_tx_num12:
;USART.c,42 :: 		if(H!=0)
	CPI        R22, 0
	BRNE       L__tx_num47
	JMP        L_tx_num13
L__tx_num47:
;USART.c,44 :: 		tx_char(H+48);}
	MOV        R16, R22
	SUBI       R16, 208
; H end address is: 22 (R22)
	MOV        R2, R16
	CALL       _tx_char+0
L_tx_num13:
;USART.c,46 :: 		tx_char(T+48);
	MOV        R16, R23
	SUBI       R16, 208
; T end address is: 23 (R23)
	MOV        R2, R16
	CALL       _tx_char+0
;USART.c,48 :: 		tx_char(O+48);
	LDD        R16, Y+1
	SUBI       R16, 208
	MOV        R2, R16
	CALL       _tx_char+0
;USART.c,50 :: 		}
L_end_tx_num:
	POP        R3
	POP        R2
	ADIW       R28, 9
	OUT        SPL+0, R28
	OUT        SPL+1, R29
	POP        R29
	POP        R28
	RET
; end of _tx_num

_rx_char:

;USART.c,53 :: 		unsigned char rx_char()
;USART.c,55 :: 		while((UCSRA&0x80)==0x00);
L_rx_char14:
	IN         R16, UCSRA+0
	ANDI       R16, 128
	CPI        R16, 0
	BREQ       L__rx_char49
	JMP        L_rx_char15
L__rx_char49:
	JMP        L_rx_char14
L_rx_char15:
;USART.c,56 :: 		return UDR;
	IN         R16, UDR+0
;USART.c,57 :: 		}
L_end_rx_char:
	RET
; end of _rx_char

_main:
	LDI        R27, 255
	OUT        SPL+0, R27
	LDI        R27, 0
	OUT        SPL+1, R27

;USART.c,60 :: 		void main()
;USART.c,63 :: 		DDRA = 0Xff;
	PUSH       R2
	PUSH       R3
	LDI        R27, 255
	OUT        DDRA+0, R27
;USART.c,65 :: 		uart_init();//configure serial port
	CALL       _uart_init+0
;USART.c,66 :: 		delay_ms(100);
	LDI        R18, 5
	LDI        R17, 15
	LDI        R16, 242
L_main16:
	DEC        R16
	BRNE       L_main16
	DEC        R17
	BRNE       L_main16
	DEC        R18
	BRNE       L_main16
;USART.c,68 :: 		tx_string("AT\n\r");        //to test whether the wifi module is working or not
	LDI        R27, #lo_addr(?lstr_1_USART+0)
	MOV        R2, R27
	LDI        R27, hi_addr(?lstr_1_USART+0)
	MOV        R3, R27
	CALL       _tx_string+0
;USART.c,69 :: 		delay_ms(1000);
	LDI        R18, 41
	LDI        R17, 150
	LDI        R16, 128
L_main18:
	DEC        R16
	BRNE       L_main18
	DEC        R17
	BRNE       L_main18
	DEC        R18
	BRNE       L_main18
;USART.c,71 :: 		tx_string("AT+RST\n\r");        //tests workingness and shows wendor name.
	LDI        R27, #lo_addr(?lstr_2_USART+0)
	MOV        R2, R27
	LDI        R27, hi_addr(?lstr_2_USART+0)
	MOV        R3, R27
	CALL       _tx_string+0
;USART.c,72 :: 		delay_ms(4000);
	LDI        R18, 163
	LDI        R17, 87
	LDI        R16, 3
L_main20:
	DEC        R16
	BRNE       L_main20
	DEC        R17
	BRNE       L_main20
	DEC        R18
	BRNE       L_main20
	NOP
;USART.c,74 :: 		tx_string("AT+CWMODE=2\n\r");                //to use the module as node
	LDI        R27, #lo_addr(?lstr_3_USART+0)
	MOV        R2, R27
	LDI        R27, hi_addr(?lstr_3_USART+0)
	MOV        R3, R27
	CALL       _tx_string+0
;USART.c,75 :: 		delay_ms(1000);
	LDI        R18, 41
	LDI        R17, 150
	LDI        R16, 128
L_main22:
	DEC        R16
	BRNE       L_main22
	DEC        R17
	BRNE       L_main22
	DEC        R18
	BRNE       L_main22
;USART.c,77 :: 		tx_string("AT+CIPMUX=1");                        //For TCP connction
	LDI        R27, #lo_addr(?lstr_4_USART+0)
	MOV        R2, R27
	LDI        R27, hi_addr(?lstr_4_USART+0)
	MOV        R3, R27
	CALL       _tx_string+0
;USART.c,78 :: 		delay_ms(1000);
	LDI        R18, 41
	LDI        R17, 150
	LDI        R16, 128
L_main24:
	DEC        R16
	BRNE       L_main24
	DEC        R17
	BRNE       L_main24
	DEC        R18
	BRNE       L_main24
;USART.c,80 :: 		tx_string("AT+CWSAP=\"HARSH\",\"12345678\",1,0");                        //For TCP connction
	LDI        R27, #lo_addr(?lstr_5_USART+0)
	MOV        R2, R27
	LDI        R27, hi_addr(?lstr_5_USART+0)
	MOV        R3, R27
	CALL       _tx_string+0
;USART.c,81 :: 		delay_ms(20000);
	LDI        R19, 4
	LDI        R18, 44
	LDI        R17, 175
	LDI        R16, 21
L_main26:
	DEC        R16
	BRNE       L_main26
	DEC        R17
	BRNE       L_main26
	DEC        R18
	BRNE       L_main26
	DEC        R19
	BRNE       L_main26
;USART.c,86 :: 		tx_string("AT+CIPSERVER=1,8080,1,3\n\r");
	LDI        R27, #lo_addr(?lstr_6_USART+0)
	MOV        R2, R27
	LDI        R27, hi_addr(?lstr_6_USART+0)
	MOV        R3, R27
	CALL       _tx_string+0
;USART.c,87 :: 		delay_ms(2000);
	LDI        R18, 82
	LDI        R17, 43
	LDI        R16, 0
L_main28:
	DEC        R16
	BRNE       L_main28
	DEC        R17
	BRNE       L_main28
	DEC        R18
	BRNE       L_main28
	NOP
	NOP
	NOP
	NOP
;USART.c,89 :: 		tx_string("AT+CIFSR\n\r");
	LDI        R27, #lo_addr(?lstr_7_USART+0)
	MOV        R2, R27
	LDI        R27, hi_addr(?lstr_7_USART+0)
	MOV        R3, R27
	CALL       _tx_string+0
;USART.c,90 :: 		delay_ms(10000);
	LDI        R19, 2
	LDI        R18, 150
	LDI        R17, 216
	LDI        R16, 9
L_main30:
	DEC        R16
	BRNE       L_main30
	DEC        R17
	BRNE       L_main30
	DEC        R18
	BRNE       L_main30
	DEC        R19
	BRNE       L_main30
	NOP
	NOP
;USART.c,92 :: 		while(1)
L_main32:
;USART.c,94 :: 		PORTA = 0XFF;
	LDI        R27, 255
	OUT        PORTA+0, R27
;USART.c,95 :: 		data1 = rx_char();
	CALL       _rx_char+0
; data1 start address is: 17 (R17)
	MOV        R17, R16
;USART.c,96 :: 		if(data1=='A')
	CPI        R16, 65
	BREQ       L__main51
	JMP        L_main34
L__main51:
; data1 end address is: 17 (R17)
;USART.c,98 :: 		PORTB = 0X01;
	LDI        R27, 1
	OUT        PORTB+0, R27
;USART.c,99 :: 		}
	JMP        L_main35
L_main34:
;USART.c,100 :: 		else if(data1 == 'B')
; data1 start address is: 17 (R17)
	CPI        R17, 66
	BREQ       L__main52
	JMP        L_main36
L__main52:
; data1 end address is: 17 (R17)
;USART.c,102 :: 		PORTB = 0X03;
	LDI        R27, 3
	OUT        PORTB+0, R27
;USART.c,103 :: 		}
	JMP        L_main37
L_main36:
;USART.c,104 :: 		else if(data1=='C')
; data1 start address is: 17 (R17)
	CPI        R17, 67
	BREQ       L__main53
	JMP        L_main38
L__main53:
; data1 end address is: 17 (R17)
;USART.c,106 :: 		PORTB = 0X07;
	LDI        R27, 7
	OUT        PORTB+0, R27
;USART.c,107 :: 		}
L_main38:
L_main37:
L_main35:
;USART.c,109 :: 		}
	JMP        L_main32
;USART.c,111 :: 		}
L_end_main:
	POP        R3
	POP        R2
L__main_end_loop:
	JMP        L__main_end_loop
; end of _main
