/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   repalceValue.h
 * Author: harsh
 *
 * Created on 21 November, 2016, 1:11 PM
 */

#ifndef REPLACEVALUE_H
#define REPLACEVALUE_H

void replaceVal(char *instruction, int value,int processID)
{
	int len = strlen(instruction);
        FILE *re;
        if(processID == 1){
            re = fopen("proc/1/variables.txt","r");
        }
        else{
            re = fopen("proc/2/variables.txt","r");
        }
	char c=getc(re);
	int count=1;
	while(c!=EOF)
	{c=getc(re);count++;
	}
	rewind(re);
	char *buff = (char *)malloc(count*sizeof(char));
	int i=1,j=0,k=0,l=0;
	
	for(i = 0;i<count;i++)
	buff[i]=getc(re);
	fclose(re);
	
	for(i=0,j=0;j<count-1;j++)
	{
		
		if(buff[j]==instruction[i])
		{
			k++;i++;
			if(k==len && buff[j+1]==' ')
			{
				j-=(k-1);
				while(buff[j]!='\n' )
				{
					buff[j]='*';
					j++;
				}
				buff[j]='*';
				
			}
		}
		else
		{
			while(buff[j]!='\n' )
			j++;
			i=0;
			k=0;
		}
	}
	
	if(processID == 1){
            re = fopen("proc/1/variables.txt","w");
        }
        else{
            re = fopen("proc/2/variables.txt","w");
        }
	
	i=0;
	for(i=0;i<len;i++)
	fputc(instruction[i],re);
	fprintf(re," %d\n",value);
	
	i=0;
	c=buff[i];
	while(c!=EOF)
	{
		while(c=='*')
		{
			i++;
			c=buff[i];
		}
		fputc(c,re);
		i++;
		c=buff[i];
	}
	fclose(re);
	
	
}


#endif /* REPALCEVALUE_H */

