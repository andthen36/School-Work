#include <stdio.h>
#include <string.h>
#include <ctype.h>

int compute_pi(int n){
    int i = 1; //setting i as 1 so if the user only puts in one the whiel loop will notice and only print out pi as 1
    int bool = 1;
    int ph = 3;
    double pi = 1;
    while (i<n){ ///while i is less the n the loop will continue
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
    // Should be done and work
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
    char student_names[20][50];
    char quit[5] = "q";
    int score;
    int student_score[20];
    int i = 0;
    printf("Please enter a students name and score (type q to quit)");
    scanf("%c, %d", name, score);
    while (name == 'q' || name == 'Q'){
        stpcpy(student_names[i], name);
        student_score[i] = score;
        i++;
        printf("Please enter a students name and score (type q to quit)");
        scanf("%c, %d", name, score);
    }
    int min = 0;
    int max= 0;
    double average = 0;
    int sort;
    int count = 0;

    for(sort = 1; sort < i; sort++ ){
        if(student_score[sort] > student_score[max]){
            max = sort;
        }
    }
    printf("Student with the max score is %c with %d\n", student_names[max + 1], student_score[max]);

    for(sort = 1; sort < i; sort++ ){
        if(student_score[sort] < student_score[min]){
            min = sort;
        }
    }
    printf("Student with the min score is %c with %d\n", student_names[min + 1], student_score[min]);

    for(sort = 0; sort < i; sort++ ){
        sort = student_score[count] + sort;
        count++;
    }
    average = (sort/i);
    printf("The average score was %f", average);
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
    // needs to be reclusive
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
    char student_names[20][50];
    int student_id[50];
    double gpa[50];
    int count, i;
    char temp;
    char name [20];
    int blank;
    FILE *fp;
    fp = fopen(*infile, "r"); // Open File
    count = fgetc(fp); //count gets the number at the start of the page to know how many students their are
    while(fp != EOF){
        temp = fgetc(fp);
        if (temp == isalpha)
        {
            strcat(name, temp); //Copies characters to name to be help untile they are put in the array
        }
        if (temp == isblank)
        {
            blank++; //counting the blanks, 1 means id, 2 means gpa
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
            blank = 0;
            strcpy(student_names[i], name);
        }
        
    }
    // Need to sort the by id

    // After sorting output the number of students then print each student's info in ascending order by studentID

}
void file_student(char *infile){

}
int main(){
    int choice;
    printf("Please choose which fuction you would like to use:\n1: Computing Pi\n2: Computing Square\n3: Displaying Primes\n4: Processing Grades\n5: Computing tax\n6: Solving Quadratic\n7: Computing Sum Square\n8: Counting Files\n9: Sorting Files\n10: Student Files\n11: Quit\n");
    scanf("%d",choice);
    while(choice != 11){
        if (choice == 1){
            int n;
            double sqr;
            int choice;
            printf("Enter in a number you would like to square");
            scanf("%d",n);
            sqr = compute_pi(n);
        }

    
    }

}
   