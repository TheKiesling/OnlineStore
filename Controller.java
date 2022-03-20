/*
#      #    #######    ########   #######   #          #######   ##      #    #########
#     #        #       #          #         #             #      # #     #    #
#    #         #       #          #         #             #      #  #    #    #
####           #       #####      #######   #             #      #   #   #    #    ####
#    #         #       #                #   #             #      #    #  #    #       #
#     #        #       #                #   #             #      #     # #    #       #
#      #    ########   ########   #######   ########   #######   #      ##    #########
*/

public class Controller {
    /**
    @author: José Pablo Kiesling Lange
    Program's name: Controller
    @version: 
        - Creation's date: 18/03/2022
        - Last modification: 18/03/2022

    Control the model and relate with the view
    */ 

    public static void main(String[] args){
        View view = new View();
        try {
            int mapOption = view.optionMap();
            Store onlineStore = new Store(mapOption);
            int option;
            while(option != 7){
                String result;
                switch(option){
                    case 1:
                        String[] product = view.newProduct();
                        result = onlineStore.newProduct(product[0], product[1]);
                    break;
                    case 2:
                        String nameProduct = view.searchProduct();
                        result = onlineStore.searchCategory(nameProduct);
                    case 7:
                        view.exit();
                    break;
                    default:
                        result = onlineStore.showProducts(option, mapOption);
                    break;
                    view.output(result);
                }
            }
        } catch (Exception e) {
            String s = "ERROR: " + e.getMessage();
            view.error(s);
        }
    }
}
