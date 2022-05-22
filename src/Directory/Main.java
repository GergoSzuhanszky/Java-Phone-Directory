package Directory;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Collection arr = new Collection();
        arr.load();
        Scanner input = new Scanner(System.in);
        boolean end = false;
        while (!end) {
            try {
                System.out.println("Add record\t\t-\t\t1");
                System.out.println("List directory\t\t-\t\t2");
                System.out.println("Remove record\t\t-\t\t3");
                System.out.println("Search record\t\t-\t\t4");
                System.out.println("Modify record\t\t-\t\t5");
                System.out.println("Exit\t\t\t-\t\t6");
                int x = input.nextInt();
                switch (x) {
                    case 1: {
                        arr.addRecord();
                        arr.save();
                        break;
                    }
                    case 2: {
                        arr.listCollection();
                        break;
                    }
                    case 3: {
                        arr.removeRecord();
                        arr.save();
                        break;
                    }
                    case 4: {
                        arr.searchRecord();
                        break;
                    }
                    case 5: {
                        arr.modifyRecord();
                        arr.save();
                        break;
                    }
                    case 6: {
                        end = true;
                        break;
                    }
                    default: {
                        System.err.println("Wrong input.");
                        break;
                    }
                }
            }
            catch (Exception e) {
                input.nextLine();
                System.err.println("Wrong input.");
            }
        }
    }
}

