import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(true) {
            try {
                System.out.print("Enter string to encrypt: ");
                String in = scan.nextLine();
                System.out.print("Enter column count: ");
                int col = Integer.parseInt(scan.next());
                System.out.print("Enter row count: ");
                int row = Integer.parseInt(scan.next());
                System.out.print("Enter direction: clockwise or counter-clockwise? ");
                String dir = scan.next();

                if(dir.equals("clockwise") || dir.equals("counter-clockwise")) {
                    StringEncryption strObj = new StringEncryption(in, col, row, dir);
                    System.out.print(strObj.getEncryptedString());
                    scan.nextLine();
                }

                else {
                    System.out.println("Error: Enter directions correctly!");
                    scan.nextLine();
                }
            }

            catch (NumberFormatException ex) {
                System.out.println("Exception: Integers only for rows and columns!");
                scan.nextLine();
            }
        }
    }
}
