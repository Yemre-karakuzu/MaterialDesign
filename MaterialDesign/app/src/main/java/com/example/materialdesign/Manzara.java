package com.example.materialdesign;

import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;

public class Manzara {
    private int imageID;
    private String baslik;
    private String tanım;

    public int getImageID() {
        return imageID;
    }

    public String getBaslik() {
        return baslik;
    }

    public String getTanım() {
        return tanım;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public void setTanım(String tanım) {
        this.tanım = tanım;
    }

    public static ArrayList<Manzara>getData()
    {
        ArrayList<Manzara> dataList=new ArrayList<Manzara>();
        int[] resimler={
                R.drawable.a,R.drawable.b,R.drawable.c,
                R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,
                R.drawable.h,R.drawable.j,R.drawable.k
        };
        for (int i=0;i<resimler.length;i++)
        {
            Manzara gecici=new Manzara();
            gecici.setImageID(resimler[i]);
            gecici.setBaslik("Gezi"+i);
            gecici.setTanım("Gunce"+i);
            dataList.add(gecici);
        }
        return dataList;
    }
}
