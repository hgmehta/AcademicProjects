/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Context Switch
 *
 * Created on 12 October, 2016, 11:47 AM
 */
#include <pthread.h>
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>
#include <iostream>
#include <queue>
#include <signal.h>
#include <errno.h>
#include <string.h>
#include <unistd.h>
#include "replaceValue.h"
#include "loadInstruction.h"
#include "decodeInstruction.h"
#include "threadQueueStructure.h"

using namespace std;

time_t current_time;


threadAttribute t[2];
volatile int running_threads = 0;
volatile int log_value = 0;
pthread_mutex_t running_mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_mutex_t log_mutex = PTHREAD_MUTEX_INITIALIZER;
long long int sum=0,mul=1;

struct fqueue{
	char *filenm;
	struct fqueue *q;
};

struct fqueue *proQ=NULL,*head=NULL;
void userDefinedSignal(int signal){

	if(SIGUSR1 == signal){
		pause();
	}
	if(SIGUSR2 == signal){
		kill(signal, SIGCONT);
	}
}

//struct logparameter{
//    int answer;
//    int pid;
//    FILE *ptr;
//};

int fetch(char *fileIn,int processID)
{
	FILE *fp= fopen(fileIn,"r");
	char ch='0',*tmp;
	int insSize=0;
	pthread_t insExe;int insStatus;
	
	while (ch != EOF)
	{	
		while(ch!='\n'){
			ch = getc(fp);	
			insSize++;	
		}
		fseek(fp,-(insSize),SEEK_CUR);
		tmp = (char *)malloc(insSize*sizeof(char));
		fread(tmp,insSize,sizeof(char),fp);
		pri((void *)tmp,processID);
		ch = getc(fp);
		insSize=1;
			
	}
	fclose(fp);
  return 0;
}

void *instructionRead(void * pv){

	pthread_t thread = (pthread_t) pv;
	pause();
        int i=0;
	while(1)
	{            
            //result=time(NULL);
            //sprintf(start_time[i],"%s",asctime(localtime(&result))); 
            //fetch("ins.txt",(int)(thread+1));
            //result=time(NULL);
            //sprintf(end_time[i],"%s",asctime(localtime(&result))); 
            //head=head->q;
            printf("Hello");
            sleep(1);
	}
	pthread_exit(NULL);
}

void error(int en, char *msg){
    printf("%d %s",en,msg);
}

//static void stack_attributes(pthread_attr_t *attr, char *prefix,int id){
//    int s;
//    size_t stack_size, guard_size;
//    void *stack_addr;
//    
//    s = pthread_attr_getguardsize(attr, &guard_size);
//    if (s != 0)
//        error(s, "error: thread attribute getguardsize fail");
//    
//    printf("%sGuard size of thread ID %d          = %d bytes\n", prefix,pthread_self(), guard_size);
//    if(id == 0){
//        t[0].nguard_size = guard_size;
//    }else{
//        t[1].nguard_size = guard_size;
//    }
//    s = pthread_attr_getstack(attr, &stack_addr, &stack_size);
//    if (s != 0)
//        error(s, "pthread_attr_getstack");
//
//    printf("%sStack address of thread ID %d       = %p", prefix,pthread_self(), stack_addr);
//    if(id == 0){
//        t[0].nstack_addr = stack_addr;
//        t[0].nstack_size = stack_size;
//    }else{
//        t[1].nstack_addr = stack_addr;
//        t[1].nstack_size = stack_size;
//    }
//    if (stack_size > 0)
//        printf(" (EOS = %p)", (char *) stack_addr + stack_size);
//    printf("\n");
//
//    printf("%sStack size of thread ID %d        = 0x%x (%d) bytes\n",
//            prefix,pthread_self(), stack_size, stack_size);
//}

//static void display_thread_attributes(pthread_t thread, char *prefix,int id){
//    
//    int s;
//    pthread_attr_t attr;
//    pthread_key_t key;
//    void *value;
//    
//    sched_param param;
//    int priority;
//    int policy;
//    int ret;
//    /* scheduling parameters of target thread */
//    ret = pthread_getschedparam (pthread_self(), &policy, &param);
//    /* schedule_priority contains the priority of the thread */
//    printf("\tPolicy of thread ID %d             = %s\n",pthread_self(),
//            (policy == SCHED_FIFO)  ? "SCHED_FIFO" :
//            (policy == SCHED_RR)    ? "SCHED_RR" :
//            (policy == SCHED_OTHER) ? "SCHED_OTHER" :
//            "???");
//    if(id == 0){
//        t[0].npolicy = policy;
//    }else{
//        t[1].npolicy = policy;
//    }
//    printf("\tPriority of thread ID %d           = %d\n",pthread_self(),param.__sched_priority);
//    /* key previously created */
//    if(running_threads == 1){
//        t[0].npriority = param.__sched_priority;
//    }else{
//        t[1].npriority = param.__sched_priority;
//    }
////    value = pthread_getspecific(key);
//    printf("\tThread ID           = %d\n",pthread_self());
//    if(id == 0){
//        t[0].nthread_id = pthread_self();
//    }else{
//        t[1].nthread_id = pthread_self();
//    }
//    s = pthread_getattr_np(thread, &attr);
//    if (s != 0)
//        error(s, "error: Thread get attribute fail");
//
//    stack_attributes(&attr, prefix,id);
//
//    s = pthread_attr_destroy(&attr);
//    if (s != 0)
//        error(s, "error: Thread attribute destroy");
//}

