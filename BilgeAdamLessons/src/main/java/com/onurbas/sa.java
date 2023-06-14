package com.onurbas;

public class sa {
    public static long sayac=0;

    public static void main(String[] args) {

        long baslangic = System.currentTimeMillis();

        final var mainThread = Thread.currentThread();


        new Thread( () -> {
            for (int i = 0; i < 10_000_000; i++) {
                sayac++;

                mainThread.interrupt();

            }
        }).start();

        while (sayac<10000){
            //  System.out.println("Koşul sağlanmadı");

            try {
                System.out.println("Onur BAŞ");
                Thread.sleep(5000);


            } catch (Exception e) {
                //  System.out.println("Hata : " + e);
                // throw new RuntimeException(e);
            }
        }


        long bitis = System.currentTimeMillis();

        System.out.println(bitis-baslangic);
        System.out.println("Sayac : " +sayac);
}
}
