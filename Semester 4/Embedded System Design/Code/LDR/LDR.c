void ADC() org 0x020
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
        ADCSRA.B6=1; // After completion of earlier conversion, start                 //new conversion
}


int main()
{
    
    
    DDRA.B4=0;  // Set PinA.0 as input
    DDRB = 0XFF;
    ADMUX=0b00000100;      //Reference Voltage Vcc, Left Adjust, ADC0
    ADCSRA=0b10001111;     //ADC enable,ADC interrupt enable,Presclaer 128

    SREG.B7=1; // Global Interrupt enable

    ADCSRA.B6=1;  //Start ADC conversion
   // DDRD = 0x00;
}