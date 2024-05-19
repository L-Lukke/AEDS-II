#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include <stdbool.h>

void invert(char* phrase, char* inverted, int size){
    int i;
    int tmp = size-2;

    for(int i=0; i<size; i++, tmp--)
        inverted[i] = phrase[tmp];
}

bool isPal(char* phrase, char* inverted, int size){
    bool answ = true;

    for (int i=0; i<size--; i++){
        if(!(phrase[i] == inverted[i]))
            answ = false;
    }

    return answ;
}


bool isFim(char* phrase){
    if(strlen(phrase) == 4 && phrase[0] == 'F' && phrase[1] == 'I' && phrase[2] == 'M')
        return false;
    else 
        return true;
}

int main(){

    char inverted[100], phrase[100];
    int size;
    bool answ;

    fgets(phrase, sizeof(phrase), stdin);

    while(isFim(phrase)) {
        
        size = strlen(phrase);
        setbuf(stdin, NULL);
        invert(phrase, inverted, size);
    
        answ = isPal(phrase, inverted, size);

        if(answ)
            printf("SIM\n");
        else
            printf("NAO\n");

        fgets(phrase, sizeof(phrase), stdin);
    }
    
return 0;
}