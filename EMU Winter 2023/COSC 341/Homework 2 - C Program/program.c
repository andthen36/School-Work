#include <stdio.h>
#include <string.h>
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
    char name[20];
    char student_names[100];
    char quit[5] = "q";
    int score;
    int i = 0;
    printf("Please enter a students name and score (type q to quit)");
    scanf("%c, %d", name, score);
    student_names[i] = name;
    i = strlen(name);
    
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
    int choice = 0;
    int bool = 0;
    printf("Please choose which fuction you would like to use:\n1: Computing Pi\n2: Computing Square\n3: Displaying Primes\n4: Processing Grades\n5: Computing tax\n6: Solving Quadratic\n7: Computing Sum Square\n8: Counting Files\n9: Sorting Files\n10: Student Files\n11: Quit\n");
    scanf("%d",choice);
    switch (choice)
    {
        case 1:
            int n;
            long sqr;
            int choice;
            printf("Enter in a number you would like to square");
            scanf("%d",n);
            sqr = compute_pi(n);
            printf("The pi of %d is; %f", n, sqr);
            printf("Would you like to go back to the menu?\n1:Yes 2:No");
            scanf("%d",choice);
            break;
        case 2:
        case 3:
        case 4:
        case 5:
            int income;
            char[5] status;
            char[5] state;
            double tax;
            printf("Please enter your income amount\n");
            scanf("%d\n", income);
            printf("Please enter your marital status: S for Single or M for Married\n");
            scanf("%c\n", status);
            printf("Please enter your state status: In for 'in' State or Out for 'out' of State\n");
            scanf("%c\n", state);
            tax = compute_tax(income, status, state);
        case 6:
        case 7:
        case 8:
        case 9:
        case 10:
        case 11:
            break;
        default:
            printf("Invalid Option)");
    }
    printf("Thank you for using 'program.c' :)");
}