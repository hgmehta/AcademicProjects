/*
 * Servo.c
 *
 * Created: 25-04-2016 19:01:53
 * Author : WIROBOT
 */ 
#define F_CPU 16000000
#include <avr/io.h>
#include <util/delay.h>
#include<avr/interrupt.h>
#define servo_min 0.600       	//period in ms
#define servo_max 2.400       	//period in ms

float D; //declaring global variable for change the degree of servo motor

void servo(float degree) {
	int cmpMatch; // for calculating the compare match value for OCR1A

	cmpMatch=  (int)(round( ( (float) (degree * (float) (servo_max - servo_min) / (float) 180.0) + servo_min) * 125) );

	OCR1A= cmpMatch;
}

void changeDegree(unsigned char f)
{
	if(f == 0){ // if flag is zero, motor will rotate 20 degree to the left 
		D = D + 20;
		if(D > 180) // max degree is 180
		{
			D = 180;
		}
	}
	else // if flag is not zero, motor will rotate 20 degree to the right
	{
		D = D - 20;
		if(D <= 0)
		{
			D = 0; // minmum degree is 0
		}
	}
	
}

ISR (ADC_vect)// org 0x020
{
	unsigned char low,high;
	int num;
	low = ADCL; //Diplay ADCL value @ PORTC
	high = ADCH; //Diplay ADCH value @ PORTB
	

	num = high;
	num = num << 8;
	num = num | low;
	num = num & 0X03FF;
	num = num * 4882.8;                        //(5/1024*1000) = 4.8828
	//for converting from scale 0-1024 to 0-5 with precition of 2, we multiply the number by 4.8828
	if(num < 3300)
	{
		PORTB = 0XFF;
	}
	else
	{
		PORTB = 0X00;
	}
	ADCSRA |= (1<<ADSC); // After completion of earlier conversion, start                 //new conversion
}

int main(void) {
	DDRA = 0x00; // PORT A as input
	DDRC = 0xFF; // PORT C as output
	DDRB = 0xFF; // PORT B as output
	D = 90; // intial position for servo motor is 90 degree
	TCCR1A|=(1<<COM1A1)|(1<<COM1B1)|(1<<WGM11);        //NON Inverted PWM
	TCCR1B|=(1<<WGM13)|(1<<WGM12)|(1<<CS11)|(1<<CS10); //PRESCALER=64 MODE 14(FAST PWM)
	ICR1=4999;  //fPWM=50Hz
	DDRD|=(1<<PD4)|(1<<PD5);       //PWM Pins as Output
	ADMUX=0xC0;      //Reference Voltage VCC, Left Adjust, ADC0
	ADCSRA=0b10001111;     //ADC enable,ADC interrupt enable, PRESCALER 128
	sei();
	ADCSRA |= (1<<ADSC);  //Start ADC conversion
	servo(D); // calling servo function to set servo motor at 90 degree
	
	//PORTC.4 and PORTC.5 is 1 for enable the motor driver
	
	// table for motor direction
	
	// PORTC.0  PORTC.1  PORTC.2  PORTC.3
	// 0        0        0        0          stop
	// 1        0        1        0          forward direction
	// 0        1        0        1          backward direction
	// 0        0        1        0          right turn
	// 1        0        0        0          left turn
	
	// table for user 
	// PORTA.0  PORTA.1  PORTA.2  PORTA.3
	// 0        0        1        0          for forward direction
	// 1        0        0        0          for backward direction
	// 0        1        1        0          for right turn
	// 0        1        0        0          for left turn
	// 0        0        0        0          to stop
	// 0        0        0        1          to rotate motor in left direction 
	// 0        0        1        1          to rotate motor in right direction
	
	while(1)
	{
		PORTA =  PINA & 0xF0; // considering 4 MSB as input 

		if(PORTA == 0x20) // if 2 is send by the user, car will run in forward direction
		{
			PORTC = 0x3A;
		}
		else if(PORTA == 0x80) // if 8 is sent by the user, car will run in backward direction
		{
			PORTC = 0x35;
		}
		else if(PORTA == 0x60) // if 6 is sent by the user, car will take right turn
		{
			PORTC = 0x32;
		}
		else if(PORTA == 0x40) // if 4 is sent by the user, car will take left turn
		{
			PORTC = 0x38;
		}
		else if(PORTA == 0xA0) // if 0 is sent by the user, car will stop
		{
			PORTC = 0x00;
		}
		else if(PORTA == 0x10) // if 1 is sent by the user, servo motor will rotate in left direction
		{
			changeDegree(0);
			_delay_ms(1000);
			servo(D);
		}
		else if(PORTA == 0x30) // if 3 is sent by the user, servo motor will rotate in right direction.
		{
			changeDegree(1);
			_delay_ms(1000);
			servo(D);
		}
	}
}