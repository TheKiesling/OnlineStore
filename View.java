/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    /**
    @author: José Pablo Kiesling Lange
    Program's name: View
    @version: 
        - Creation's date: 18/03/2022
        - Last modification: 18/03/2022

    I/O system to relate with the user
    */ 
    //---------------------------PROPERTIES---------------------------
    private Scanner scan;

    //---------------------------MÉTODOS------------------------------

    /*****************************************************************
     * instance the scanner
     */
    public View(){
        scan = new Scanner(System.in);
    }
    //****************************************************************

    /*****************************************************************
     * catch errors, and shows a message that share that error
     * @param s
     */
    public void error(String s){
        System.out.println(s); 
    }
    //****************************************************************

    /*****************************************************************
     * print a welcome message
     */
    public void welcome(){
        System.out.println("\nHi, Welcome to the Online Store :)");
    }
    //****************************************************************

    /*****************************************************************
     * ask the user what type of map wants to instance
     * @return the number of the option's instance
     * @throws InputMismatchException
     * @throws Exception
     */
    public int mapOption() throws InputMismatchException, Exception{
        int option = -1;
        boolean flag = false;

        try{
            //Map option's Menu
            System.out.println("Choose the option of the instance of the map");
            System.out.println("\n\n1. Hash Map");
            System.out.println("2. Tree Map");
            System.out.println("3. Linked Hash Map\n\n");

            while (!flag){ //Evaluate if the option is allowed
                option = Integer.parseInt(scan.nextLine());
                System.out.println();
                if (option > 0 && option <= 3) //OK option
                    flag = true;
                else{ 
                    System.out.println("ERROR: Choose a correct option"); 
                }
            }
        } catch (InputMismatchException e){ 
            String s = "ERROR: InputMismatch " + option + ": " + e.toString(); 
            throw new InputMismatchException(s);
        } catch (Exception e){ 
            String s = "ERROR: scan.nextInt() " +  option + ": " + e.toString();
            throw new Exception(s);
        }
        return option;
    }
    //****************************************************************

    /*****************************************************************
     * ask the user what action wants to do
     * @return the number of the option's instance
     * @throws InputMismatchException
     * @throws Exception
     */
    public int menu() throws InputMismatchException, Exception{
        int option = -1;
        boolean flag = false;

        try{
            //Option's Menu
            System.out.println("\n\nChoose the option of the action that you want to do");
            System.out.println("\n\n1. Add a product to your collection");
            System.out.println("2. Show a category for one product");
            System.out.println("3. Show all my products on collection");
            System.out.println("4. Show all my products on collection sorted by type");
            System.out.println("5. Show all the products on inventory");
            System.out.println("6. Show all the products on inventory sorted by type");
            System.out.println("7. Leave\n\n");

            while (!flag){ //Evaluate if the option is allowed
                option = Integer.parseInt(scan.nextLine());
                System.out.println();
                if (option > 0 && option <= 7) //OK option
                    flag = true;
                else{ 
                    System.out.println("ERROR: Choose a correct option"); 
                }
            }
        } catch (InputMismatchException e){ 
            String s = "ERROR: InputMismatch " + option + ": " + e.toString(); 
            throw new InputMismatchException(s);
        } catch (Exception e){ 
            String s = "ERROR: scan.nextInt() " +  option + ": " + e.toString();
            throw new Exception(s);
        }
        return option;
    }
    //****************************************************************

    /*****************************************************************
     * read the properties of a new product
     * @return
     */
    public String[] newProduct(){
        String[] product = new String[2];
        System.out.println("Insert the name of the product");
        String name = scan.nextLine();
        System.out.println("Insert the category of the product");
        String category = scan.nextLine();
        product[0] = name; product[1] = category;
        System.out.println(); 
        return product;
    }
    //****************************************************************

    public String searchProduct(){
        String product = "";
        System.out.println("Insert the name of the product");
        product = scan.nextLine();
        return product;
    }

    /*****************************************************************
     * print a text
     * @param posts
     */
    public void output(String text){
        System.out.println(text);
    }
    //****************************************************************

    /*****************************************************************
     * print a leave message
     */
    public void exit(){
        System.out.println("\nGoodbye :)");
    }
    //****************************************************************
}
