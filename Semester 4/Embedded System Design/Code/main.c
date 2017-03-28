#define F_CPU 16000000
#include <avr/io.h>
#include <util/delay.h>

#define servo_min 0.600       	//period in ms
#define servo_max 2.400       	//period in ms
void Wait()
{
	uint16_t i;
	for(i=0;i<50;i++)
	{
		_delay_loop_2(0);
		_delay_loop_2(0);
		_delay_loop_2(0);
	}
}

// --- SERVO CONTROL -------------------------------------------
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

int main()
{
	//FOR TIMER1
	TCCR1A|=(1<<COM1A1)|(1<<COM1B1)|(1<<WGM11);        //NON Inverted PWM
	TCCR1B|=(1<<WGM13)|(1<<WGM12)|(1<<CS11)|(1<<CS10); //PRESCALER=64 MODE 14(FAST PWM)
	ICR1=4999;  //fPWM=50Hz
	DDRD|=(1<<PD4)|(1<<PD5);   //PWM Pins as Output
	while(1)
	{
		for(int i=0;i<=180;i++)
		{
			servo(i);
			_delay_ms(10);
		}
		for(int i=180;i>=0;i--)
		{
			servo(i);
			_delay_ms(5);
		}
		/*servo(0);   //0 degree
		Wait();
		servo(45);  //90 degree
		Wait();
		servo(90);   //0 degree
		Wait();
		servo(135);   //0 degree
		Wait();
		servo(180);  //180 degree
		Wait();*/
	}
	
	return 0;
}