package Directory;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.Serializable;

public class Collection implements Serializable
{
    private ArrayList<Record> arr;
    
    public Collection() {
        arr = new ArrayList<Record>();
    }
    
    public void addRecord() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose category:");
        System.out.println("Person\t\t\t-\t\t1");
        System.out.println("Service\t\t\t-\t\t2");
        System.out.println("Workplace\t\t-\t\t3");
        int x = Integer.parseInt(input.nextLine());
        boolean alreadyused = false;
        switch (x) {
            case 1: {
                System.out.println("Name:");
                String na = input.nextLine();
                System.out.println("Number:");
                String nu = input.nextLine();
                for (Record r : arr) {
                    if (r.getNumber().equals(nu)) {
                        System.err.println("Number already in use.");
                        alreadyused = true;
                    }
                }
                if (!alreadyused) {
                    System.out.println("Nickname:");
                    String ni = input.nextLine();
                    System.out.println("Hometown:");
                    String ho = input.nextLine();
                    Person p = new Person(na, nu, ni, ho);
                    arr.add(p);
                    break;
                }
                break;
            }
            case 2: {
                System.out.println("Name:");
                String na = input.next();
                System.out.println("Number:");
                String nu = input.next();
                for (Record r : arr) {
                    if (r.getNumber().equals(nu)) {
                        System.err.println("Number already in use.");
                        alreadyused = true;
                    }
                }
                if (!alreadyused) {
                    System.out.println("Type:");
                    String ty = input.next();
                    Service s = new Service(na, nu, ty);
                    arr.add(s);
                    break;
                }
                break;
            }
            case 3: {
                System.out.println("Name:");
                String na = input.next();
                System.out.println("Number:");
                String nu = input.next();
                for (Record r : arr) {
                    if (r.getNumber().equals(nu)) {
                        System.err.println("Number already in use.");
                        alreadyused = true;
                    }
                }
                if (!alreadyused) {
                    System.out.println("Streetname:");
                    String st = input.next();
                    WorkPlace w = new WorkPlace(na, nu, st);
                    arr.add(w);
                    break;
                }
                break;
            }
            default: {
                System.err.println("Wrong input");
                break;
            }
        }
    }
    
    public void listCollection() {
        Scanner input = new Scanner(System.in);
        System.out.println("What would you like to list out?");
        System.out.println("Every record\t\t-\t\t1");
        System.out.println("Every person\t\t-\t\t2");
        System.out.println("Every service\t\t-\t\t3");
        System.out.println("Every workplace\t\t-\t\t4");
        int x = input.nextInt();
        switch (x) {
            case 1: {
                for (Record r : arr) {
                    System.out.println(r);
                }
                break;
            }
            case 2: {
                for (Record r : arr) {
                    if (r.getCategory() == 0) {
                        System.out.println(r);
                    }
                }
                break;
            }
            case 3: {
                for (Record r : arr) {
                    if (r.getCategory() == 1) {
                        System.out.println(r);
                    }
                }
                break;
            }
            case 4: {
                for (Record r : arr) {
                    if (r.getCategory() == 2) {
                        System.out.println(r);
                    }
                }
                break;
            }
            default: {
                System.err.println("Wrong input.");
                break;
            }
        }
    }
    
    public void removeRecord() {
        Scanner input = new Scanner(System.in);
        System.out.println("Remove by name\t\t-\t\t1");
        System.out.println("Remove by number\t-\t\t2");
        int x = Integer.parseInt(input.nextLine());
        Iterator<Record> i = arr.iterator();
        switch (x) {
            case 1: {
                System.out.println("Name:");
                String na = input.nextLine();
                int cnt = 1;
                for (Record r : arr) {
                    if (r.getName().equals(na)) {
                        System.out.println(r + "\t\t-\t" + cnt);
                        ++cnt;
                    }
                }
                System.out.println("Choose the number of the desired record:");
                int in = input.nextInt();
                cnt = 1;
                while (i.hasNext()) {
                    if (i.next().getName().equals(na)) {
                        if (in == cnt) {
                            i.remove();
                            break;
                        }
                        ++cnt;
                    }
                }
                break;
            }
            case 2: {
                System.out.println("Number:");
                String nu = input.nextLine();
                while (i.hasNext()) {
                    if (i.next().getNumber().equals(nu)) {
                        i.remove();
                    }
                }
                break;
            }
            default: {
                System.err.println("Wrong input.");
                break;
            }
        }
    }
    
    public void searchRecord() {
        Scanner input = new Scanner(System.in);
        System.out.println("Search by name\t\t-\t\t1");
        System.out.println("Search by number\t-\t\t2");
        int x = Integer.parseInt(input.nextLine());
        boolean nosuch = true;
        switch (x) {
            case 1: {
                System.out.println("Name:");
                String na = input.nextLine();
                for (Record r : arr) {
                    if (r.getName().equals(na)) {
                        System.out.println(r);
                        nosuch = false;
                    }
                }
                if (nosuch) {
                    System.err.println("There's no such record in the registry.");
                    break;
                }
                break;
            }
            case 2: {
                System.out.println("Number:");
                String nu = input.nextLine();
                for (Record r2 : arr) {
                    if (r2.getNumber().equals(nu)) {
                        System.out.println(r2);
                        nosuch = false;
                    }
                }
                if (nosuch) {
                    System.err.println("There's no such record in the registry.");
                    break;
                }
                break;
            }
            default: {
                System.err.println("Wrong input.");
                break;
            }
        }
    }
    
    public void modifyRecord() {
        Scanner input = new Scanner(System.in);
        System.out.println("Number:");
        String nu = input.nextLine();
        for (Record r : arr) {
            if (r.getNumber().equals(nu)) {
                System.out.println("Name:");
                String na = input.nextLine();
                r.setName(na);
                return;
            }
        }
        System.err.println("Couldn't find the record.");
    }
    
    public void save() {
        try {
            FileOutputStream f = new FileOutputStream("records");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(arr);
            out.close();
        }
        catch (IOException ex) {}
    }
    
    public void load() {
        try {
            FileInputStream f = new FileInputStream("records");
            ObjectInputStream in = new ObjectInputStream(f);
            arr = (ArrayList<Record>)in.readObject();
            in.close();
        }
        catch (IOException ex) {}
        catch (ClassNotFoundException ex2) {}
    }
}