void main(){
        DDRB = 0x3F;
        PORTB = 0X30;
     
     while(1) {

      PORTB |= 0x0A;
      Delay_ms(2000);
      PORTB &= 0xF0;

      PORTB |= 0x05;
      Delay_ms(2000);
      PORTB &= 0xF0;

      PORTB |= 0x02;
      Delay_ms(2000);
      PORTB &= 0xF0;

      PORTB |= 0x08;
      Delay_ms(2000);
      PORTB &= 0xF0;
     }
}