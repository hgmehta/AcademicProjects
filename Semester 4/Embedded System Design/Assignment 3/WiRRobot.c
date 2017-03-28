void USART_init()
{
// UCSRB = 0x98;
 //UCSRC = 0x86;
 //UBRRL = 0x33;
}

void intrrupt() org 0x1A
{
 unsigned char a;
 PORTB = 0x0F;
 delay_ms(10000);
 PORTB &= 0xF0;
 //a = UDR;
 if(a == '8')
 {
      PORTB |= 0x0A;
 }
 else if(a == '2')
 {
      PORTB |= 0x05;
 }
 else if(a == '4')
 {
      PORTB |= 0x02;
 }
 else if(a == '6')
 {
      PORTB |= 0x08;
 }
      Delay_ms(2000);
      PORTB &= 0xF0;
}

void main() {
     //int LDRvalue;ss
     USART_init();
     DDRB = 0x3F;
     PORTB = 0X30;
     PORTB = 0x0F;
     Delay_ms(10000);


     while(1) {

     }
}