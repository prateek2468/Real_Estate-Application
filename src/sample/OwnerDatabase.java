package sample;

import java.io.*;
import java.util.HashMap;

public class OwnerDatabase implements Serializable {
    private static final long serialVersionUID = 5230549922091722630L;

    HashMap<Integer , Owner> map = new HashMap<>();
    boolean done = false;
    PropertiesDatabase pd = null;


    public void getOD(){
        String file = "src\\owners.csv";
        BufferedReader reader = null;
        String line = "";
        int len =0 ;

        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine())!=null){
                String row[] = line.split(",");
                if(len == 0){
                    int n = Integer.parseInt(row[0]);
                }else{
                    String name = row[0];
                    String address = row[1];
                    int code = Integer.parseInt(row[2]);
                    String conveyancer , bank_account , amount;
                    if(row[3].equals("1")){
                     //   System.out.println("Seller");
                        conveyancer = row[4];
                        Seller s = new Seller( name , address , code , conveyancer);
                      //  System.out.println(s.getName()+" _ "+s.getAddress()+" _ "+s.getOwnerID()+" _ "+s.getConveyancer());
                        map.put( code , s);
                    }else{
                     //   System.out.println("Landlord");
                        bank_account = row[4];
                        amount = row[5];
                        Landlord l = new Landlord(name , address , code , bank_account , Double.parseDouble(amount));
                      //  System.out.println(l.getName()+" _ "+l.getAddress()+" _ "+l.getOwnerID()+" _ "+l.getBankDetails()+" _ "+l.getWeeklyRent());
                        map.put( code , l);
                    }
                }
                len++;
            }
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println(map.size());
            done = true;
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean isDone(){
        return done;
    }

    public HashMap<Integer, Owner> getData() {
        return map;
    }

    public void adds(String name , String address , int id , String Con){
        Seller s = new Seller(name , address , id , Con);
        map.put(id , s);
        System.out.println(map.size());
    }

    public void addl(String name , String address , int code , String bank , Double rent){
        Landlord l = new Landlord(name , address , code , bank , rent);
        map.put(code , l);
        System.out.println(map.size());
    }

    public HashMap<String , Owner> getNameS(){
        HashMap<String , Owner> temp = new HashMap<>();
        for(Owner o: map.values()){
            if(o.isSeller()){
                temp.put(o.getName() , o);
            }
        }
        return temp;
    }

    public HashMap<String , Owner> getNameL(){
        HashMap<String , Owner> temp = new HashMap<>();
        for(Owner o: map.values()){
            if(o.isLandlord()){
                temp.put(o.getName() , o);
            }
        }
        return temp;
    }

    public void setPD(PropertiesDatabase pd){
        this.pd = pd;
    }

    public PropertiesDatabase getPd(){
        return pd;
    }
}
