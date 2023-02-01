#include <stdio.h>
#include <string.h>
#include <ctype.h>

int compute_pi(int n){
    int i = 0;
    int bool = 0;
    int ph = 5;
    double pi = 0.6666;
    while (i<n){
        printf("%f , i = %d ||", pi, i );
        if(bool == 0){
            pi = (pi + (1/ph));
            ph = ph + 2;
            i++;
            bool = 1;

        }
        if(bool == 1){
            pi = (pi - (1/ph));
            ph = ph + 2;
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
    strcpy(student_names, name);
    i = strlen(name);
    
}
double compute_tax(int income, char *status, char state){
    double tax;
    if(state == "in"){
        if (*status == "s")
            {
            if (income < 40000)
            {
                tax = income/0.3;
            }
            if (income >= 40000)
            {
                tax = income/0.35;
            }
        }
        if (*status == "m")
            {
            if (income < 60000)
            {
                tax = income/0.2;
            }
            if (income >= 60000)
            {
                tax = income/0.25;
            }
        }
    }
    if (state == "out"){
        if (*status == "s")
            {
            if (income < 40000)
            {
                tax = income/0.27;
            }
            if (income >= 40000)
            {
                tax = income/0.32;
            }
        }
        if (*status == "m")
            {
             if (income < 60000)
            {
                tax = income/0.17;
            }
            if (income >= 60000)
            {
                tax = income/0.22;
            }
        }
    }
    return tax;
}
int quadratic(double a, double b, double c, double *solution1, double *solution2){

}
int sum_squares(int n){

}
void file_count(char *file, int *characters, int *blanks, int *lines){
    FILE *fp;
    char ch;
    fp = fopen(*file, "r");
    while(1){
        ch = fgetc(fp);
        if (ch == isalpha)
        {
            *characters++;
        }
        if (ch == isspace)
        {
            *blanks++;
        }
        if (ch == "\n")
        {
            *lines++;
        }
        if (ch == EOF)
        {
            *lines++;
            break;
        }
    }
    fclose(fp);

}
void file_sort(char *infile, char *outfile){
    char names[20][50];
    int student_id[50];
    double gpa[50];
    int count, i;
    char temp;
    char name [20];
    int blank;
    FILE *fp;
    fp = fopen(*infile, "r");
    count = fgetc(fp);
    while(fp != EOF){
        temp = fgetc(fp);
        if (temp == isalpha)
        {
            strcpy(name, temp);
        }
        if (temp == isblank)
        {
            blank++;
        }
        
        if (temp == isdigit && blank == 1)
        {
            student_id[i] = temp;
        }
        if (temp == isdigit && blank == 2)
        {
            gpa[i] = temp;
        }
        if (temp == '\n')
        {
            i++;
        }
    }

}
void file_student(char *infile){

}
int main(){
    int choice;
    int bool;
    printf("Please choose which fuction you would like to use:\n1: Computing Pi\n2: Computing Square\n3: Displaying Primes\n4: Processing Grades\n5: Computing tax\n6: Solving Quadratic\n7: Computing Sum Square\n8: Counting Files\n9: Sorting Files\n10: Student Files\n11: Quit\n");
    scanf("%d",choice);
    if (choice == 1)
    {
        int n;
            double sqr;
            int choice;
            printf("Enter in a number you would like to square");
            scanf("%d",n);
            sqr = compute_pi(n);
            printf("The pi of %d is; %f", n, sqr);
    }else
            printf("Thank you for using 'program.c' :)");

}
   