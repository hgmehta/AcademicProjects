
void USARTInit(int ubrr_value)
{

   //Set Baud rate

   UBRRL = ubrr_value;
   UBRRH = (ubrr_value>>8);

   /*Set Frame Format


   >> Asynchronous mode
   >> No Parity
   >> 1 StopBit

   >> char size 8

   */

   UCSRC=(1<<URSEL)|(3<<UCSZ0);


   //Enable The receiver and transmitter

   UCSRB=(1<<RXEN)|(1<<TXEN);


}


//This function is used to read the available data
//from USART. This function will wait untill data is
//available.
char USARTReadChar()
{
   //Wait untill a data is available

   while(!(UCSRA & (1<<RXC)))
   {
      //Do nothing
   }

   //Now USART has got data from host
   //and is available is buffer

   return UDR;
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

void main()
{
        char data1=0;
        int i,j;
        //this AT functions is for wifi serial transmmition
        USARTInit(51);
        delay_ms(100);
        tx_string("AT\n\r");        //to test whether the wifi module is working or not
        delay_ms(1000);
        tx_string("AT+RST\n\r");        //tests workingness and shows wendor name.
        delay_ms(4000);
        tx_string("AT+CWMODE=2\n\r");                //to use the module as node
        delay_ms(1000);
        tx_string("AT+CIPMUX=1");                        //For TCP connction
        delay_ms(1000);
        tx_string("AT+CWJAP=\"WIFINAME\",\"PASSWORD\"\n\r");                        //connecting to wifi haivng first paraeter as SSID and password
        delay_ms(20000);
        tx_string("AT+CIPSERVER=1,8080,1,3\n\r");
        delay_ms(2000);
        tx_string("AT+CIFSR\n\r");
        delay_ms(10000);

        DDRA=0XFF;
        DDRD=0X00;

        while(1)
        {

                data1 = USARTReadChar();
                if(data1 =='A')
                {
                    PORTA = 0X00;	//if 1 is sent lane 1 is open for 20 second
					delay_ms(20000);
                }
                else if(data1 == 'B')
                {
                    PORTA = 0X01;	//if 1 is sent lane 2 is open for 20 second
					delay_ms(20000);
                }

                else
                {
                 PORTA=0XFF;
                }
        }
}