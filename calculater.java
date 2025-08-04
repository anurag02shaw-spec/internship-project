import java.util.Scanner;

public class calculater {
    public static double add(double num1,double num2){
        return num1+num2;
    }
    public static double sub(double num1,double num2){
        return num1-num2;
    }
    public static double mul(double num1,double num2){
        return num1*num2;
    }
    public static double div(double num1,double num2){
        return num1/num2;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        boolean isrunning=true;
        while(isrunning){
            System.out.print("calculater menu\n");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.print("Choose an operation (1-5): ");
            int choose=sc.nextInt();
            if(choose==5){
                isrunning=false;
                System.out.println("good bye");
                break;
            }
            System.out.print("enter the 1st number= ");
            double num1=sc.nextInt();
            System.out.print("enter the 2nd number= ");
            double num2=sc.nextInt();
            double result=0;
             switch (choose){
                 case 1:
                     result=add(num1,num2);
                     break;
                 case 2:
                     result=sub(num1,num2);
                     break;
                 case 3:
                     result=mul(num1,num2);
                     break;
                 case 4:
                     result=div(num1,num2);
                     break;
                 default:
                     System.out.println("invalid number");
                     continue;
             }
             System.out.println("total result=" +result);


        }
    }
}
