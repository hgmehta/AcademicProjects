/*
 * Servo.c
 *
 * Created: 25-04-2016 19:01:53
 * Author : harsh
 */

#define servo_min 0.600       	//period in ms
#define servo_max 2.400       	//period in ms
#include<math.h>
float D;

void servo(float degree) {
	int cmpMatch;
	//degree= degree/2.0;
	//	fprintf(stdout,"/n/r %i \n\r",(int)degree);

	cmpMatch=  (int)(round( ( (float) (degree * (float) (servo_max - servo_min) / (float) 180.0) + servo_min) * 125) );

	//if (cmpMatch <= servo_max_ticks && cmpMatch >= servo_min_ticks) {	//Saftey Checking

	OCR1A= cmpMatch;
	//}

	//var "period" in miliseconds
	//OCR0A= (int)(round(period*62.5)  -1);
	//0   => 0.016ms
	//62  => 1.000ms
	//124 => 2.000ms
	//255 => 4.096ms
}

void changeDegree(unsigned char f)
{
	if(f == 0){
		D = D + 20;
		if(D > 180)
		{
			D = 180;
		}
	}
	else
	{
		D = D - 20;
		if(D <= 0)
		{
			D = 0;
		}
	}

}

int main(void) {
	DDRA = 0x00;
	DDRC = 0xFF;
	D = 90;
	TCCR1A|=(1<<COM1A1)|(1<<COM1B1)|(1<<WGM11);        //NON Inverted PWM
	TCCR1B|=(1<<WGM13)|(1<<WGM12)|(1<<CS11)|(1<<CS10); //PRESCALER=64 MODE 14(FAST PWM)
	ICR1 = 4999;  //fPWM=50Hz
	DDRD|=(1<<PORTD.B4)|(1<<PORTD.B5);   //PWM Pins as Output
	servo(D);

	while(1)
	{
		PORTA =  PINA & 0x0F;

		if(PORTA == 0x02)
		{
			PORTC = 0x35;
		}
		else if(PORTA == 0x08)
		{
			PORTC = 0x3A;
		}
		else if(PORTA == 0x06)
		{
			PORTC = 0x32;
		}
		else if(PORTA == 0x04)
		{
			PORTC = 0x38;
		}
		else if(PORTA == 0x01)
		{
			changeDegree(0);
			delay_ms(1000);
			servo(D);
		}
		else if(PORTA == 0x03)
		{
			changeDegree(1);
			delay_ms(1000);
			servo(D);
		}
	}
}