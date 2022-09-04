package com.jap.collectiondemo;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MobileStore {


    private List<Mobile> allMobiles;
    private String record = "";
    private String splitBy = ",";
    public MobileStore()
    {
        allMobiles = new ArrayList<>();
    }
    Iterator<Mobile> itr = null;
    Mobile obj = null;
    //Write logic to read the fileName that is "mobile.csv"
    //read all the lines one by one
    //Create Mobile class object and store data from file in the respective attributes of Mobile class
    // ex - Store brandName - Samsung in  mobile.setBrandName(brandName);
    //add mobile object in the List object and return the List
    //handle all the exceptions
    public List<Mobile> readMobileData(String fileName)
    {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data = bufferedReader.readLine();

            while((data = bufferedReader.readLine()) != null){

                String[] response = data.split(splitBy);
                String brandname = response[0];
                String model = response[1];
                double cost = Double.parseDouble(response[2]);
                String screenSize = response[3] ;
                String batterylife = response[4];
                String storageSpace = response[5];
                int cameraPixel = Integer.parseInt(response[6]);
                allMobiles.add(new Mobile(brandname,model,cost,screenSize,batterylife,storageSpace,cameraPixel));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return allMobiles;
    }

    //Iterate the List created in the above method and retrieve the bandName
    //Return the List with specific Mobile having brandName coming from method parameter
    public List<Mobile> findPhoneByBrand(String brandName)
    {
        List<Mobile> mobilesByBrand = new ArrayList<>();
        itr = allMobiles.iterator();
        while (itr.hasNext()){
            obj = itr.next();
            if(obj.getBrandName().equals(brandName)){
                mobilesByBrand.add(obj);
            }
        }

        return mobilesByBrand;
    }

    //Iterate through the List created in the first method
    //Return the List of Mobile whose cost is more than $500
    public List<Mobile> findPhoneCostMoreThan$500()
    {
        List<Mobile> mobilesMoreThan500 = new ArrayList<>();
        itr = allMobiles.iterator();
        while (itr.hasNext()){
            obj = itr.next();
            if(obj.getCost() >= 500){
                mobilesMoreThan500.add(obj);
            }
        }
        return mobilesMoreThan500;
    }

    //Iterate through the List created in the first method
    //Return the List of Mobile whose Pixel is more than 12MP
    public List<Mobile> findPhonePixelMoreThan12MP()
    {
        List<Mobile> mobilesMoreThan12MP = new ArrayList<>();
        itr = allMobiles.iterator();
        while(itr.hasNext()){
            obj = itr.next();
            if(obj.getCameraPixels() > 12){
                mobilesMoreThan12MP.add(obj);
            }
        }
        return mobilesMoreThan12MP;
    }


}
