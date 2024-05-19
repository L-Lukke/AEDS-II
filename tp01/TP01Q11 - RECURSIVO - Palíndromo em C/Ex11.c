#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include <stdbool.h>

bool isPal(char* phrase, int count, bool answ){
    if (strlen(phrase)/2 < count)
        return answ;
    else if(phrase[count] == phrase[(strlen(phrase) - 2) - count])
            return isPal(phrase, ++count, answ);
        else
            return isPal(phrase, strlen(phrase) - 1, false);
}

bool isFim(char* phrase){
    if(strlen(phrase) == 4 && phrase[0] == 'F' && phrase[1] == 'I' && phrase[2] == 'M')
        return false;
    else 
        return true;
}

int main() {

    char phrase[100];
    bool answ;

    fgets(phrase, sizeof(phrase), stdin);
    setbuf(stdin, NULL);

    while(isFim(phrase)) {
    
        answ = isPal(phrase, 0, true);

        if(answ)
            printf("SIM\n");
        else
            printf("NAO\n");

        fgets(phrase, sizeof(phrase), stdin);
        setbuf(stdin, NULL);
    }
    
return 0;
}