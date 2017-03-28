/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   decodeInstruction.h
 * Author: harsh
 *
 * Created on 21 November, 2016, 1:14 PM
 */

#ifndef DECODEINSTRUCTION_H
#define DECODEINSTRUCTION_H

void pri(void *ins, int processID){
	
	char *instruction = (char *)ins;
	int i=0;
	while(instruction[i]!='\n'){
	i++;
	}
	instruction[i]='\0';
	int size=strlen(instruction);
	
	int j,var1 =0,var2 =0,var3;
	float var4=0.0;
	i=0;
	while(instruction[i]!=32){
	i++;
	}
	FILE *fptr;
	int insCode=load("inscode.txt",&instruction[0],i);
        switch(insCode){
	
		case 1:
		i++;
		j=i;
                while(instruction[i]!=' '){
                i++;
                }
                if(processID == 1){
                    var1 = load("/proc/1/variables.txt",&instruction[j],i-j);
                }
                else{
                    var1 = load("/proc/2/variables.txt",&instruction[j],i-j);
                }
		i++;
		j=i;
		while(instruction[i]!=32){
		i++;
		}
                if(processID == 1){
                    var2 = load("/proc/1/variables.txt",&instruction[j],i-j);
                }
                else{
                    var2 = load("proc/2/variables.txt",&instruction[j],i-j);
                }
		i++;
		j=i;
		while(instruction[i]!=32 && i<strlen(instruction)){
		i++;
		}
		var3 = var1+var2;
                //pthread_t logThreadId;
                //struct logparameter l;
                //l.answer = var3;
                //l.ptr = fptr;
                //l.pid = processID;
                time_t t;
                //pthread_create(&logThreadId,NULL,logThread,&l);
                if(processID == 1){
                    fptr = fopen("proc/1/rr_log.txt","a+");
                }
                else{
                    fptr = fopen("proc/2/rr_log.txt","a+");
                }
                if(fptr==NULL)
                {
                        printf("Error");
                        exit(1);
                }
                else
                {
                        time(&t);
                        fprintf(fptr,"%s Thread ID = %d i + j = %d\n",ctime(&t),processID,var3);
                }
                fclose(fptr);
                
		//here we need to write value of var3 inplace of "k" in resource.txt
		replaceVal(&instruction[j],var3,processID);
		break;
	}

}

#endif /* DECODEINSTRUCTION_H */

