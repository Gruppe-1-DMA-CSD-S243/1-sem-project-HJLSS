package ui;

public class MainTUI {
    // instance variables 
    private OrderMenu orderMenu;

    /**
     * Constructor for objects of MainMenu
     */
    public MainTUI() {
        // initialise instance variables
        orderMenu = new OrderMenu();
        
    }

    public void start() { 
        boolean exit=false;
        while (!exit) { //! means while exit not is true (that is: false)
            int choice = writeMainMenu();
            if(choice == 1) {
                orderMenu.start();
                
            }
            else if(choice == 2) { 
                // TODO add code here
                System.out.println(" Denne er endnu ikke implementeret");
            }
            else if(choice == 3) {
            	System.out.println(" Denne er endnu ikke implementeret");
            }
            else if(choice == 4) {
                // TODO generate test data, this must not be part of final version
            }
            else {
                writeEnd();
                exit = true;
            }//end else
        }//end while
    }
    
    private int writeMainMenu(){
        TextOptions menu = new TextOptions("\n ***Hovedmenu***", "Afslut programmet");
        menu.addOption("Ordre Menu");
        menu.addOption("test");
        menu.addOption("test1");
        menu.addOption("Generer test data");
        return menu.prompt();
    }
    
    private void writeEnd() {
        System.out.println(" Tak for denne gang ");
    }
}