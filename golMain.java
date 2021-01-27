
import java.util.Scanner;

//Evaan J
//Jan .12
//Game of life

public class golMain {

    public static Scanner scanner1 = new Scanner (System.in);
    
    public static void main (String [] args){

        //Creating an object 
        golMain table = new golMain(); 
        
        // Creating an integer to strore values
        int quit =0;
        int rowValue=0;
        int columnValue=0;
        int g =0;
        int w =0;
        int numOrganism=0;
        int genValue = 0;
        
        //Creating a 2d array
        int [][] cordinate1 = new int [0][0];

        //Seting an int equal to a method so it will run the code inside it 
        table.enter();
        rowValue = table.rowInput(0);
        columnValue = table.columnInput(0);
        numOrganism = table.numOrganisms (0);
        cordinate1 = table.create(rowValue,columnValue,numOrganism, cordinate1);
        genValue = table.gen(0);
        table.future(cordinate1,rowValue,columnValue);
        table.print(rowValue,columnValue,cordinate1);
        for(int j=0; j<genValue-1 ; j++){
        table.print(rowValue,columnValue,cordinate1);
        }
        
        
    }
    public void enter (){

        System.out.println("Welcome");  
    }
    public int rowInput(int r ){
        
        int x; 
        
        //Creatign a do - while loop to loop code under a circumstance
        do{
            x=0;
            
            //Adding try catch to catch invalid input by the user
            try{ 
                System.out.println("choose a number of rows");

                //Setting the scanner equal to a int so it can be used later on in the code
                r = scanner1.nextInt();
            
            //Making changes if invalid user input is given
            }catch(Exception e){
                System.out.println("Invalid input, please try again");
                x=1;
                scanner1.next();
            }
        }while(x==1);
        //Having a return statement
        return r;
        
    }
    public int columnInput(int c ){
        
        int x; 
        do{
            x=0;
            try{
                System.out.println("choose a number of columns");
                c = scanner1.nextInt();
            }catch(Exception e){
                System.out.println("Invalid input, please try again");
                x=1;
                scanner1.next();
            }
        }while(x==1);
        return c;
    }
    public int numOrganisms (int o){
        
        int x; 
        do{
            x=0;
            try{
                System.out.println("organisms");
                o = scanner1.nextInt();
            }catch(Exception e){
                System.out.println("Invalid input, please try again");
                x=1;
                scanner1.next();
            }
        }while(x==1);
        return o;
    }
    public int [][]create(int rowC,int colC, int n, int cor2[][]){
        
        cor2 = new int [rowC][colC];
      
        for(int w=0; w<n ; w++){
            int x; 
            do{
                x=0;
                try{
                    System.out.println("What is the row of organism" + (1+w) +" ?");
                    int rowUpdate = scanner1.nextInt();

                    System.out.println("What is the row of organism" + (1+w) +" ?");
                    int columnUpdate = scanner1.nextInt();

                    cor2[rowUpdate][columnUpdate] = 1;

                }catch(Exception e){
                    System.out.println("Invalid input, please try again");
                    x=1;
                    scanner1.next();
                }
            }while(x==1);
        }
        return cor2;
    }
    public void print (int rowP,int colP, int cor3[][]){
        
        for(int w=0; w<rowP ; w++){
            for(int j=0; j<colP ; j++){

                //Printing out the column values of row "w"
                System.out.print (cor3 [w][j]+"  ");
            }
            System.out.println();
            System.out.println();
        } 
    }
    public int gen (int g){
        
        int x;
        do{
            x=0;
            try{
                System.out.println("How many generations would you like to see?");
                g = scanner1.nextInt();

            }catch(Exception e){
                System.out.println("Invalid input, please try again");
                x=1;
                scanner1.next();
            }
        }while(x==1);
        return g;
    }
    public int [][] future (int cor3[][], int row, int col){
        
        
        int c=0;
        int h=0;
        int d=0;
        
        for(int p=0; p<row ; p++){
            for(int k=0; k<col ; k++){
                for(int j=-1; j<2 ; j++){
                    for(int i=-1; i<2 ; i++){
                        if (cor3[j][d-i]==1){
                            h = h+1;
                        }
                    }  
                } 

                if (h==2){
                    cor3[c][d]=1;
                }else if (h<1||h>2){
                    cor3[c][d]=0;
                }
            }
            d=d+1;
        }
        return cor3;
        
    }    
}
