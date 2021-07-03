package sample;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

public class PropertiesDatabase implements Serializable {
    private static final long serialVersionUID = 5230549922091722630L;

    HashMap<Integer, Property> map = new HashMap<>();
    HashMap<Integer , Owner> map1;
    OwnerDatabase od ;


    public void getPD(OwnerDatabase od) {
        this.od = od;
        map1 = od.getData();
        HashMap<Integer , Owner> help = od.getData();
        String file = "src\\properties.csv";
        BufferedReader reader = null;
        String line = "";
        int len = 0;
        int size = 0;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {

                String row[] = line.split(",");
                if(len == 0){
                    System.out.println("length :-"+row[0]);
                    size = Integer.parseInt(row[0]);
                }else{
                    String address = row[0];
                    String town = row[1];
                    int unique = Integer.parseInt(row[2]);
                    int own = Integer.parseInt(row[3]);
                    Owner owner = help.get(own);

                    if( row[4].equals("1") ){
                      //  System.out.println("sale");
                        int price = Integer.parseInt(row[5]);
                        Double area = Double.parseDouble(row[6]);
                        SaleProperty s = new SaleProperty(address , town , unique , owner , price , area);
                     //   System.out.println(s.getAddress()+" _ "+s.getTown()+" _ "+s.getPropertyID()+ " _ "+s.getPropertyOwner()+" _ "+ s.getPrice()+" _ "+s.getIndoorArea());
                        map.put(unique , s);
                    }else{
                       // System.out.println("Rent");
                        String name = row[5];
                        String phone = row[6];
                        RentalProperty r = new RentalProperty(address , town , unique , owner , name , phone);
                      //  System.out.println(r.getAddress()+" _ "+r.getTown()+" _ "+r.getPropertyID()+" _ " + r.getPropertyOwner()+" _ "+r.getTenantName()+" _ "+r.getTenantPhone());
                        map.put(unique , r);
                    }

                }
                len++;
            }
            System.out.println("Done!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<Integer , Property> get(){
        return map;
    }


    public void update(OwnerDatabase od){
        this.od = od;
    }

    public void setOD(OwnerDatabase od){
        this.od = od;
    }

    public OwnerDatabase getOD(){
        return od;
    }

    public void adds(String address , String town , int id , Owner own , int price , Double area){
        SaleProperty s = new SaleProperty(address , town , id , own , price , area);
        map.put(id , s);
        System.out.println(map.size());
    }

    public void addl(String address , String town , int id , Owner own , String name , String phone){
        RentalProperty r = new RentalProperty(address , town , id , own , name , phone);
        map.put(id , r);
        System.out.println(map.size());
    }

    public HashSet<SaleProperty> helpS(int p){
        HashSet<SaleProperty> temp = new HashSet<>();
        for(Property p1: map.values()){
            if(p1.getPropertyOwner().isSeller()){
                SaleProperty s = (SaleProperty) p1;
                if(s.getPrice()>=p){
                    temp.add(s);
                }
            }
        }
        return temp;
    }

    public HashSet<RentalProperty> helpL(String town){
        HashSet<RentalProperty> temp = new HashSet<>();
        for(Property p1:map.values()){
            if(p1.getPropertyOwner().isLandlord()){
                RentalProperty r = (RentalProperty) p1;
                String s = r.getTown().toLowerCase();
                String s1 = town.toLowerCase();
                if(s.equals(s1)){
                    temp.add(r);
                }
            }
        }
        return temp;
    }
}