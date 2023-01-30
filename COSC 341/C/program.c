#include <stdio.h>

int compute_pi(int n){
    int i = 0;
    int bool = 0;
    int ph = 5;
    double pi = 0.6666;
    while (i<n){
        printf("%f , i = %d ||", pi, i );
        if(bool == 0){
            pi = (pi + (1/ph));
            ph + 2;
            i++;
            bool = 1;

        }
        if(bool == 1){
            pi = (pi - (1/ph));
            ph + 2;
            i++;
            bool = 0;
        }
        
    }
    return 4 * pi;
}
double compute_sqrt(double x){
    int i;
    double next = 0;
    double last = x;

    if(x == 1){
     return 1;
    }  
    for(i = 0; i<10; i++){
        
        next = (0.5)*(last + x / last);
        last = next;
        
    }
    return last;
}
int is_prime(int n){
    int i, bool = 0;

    if(n == 0 || n == 1){
        bool = 1;
    }
    for(i =2; i <= n/2; i++){
        if(n % i == 0){
            bool =1;
        }
    }
    if(bool == 0){
        return 0;
        printf("%d is prime\n", n);
        display_prime(n);
    }else{
        return 1;
    }
}

int display_prime(int n){
int placeholder = 2;
int i;
    for(i = 2; i <= n; i++){
        if(placeholder % i != 0){
            printf("%d ,", placeholder);
        }
    }
}
void process_scores(){

}
double compute_tax(int income, char *status, char state){

}
int quadratic(double a, double b, double c, double *solution1, double *solution2){

}
int sum_squares(int n){

}
void file_count(char *file, int *characters, int *blanks, int *lines){

}
void file_sort(char *infile, char *outfile){

}
void file_student(char *infile){

}
int main(){
   
}