//void *thread_create1(void *arg){
//
//    int id = *(int *) arg;
//    pthread_mutex_lock(&running_mutex);
//    running_threads = 1;
//    id = 0;
//    pthread_mutex_unlock(&running_mutex);
//        while (running_threads > 0){
//           sleep(1);
//    }
//    
//    printf("Attributes of created thread1 :%d:\n",id);
//    display_thread_attributes(pthread_self(), "\t",id);
//    //exit(EXIT_SUCCESS);         /* Terminate all threads */
//}

//void *thread_create2(void *arg){
//    int id = *(int *) arg;
//    pthread_mutex_lock(&running_mutex);
//    running_threads = 0;
//    id = 1;
//    pthread_mutex_unlock(&running_mutex);
//    printf("Attributes of created thread2 : %d:\n",id);
//    display_thread_attributes(pthread_self(), "\t",id);
//}

int main()
{
    int s;
    proQ=(struct fqueue *)malloc(sizeof(struct fqueue));
    head=proQ;
    proQ->filenm="filein_1.txt";
    proQ->q = (struct fqueue *)malloc(sizeof(struct fqueue));
    proQ = proQ->q;
    proQ->filenm="filein_2.txt";
    proQ->q = (struct fqueue *)malloc(sizeof(struct fqueue));
    proQ = proQ->q;
    proQ->filenm="filein_3.txt";
    proQ->q = (struct fqueue *)malloc(sizeof(struct fqueue));
    proQ = proQ->q;
    proQ->filenm="filein_4.txt";
    proQ->q = (struct fqueue *)malloc(sizeof(struct fqueue));
    proQ = proQ->q;
    proQ->filenm="filein_5.txt";
    proQ->q = NULL;
    
    //queue <threadAttribute> threadQueue;
    pthread_t thr[2];
    pthread_attr_t attr;
    pthread_attr_t *attrp[2];
    attrp[0] = NULL;
    attrp[1] = NULL;
    
    	struct sigaction signal_action;
	memset(&signal_action, 0, sizeof(signal_action));
	signal_action.sa_handler = userDefinedSignal;

	sigaction(SIGUSR1, &signal_action, NULL);
	sigaction(SIGUSR2, &signal_action, NULL);

	pthread_t threads[2];
	threads[0] = 0;
	threads[1] = 0;

	pthread_t thread = 0;
    
//      pthread_create(&thr[0], attrp[0], thread_create1, &thread);
//      pthread_create(&thr[1], attrp[1], thread_create2, &thread);
//    for (int i = 0; i <= 1; i++)
//       pthread_join(thr[i], NULL);
//      
//      threadQueue.push(t[0]);
//      threadQueue.push(t[1]);
        printf("Hello");
      	for(thread = 0; thread < 2; thread++){

		int isSuccess = pthread_create(&threads[thread], NULL, instructionRead,(void *) thread);
		if(isSuccess){

			perror("Error: Problem while creating a thread");
			exit(1);
	    	}
	}

	sleep(1);
	for(thread = 0;thread<=2; thread++){

		if(thread == 2){

		thread = 0;
		}		

		int isSuccess = pthread_kill(threads[thread], SIGUSR2);
		if (isSuccess){

			perror("Error in resuming thread");
			exit(1);
		}

  		sleep(4);
                
		isSuccess = pthread_kill(threads[thread], SIGUSR1);
		if(isSuccess){

			perror("Error in blocking thread");
			exit(1);
		}

	}

//      threadAttribute t1 =  threadQueue.front();
      
//      printf("\npriority %d \nstack size 0x%x \nstack address = %p \nthread id = %d",t[0].npriority,t[0].nstack_size,t[0].nstack_addr,t[0].nthread_id);
//      printf("\nPolice ID %s", (t[0].npolicy == SCHED_FIFO)  ? "SCHED_FIFO" :
//            (t[0].npolicy == SCHED_RR)    ? "SCHED_RR" :
//            (t[0].npolicy == SCHED_OTHER) ? "SCHED_OTHER" :
//            "???");
//      printf("\nGuard size of thread ID          = %d bytes\n", t[0].nguard_size);
//      
//      printf("\npriority %d \nstack size 0x%x \nstack address = %p \nthread id = %d",t[1].npriority,t[1].nstack_size,t[1].nstack_addr,t[1].nthread_id);
//      printf("\nPolice ID %s", (t[1].npolicy == SCHED_FIFO)  ? "SCHED_FIFO" :
//            (t[1].npolicy == SCHED_RR)    ? "SCHED_RR" :
//            (t[1].npolicy == SCHED_OTHER) ? "SCHED_OTHER" :
//            "???");
//      printf("\nGuard size of thread ID          = %d bytes\n", t[1].nguard_size);
////    pause();    /* Terminates when other thread calls exit() */
}