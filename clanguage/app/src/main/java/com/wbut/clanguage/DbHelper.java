package com.wbut.clanguage;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "c";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    private static final String KEY_OPTD= "optd"; //option d
    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC +" TEXT, "+KEY_OPTD+" TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }
    private void addQuestions()
    {
		/*
		Question q1=new Question("the variable which can be accessed by all modules in a program, are know as?","d", "local variables", "internal variables", "external variables", "global variables");
		this.addQuestion(q1);
		Question q2=new Question("In what kind of storage structure for strings, one can easily insert, delete, concatenate and rearrange substrings??","c", "fixed length storage structure", "viriable length storage with fixed maximum", "linked list storage", "array type storage");
		this.addQuestion(q2);
		Question q3=new Question("which of the following operations is performed more efficiently by doubly linked list than by linear linked list??","a", "deleting a node whose location is given", "searhing an unsorted list for a given item", "inserting a node after the node with a given lcation", "traversing the list to process each node.");
		this.addQuestion(q3);
		Question q4=new Question("A linear list elements in which deletion can be done from one end (front) and insertion can take place only at the other end (rear) is known as?","a", "queues", "stacks", "tree", "queue");
		this.addQuestion(q4);
		Question q5=new Question("A linear list in which elements can be added or removed at either end but not in the middle is known as?","b", "queue", "deque", "stack", "tree");
		this.addQuestion(q5);
		*/


        Question q1=new Question(" Array can be initialized provided they are ","d", "automatic ", "external ", "static ", "both b and c ");
        this.addQuestion(q1);

        Question q2=new Question(" Array are passed as arguments to a function by","b", "value ", "reference ", "both a and b", "none of the above ");
        this.addQuestion(q2);

        Question q3=new Question(" It is necessary to declare the type of a function in the calling program if ","b", "the function returns an integer ", "the function returns a non-integer value", "the function is not defined in the same file", "none of the above");
        this.addQuestion(q3);

        Question q4=new Question(" The declaration void function 1 (int) indicates the function 1 is a function which","b", "has no arguments ", "returns nothing ", "both a and b ", "none of the above ");
        this.addQuestion(q4);

        Question q5=new Question(" Recursive functions are executed in a ","a", "last in first out order ", "first in first out order ", "parallel fashion ", "any one of the above");
        this.addQuestion(q5);

        Question q6=new Question(" When a function is recursively called, all automatic variables","a", "are initialised during each execution of the function ", "are retained from the last execution ", "are maintained in a stack", "none of the above ");
        this.addQuestion(q6);

        Question q7=new Question(" A static variable in a stack ","c", "which cannot be initialised ", "which is initialised once at the commencement of execution and cannot be changed at run time ", "retained its value throughout the life of the program ", "which is same as an automatic variable but is placed at the head of a program ");
        this.addQuestion(q7);

        Question q8=new Question(" An external variable is one ","d", "which is globally accessible by all functions", "has declaration 'extern' associated with it when declared within function ", "will be initialised to 0 if not initialised ", "all of the above");
        this.addQuestion(q8);

        Question q9=new Question(" # define max (x,y) x= (x,y)? x:y is a macro definition. Which can find the maximum of two numbers x and y if ","d", "x and y are both integers ", "x and y are both declared as float", "x and y are both declared as double ", "all the above are true");
        this.addQuestion(q9);

        Question q10=new Question(" Consider the macro definitions # define square(x) x*x and # define square(x) (x*x) when used in a program statement B = ++ square(C) ","b", "they will produce the same result ", "they will not produce same result ", "the second definition is not legal ", "none of the above is true ");
        this.addQuestion(q10);

        Question q11=new Question(" The following lines, if included in a program, will cause one of the following errors. Indicate the correct one. { double c; scanf('%c', c); } ","a", "runtime error ", "compilation error ", "typedef error ", "no error ");
        this.addQuestion(q11);

        Question q12=new Question(" A 'switch' statement is used to","c", "switch between functions in a program ", "switch from one variable to another variable ", "to choose from multiple possibilities which may arise due to different values of a single variable ", "to use switching variables ");
        this.addQuestion(q12);

        Question q13=new Question(" If the following variables are set to the values as shown below, then what is the value of the expression following it? answer = 2; marks = 10; !((answer < 5) (marks > 2))","b", "1", "0", "-1", "2");
        this.addQuestion(q13);

        Question q14=new Question(" The statement # include is written at the top of a program to indicate ","c", "the beginning of the program ", "the program does heavy mathematical calculations", "the certain information about mathematical library functions are to be include at the beginning of the program ", "none of the above");
        this.addQuestion(q14);

        Question q15=new Question(" If x and y are variables as declared below double x = 0.005, y = -0.01; What is the value of ceil(x+y), where ceil is a function to compute ceiling of a number?","b", "1", "0", "0.005", "0.5");
        this.addQuestion(q15);

        Question q16=new Question(" The for statement which can precede a loop to be executed 50 times or till a boolean variable 'found' become false is given by ","c", "for (i = 0; i <= 50 found == false; i++)", "for (i = 0; i < 50 found == true; i++) ", "for (i = 1; i <= 50 && found == true; i++)", "none of the above");
        this.addQuestion(q16);

        Question q17=new Question(" The declarations typedef float height [100]; height men, women; ","a", "define men and women as 100 element floating point arrays ", "define men and women as floating point variables ", "define height, men and women as floating point variables ", "are illegal ");
        this.addQuestion(q17);

        Question q18=new Question(" Consider the following declarations typedef struct { char name[20]; char middlename[5]; char surname[20];} NAME NAME class [20]; ","b", "class is an array of 20 characters only", "class is an array of 20 names where each name consists of a name, middlename and surname ", "class is a new type ", "none of the above");
        this.addQuestion(q18);

        Question q19=new Question(" What would be the values assigned to a, b, c if the statement scanf ('%d %d %d', &a,&b,&c) is extended with input data item 123456?","c", "a=12, b=34, c=56", "a=1, b=2, c=3", "a=123456 and nothing is assigned to b and c ", "a and b are not assigned anything, c=123456");
        this.addQuestion(q19);

        Question q20=new Question(" What would be the values assigned to a, b and c if the statement scanf ('%3d %3d %3d', &a,&b,&c) is extended with input data item 1234b5678b9 (b denotes blank)?","a", "a=123. b=4, c=567", "a=123, b=567, c=9", "a=123, b=456, c=789", "a=1234, b=5678, c=9");
        this.addQuestion(q20);

        Question q21=new Question(" What would be the values of i, x and c if scanf ('%3d %5f %c', &i,&x,&c) is extended with input data 10b256.875bT ?","d", "i=10, b=56.875, C = T", "i=100, b=256.87, C = T", "i=010, b=256.87, C = '5'", "i=10, b=256.8, C = '7'");
        this.addQuestion(q21);

        Question q22=new Question(" What would be the assignments if char s[100]; int d; float f; scanf ('%s, %*d, %f', s, &d, &f) is executed with input data fastener b12345b5","c", "s= 'fastener', d= 12345, f= 0.05", "s= 'fastener', d= 123*45, f= 0.05", "s= 'fastener', f= 0.05", "s= 'fastener', d= 0.05");
        this.addQuestion(q22);

        Question q23=new Question(" The function fprintf is used in a program ","c", "when too many printf calls have been already used in the program ", "in place of printf, since printf user more memory ", "when the output is to be printed on to a file ", "when the type of the variable to be printed are not known ");
        this.addQuestion(q23);

        Question q24=new Question(" In the following statement fprintf(fpt, '%n', i), the variable fpt is ","c", "a character variable ", "arbitrarily assigned a value ", "a pointer to a file ", "a special kinf of variable called 'file'");
        this.addQuestion(q24);

        Question q25=new Question(" If i, j, k are integers, the scanf function to enter i, j, k such that i is decimal, j is octal and k is hexadecimal would be ","c", "scanf ('%x %x %8x', i,j,k) ", "scanf ('%d %o %x', i,j,k) ", "scanf ('%d %o %x', &i, &j, &k) ", "scanf ('%d %8d %16d', &i, &j, &k) ");
        this.addQuestion(q25);

        Question q26=new Question(" How many times will the following loop be executed if the input data item is 01234? while (c=getchar() !=0) { }","a", "infinitely ", "never ", "once ", "5 times ");
        this.addQuestion(q26);

        Question q27=new Question(" The declaration 'unsigned u' indicates ","b", "u is an unsigned character ", "u is an unsigned integer ", "u is a character ", "none of the above ");
        this.addQuestion(q27);

        Question q28=new Question(" A declaration 'short int' is used for variables ","c", "which have a short duration in a program ", "which have short names ", "which may require less storage than normal integers ", "all of the above ");
        this.addQuestion(q28);

        Question q29=new Question(" In case of ordinary int variable ","a", "the leftmost bit is reserved for sign", "the rightmost bit is reserved for sign ", "no bit is reserved for sign ", "none of the above");
        this.addQuestion(q29);

        Question q30=new Question(" If an integer occupies 4 bytes and a character occupies 1 bytes of memory, each element of the following structure would occupy how many bytes? struct name { int age; char name[20]; }","b", "5", "24", "21", "22");
        this.addQuestion(q30);

        Question q31=new Question(" The library function sqrt operates on a double precision argument. If i is an integer variable, which one of the following calls would correctly computer sqrt(i)? ","a", "sqrt ((double)i)", "(double) sqrt(i)", "(double)(sqrt(i))", "sqrt(i)");
        this.addQuestion(q31);

        Question q32=new Question(" If a=-11 and b=-3. What is the value of a%b?","b", "-3", "-2", "2", "3");
        this.addQuestion(q32);

        Question q33=new Question(" What is the value of u1 and u2? int u1, u2; int v=3; int *pv; u1=2*(v+5); pv=&v; u2=2*(*pv+5);","a", "u1=16, u2=16", "u1=8, u2=16", "u1=16, u2=3", "u1=8, u2=3");
        this.addQuestion(q33);

        Question q34=new Question(" Suppose i,j,k are integer variable with values 1,2,3 respectively. What is the value of the expression: !((j + k)>(i + 5)) ? ","c", "5", "0", "1", "6");
        this.addQuestion(q34);

        Question q35=new Question(" Suppose i=7, f=5.5 and c='W'. What is the value of the expression: (c !='p' i + f <=10)? ","a", "1", "0", "-1", "not defined ");
        this.addQuestion(q35);

        Question q36=new Question(" If ASCII code of '0' is 48. What is the value of: toascii ('2')? ","d", "48", "2", "0", "50");
        this.addQuestion(q36);

        Question q37=new Question(" The function islower(char) check whether a character is in lower case or not. Therefore it should return ","a", "0 or 1", "-1, 0 or 1", "a character ", "nothing ");
        this.addQuestion(q37);

        Question q38=new Question(" If S is an array of 80 characters, then the value assigned to S through the statement scanf('%s',S) with input 12345, would be","a", "'12345'", "nothing since 12345 is an integer ", "S is an illegal name for a string ", "%s cannot be used for reading in values of S");
        this.addQuestion(q38);

        Question q39=new Question(" The function fopen('filename', 'r') returns","c", "nothing ", "a value 0 or 1 depending on whether the file could be opened or not.", "a pointer to FILE filename, if it exits ", "a pointer to a new file after creating it.");
        this.addQuestion(q39);

        Question q40=new Question(" The expression (((fpt=fopen ('samples', 'w')) == NULL) would be true if","b", "the file sample dose not exist while fopen is being executed ", "the file 'sample' could not be created for writing ", "fpt is not declared as a FILE pointer ", "the file 'sample' is ready only");
        this.addQuestion(q40);

        Question q41=new Question(" If a is a unsigned integer variable whose value is hx6db7, what is the value of ~a?","d", "h11hhhh1", "hxhh1", "hx248", "hx9248");
        this.addQuestion(q41);

        Question q42=new Question(" If a=0x6db7 and b=0xa726, what is the value of a & b? ","d", "0xca91", "0x6db7", "0xab92", "0x2526");
        this.addQuestion(q42);

        Question q43=new Question(" If a=0x6db7 and b=0xa726, what is the value of a^b? ","b", "0x58d9", "0xa91", "0xceb7", "0x2526");
        this.addQuestion(q43);

        Question q44=new Question(" The expression a << 6 shifts all bits of a six places to the left. If a 0x6db7, what is the value of a << 6?","c", "0xa72b", "0xa2b", "0x6dc0", "0x1111");
        this.addQuestion(q44);

        Question q45=new Question(" The expression a >> 6 shifts all bits of a six places to the right. What is the value of a >> 6 if a = 0x6db7?","d", "0x1234", "0x0001", "0x0000", "0x1b6");
        this.addQuestion(q45);

        Question q46=new Question(" The declaration union id { char color [12]; int size;} shirt, pant; denotes shirt and pant are variables of type id and ","b", "each can have a value of color and size ", "each can represent either a 12-character color or a integer size at a time ", "shirt and pant are same as struct variables", "variable shirt and pant cannot be used simultaneously in a statement");
        this.addQuestion(q46);

        Question q47=new Question(" Identify the most appropriate sentence to describe unions ","b", "unions are like structures ", "unions contain members of different data types which share the same storage area in memory ", "unions are less frequently used in programs ", "unions are used for set operations ");
        this.addQuestion(q47);

        Question q48=new Question(" Consider the following declaration enum colors {black, blue, green}; This represents ","1", "black = 0, blue = 1, green = 2", "color[1] = 'black', color[2] = 'blue', color[3] = 'green'", "color = 'black' or color = 'blue' or color = 'green'", "none of the above");
        this.addQuestion(q48);

        Question q49=new Question(" With the following declaration enum color {black=-1 blue, green}","c", "black=-1, blue=2, green=3", "black=-1, blue=-2, green=-3", "black=-1, blue=0, green=1", "this is an illegal declaration ");
        this.addQuestion(q49);

        Question q50=new Question(" If a=Oxaa and b=a<<1then","b", "b=a", "b=2a", "a=2b", "b=a-1");
        this.addQuestion(q50);

        Question q51=new Question(" The function sprintf() works like printf(), but operates on -","d", "data in a file", "stderr", "stdin", "string");
        this.addQuestion(q51);

        Question q52=new Question(" If the space occupied by two string s1 in 'C' are respectively m and n, the space occupied by the string obtained by concatenating s1 and s2 is always ","a", "less then m+n", "wqual to m+n", "grater than m+n ", "none of the above ");
        this.addQuestion(q52);

        Question q53=new Question(" Which of the following 'C' type is not a primitive data structure?","d", "int ", "float ", "char", "none of the above");
        this.addQuestion(q53);

        Question q54=new Question(" Suppose DATA array contains 1000000 elements. Using the binary search algorithm, one requires only about n comparisons to find the location of an item in the DATA array, them n is","d", "10", "45", "20", "none of these ");
        this.addQuestion(q54);

        Question q55=new Question(" If the address of the 8th element in a linked list of integers is 1022, then the address of 9th element is ","d", "1024", "1026", "1023", "none of these ");
        this.addQuestion(q55);

        Question q56=new Question(" What dose the following program statement do on executing the following statement under MD-DOS environment? f1 = fopen('c:\new\tools.dat','wb') ","a", "opens file tools.dat in the directory ", "return NULL, because the path name in improper. ", "give syntax error, because the mode of the opening is improper. ", "none of the above ");
        this.addQuestion(q56);

        Question q57=new Question(" Which of the following constants dose not produce over flow when assigned to an unsigned long integer variable? i) OXFFFFFFFF ii) 42949672961 iii) 07777777777","a", "all of them ", "only i and iii", "only i and ii", "none of them");
        this.addQuestion(q57);

        Question q58=new Question(" Assume that i,j and k are integer variable and their values are 8,5 and 0 respectively. What will be the values of variables i and k after executing the following expressions? k=(j>=5)?(i<5)? i-j-i: k-j: i; i+ = (k)?(i)?(j):(i):(k);","d", "-3 and 3", "3 and -5", "3 and -3", "-5 and 3");
        this.addQuestion(q58);

        Question q59=new Question(" The library function exit() cause an exit from","d", "the loop in which it occurs ", "the block in which it occurs ", "the function in which it occurs ", "none of these ");
        this.addQuestion(q59);

        Question q60=new Question(" The getch() library function ","b", "returns character when any key is pressed ", "returns a character when enter is pressed ", "returns and displays a character on the screen when any key is pressed ", "returns none of the above ");
        this.addQuestion(q60);

        Question q61=new Question(" A default argument has a value that ","a", "may be supplied by the calling program or function ", "related data items and variables ", "integer with user defined names ", "none of them ");
        this.addQuestion(q61);

        Question q62=new Question(" A structure brings together a group of ","b", "items of the same data type ", "related data items and variables ", "integer with user defined names ", "none of them ");
        this.addQuestion(q62);

        Question q63=new Question(" The && and operators ","c", "compare two numeric values ", "combine two numeric values ", "compare two boolean values ", "perform none of the above ");
        this.addQuestion(q63);

        Question q64=new Question(" The break statement causes an exit ","c", "only the innermost loop", "only from the innermost switch ", "from the innermost loop or switch ", "none of the above ");
        this.addQuestion(q64);

        Question q65=new Question(" In a for loop with a multi statement loop body, semicolons should appear following ","c", "the for statement itself ", "the crossing brace in the multiple statement loop body ", "each statement within the loop body and the test expression ", "none of the above ");
        this.addQuestion(q65);

        Question q66=new Question(" When an array name is passed to a function, the function ","a", "accesses exactly the same array with the same name as the calling program ", "accesses a copy of the array passed by the program ", "refers to the array using the same name as that used by the calling program ", "dose none of the above ");
        this.addQuestion(q66);

        Question q67=new Question(" The first element in a string is ","b", "the name of the string ", "the first character in the string ", "the length of the above ", "none of the above ");
        this.addQuestion(q67);

        Question q68=new Question(" A pointer is ","a", "address of a variable ", "an indication of the variable to be accessed next. ", "a variable for storing address ", "none of the above ");
        this.addQuestion(q68);

        Question q69=new Question(" Static int *(*name []) ()","a", "name is an array of pointers to function returning pointer to static integer ", "name is a static array of pointers to function returning pointer to integer ", "name is function returning pointer to array of pointers to static integer ", "none of these");
        this.addQuestion(q69);

        Question q70=new Question(" If an array is used as a function argument, the array is passed ","b", "by value ", "by reference ", "none of the above, as array cannot be used a function argument ", "call by name ");
        this.addQuestion(q70);

        Question q71=new Question(" A data file must be closed using ","c", "library function fprint()", "exit function ", "library function fclose()", "none of the above ");
        this.addQuestion(q71);

        Question q72=new Question(" An existing data file (fold) will be opened for both reading and appending by the following four of the function call --","a", "fclose ('fold', a+);", "fopen ('fold', r+);", "fopen ('fold', w+);", "fopen ('fold', a+);");
        this.addQuestion(q72);

        Question q73=new Question(" The statement FILE *fpt; ","a", "defines a pointer to pre-defined structure type FILE ", "defines a pointer to user defined structure type FILE ", "defines a points to pre-defined data type FILE DESCRIPTOR ", "none of the above ");
        this.addQuestion(q73);

        Question q74=new Question(" The functions fgets and fputs ","a", "reads and write strings from or to data files ", "reads and write strings from or to input / output streem ", "reads and write records from or to data files ", "none of the above ");
        this.addQuestion(q74);

        Question q75=new Question(" When one-dimensional character array of unspecified length is assigned an initial value ","b", "an arbitiary character is automatically added to the end of the string ", "'10' is added to the end of the string ", "length of the string is added to the end of the string ", "any of the above ");
        this.addQuestion(q75);

        Question q76=new Question(" When multidimensional arrays are assigned initial value ","a", "rightmost subscript increases most rapidly ", "leftmost subscript increases most rapidly ", "rightmost subscript increases least ", "any of the above ");
        this.addQuestion(q76);

        Question q77=new Question(" In order to check whether an input character is a vowel or not, an efficient multiway decision making routine can be written using ","b", "while loop ", "switch ", "if - then - else ", "none of the above ");
        this.addQuestion(q77);

        Question q78=new Question(" Enumeration variables can be used in ","a", "search statement like a integer variable ", "break statement ", "preprocessor commands ", "all of the above ");
        this.addQuestion(q78);

        Question q79=new Question(" # define preprocessor command can be used for defining ","d", "mecros ", "for loop ", "symbolic constants ", "both (a) and (c)");
        this.addQuestion(q79);

        Question q80=new Question("If you want to store dissimilar data together, then which type you will use??","b", "array", "structure", "stack", "None of the above.");
        this.addQuestion(q80);
        Question q81=new Question("Identify the wrong syntax ?","d", "typedef struct { member declaration; } NAME; NAME V1, V2;", "typedef struct tag{ member declaration; } NAME; NAME V1, V2;", "typedef struct { member declaration; } NAME; NAME V1, V2;", "typedef struct tag { member declaration; } NAME; NAME V1, V2;");
        this.addQuestion(q81);
        Question q82=new Question("What is the default return-type of getchar()? ?","b", "char", "int", "char *", "Reading character doesn't require a return-type");
        this.addQuestion(q82);
        Question q83=new Question("Which of the following cannot be checked in a switch-case statement??","c", "Character", "Integer", "Float", "enum");
        this.addQuestion(q83);
        Question q84=new Question("The function that calls itself for its processing is known as.?","d", "Inline Function", "Nested Function", "Overloaded Function", "Recursive Function");
        this.addQuestion(q84);
        Question q85=new Question("Array index always start from ?","a", "0", "1", "2", "3");
        this.addQuestion(q85);
        Question q86=new Question("In c programming a function can return ___________?","a", "Single value", "Double value", "Many value", "all of the above");
        this.addQuestion(q86);
        Question q87=new Question("How can one convert numbers to strings??","c", "Using atoi()", "Using printf()", "Using sprint()", "Using nsprintf()");
        this.addQuestion(q87);
        Question q88=new Question("What is the purpose of fflush() function? ?","a", "flushes all streams and specified streams.", "flushes only specified stream.", "flushes input/output buffer.", "flushes file buffer.");
        this.addQuestion(q88);
        Question q89=new Question("What function should be used to free the memory allocated by calloc() ??","c", "dealloc();", "malloc(variable_name, 0)", "free();", "memalloc(variable_name, 0)");
        this.addQuestion(q89);
        Question q90=new Question("Which is not a storage class??","b", "Auto", "Struct", "Typedef", "Static");
        this.addQuestion(q90);
        Question q91=new Question("Which of the following is TRUE about argv??","a", "It is an array of character pointers", "It is a pointer to an array of character pointers", "It is an array of strings", "None of above");
        this.addQuestion(q91);
        Question q92=new Question("Queue can be used to implement?","a", "Radix sort", "Quick sort", "Recursion", "Depth first search");
        this.addQuestion(q92);
        Question q93=new Question("The compiler will give an error if we attempt to get the address of a variable with _________ storage class.?","a", "register keyword", "extern keyword", "static keyword", "auto keyword");
        this.addQuestion(q93);
        Question q94=new Question("To use the function tolower(), which of the following header file should be used?","c", "string.h", "conio.h", "ctype.h", "None of the mentioned");
        this.addQuestion(q94);
        Question q95=new Question("Which of the following statement is or are correct??","c", "Default initial value of static integral type variables is zero.", "A same static variable can be declared many times but we can initialize at only one time.", "Option A and B are correct.", "None of the above.");
        this.addQuestion(q95);
        Question q96=new Question("A pointer in c which has not been initialized is known as?","d", "far pointer", "void pointer", "null pointer", "wild pointer");
        this.addQuestion(q96);
        Question q97=new Question("Which of the following does not represent a valid storage class in c??","b", "static", "union", "extern", "automatic");
        this.addQuestion(q97);
        Question q98=new Question("Which operation can be applied to pointer variable??","c", "Multiplication", "Division", "Addition", "All of the above");
        this.addQuestion(q98);
        Question q99=new Question("Which of the following operation can be applied to pointer variable??","c", "Multiplication", "Division", "Addition", "All of the above");
        this.addQuestion(q99);
        Question q100=new Question("What is a null pointer??","d", "Null pointer is a pointer which is pointing to nothing", "Null pointer points the base address of segment", "Pointer which is initialized with NULL value is considered as NULL pointer", "All of the above");
        this.addQuestion(q100);



    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quest.setOPTD(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
