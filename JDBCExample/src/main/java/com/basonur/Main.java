package com.basonur;

import com.basonur.controller.FutbolcuController;
import com.basonur.repository.FutbolcuRepository;
import com.basonur.repository.TakimRepository;
import com.basonur.repository.entity.Futbolcu;
import com.basonur.repository.entity.Takim;
import com.basonur.utility.ConnectionProvider;

public class Main {
    public static void main(String[] args) {
        Takim takim = Takim.builder().ad("GS").build();
        Futbolcu futbolcu = Futbolcu.builder().id(5L).ad("caner").mevki("bilmemne").formaNo(9).deger(200000L).takim_id(1L).build();
        ConnectionProvider connectionProvider = new ConnectionProvider();

        TakimRepository takimRepository = new TakimRepository(connectionProvider);
      //  FutbolcuRepository futbolcuRepository = new FutbolcuRepository(connectionProvider);
       // takimRepository.save(takim);

        //FutbolcuController futbolcuController = new FutbolcuController(connectionProvider);
        //futbolcuController.save(futbolcu);

        FutbolcuController futbolcuController = new FutbolcuController(connectionProvider);
      //  futbolcuController.save2(futbolcu);
        //futbolcuController.update(futbolcu);
       // futbolcuController.deleteById(4L);
        //futbolcuController.findAll().forEach(System.out::println);
        System.out.println( futbolcuController.findById(5L));


    }
}
