void uart_init()
{
        UCSRA=0x00;
        UCSRB=0x18;//if receive complete interupt enabled 0x98  //if disabled 0x18
        UCSRC=0x86;
        UBRRH=0x00;
        UBRRL=0X33;
        delay_ms(1000);
}

void tx_char(unsigned char uchar)
{
  UDR=uchar;
  while((UCSRA&0x40)==0x00);
  delay_ms(1000);
}

void tx_string(const unsigned char *ustring)
{
   while ( *ustring )
    {
         UDR=*ustring++;
         while((UCSRA&0x40)==0x00);
         delay_ms(1000);

    }
}


void tx_num(unsigned int num)
{
    unsigned char paa=0, H=0,T=0,O=0;
        paa=num/1000;

        H=(num-(paa*1000))/100;
        T=(num -(paa*1000) -(H*100))/10;
        O=(num - (paa*1000) -(H*100) - (T*10));

        if(paa!=0)
        {tx_char(paa+48);}

        if(H!=0)
        {
        tx_char(H+48);}

        tx_char(T+48);

        tx_char(O+48);

}


unsigned char rx_char()
{
  while((UCSRA&0x80)==0x00);
  return UDR;
}


void main()
{
        char data1;
        DDRA = 0Xff;

    uart_init();//configure serial port
    delay_ms(100);

        tx_string("AT\n\r");        //to test whether the wifi module is working or not
    delay_ms(1000);

        tx_string("AT+RST\n\r");        //tests workingness and shows wendor name.
        delay_ms(4000);

        tx_string("AT+CWMODE=2\n\r");                //to use the module as node
        delay_ms(1000);

        tx_string("AT+CIPMUX=1");                        //For TCP connction
        delay_ms(1000);
        
        tx_string("AT+CWSAP=\"HARSH\",\"12345678\",1,0");                        //For TCP connction
        delay_ms(20000);

        /*tx_string("AT+CWJAP=\"KISHAN\",\"12345678\"\n\r");                        //connecting to wifi haivng first paraeter as SSID and password
        delay_ms(20000);*/

        tx_string("AT+CIPSERVER=1,8080,1,3\n\r");
        delay_ms(2000);

        tx_string("AT+CIFSR\n\r");
        delay_ms(10000);

    while(1)
        {
                        PORTA = 0XFF;
                data1 = rx_char();
                if(data1=='A')
                {
                        PORTB = 0X01;
                }
                else if(data1 == 'B')
                {
                        PORTB = 0X03;
                }
                else if(data1=='C')
                {
                        PORTB = 0X07;
                }

        }

}