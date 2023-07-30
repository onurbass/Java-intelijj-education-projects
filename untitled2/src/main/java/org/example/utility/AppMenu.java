package org.example.utility;

import org.example.controller.PersonController;
import org.example.controller.RentalController;
import org.example.controller.VehicleController;
import org.example.entity.Enums.EVehicleStatus;
import org.example.entity.Person;
import org.example.entity.Rental;
import org.example.entity.Vehicle;

import java.util.List;
import java.util.Scanner;

public class AppMenu {
    static Scanner scanner = new Scanner(System.in);
    static VehicleController vehicleController;
    static RentalController rentalController;
    static PersonController personController;

    public AppMenu() {
        this.vehicleController=new VehicleController();
        this.rentalController=new RentalController();
        this.personController=new PersonController();
    }
    public void mainMenu() {

        int selection = 0;

        do {
            System.out.println("*******************************************");
            System.out.println("******** VEHICLE RENTAL APPLICATION *******");
            System.out.println("*******************************************");

            System.out.println("1- Add Vehicle");
            System.out.println("2- Search Vehicle");
            System.out.println("3- Add Person");
            System.out.println("4- Rent Vehicle");
            System.out.println("5- Report");
            System.out.println("0- Exit");

            selection = scanner.nextInt();
            scanner.nextLine();

            switch (selection) {
                case 1:
                    System.out.println("Add Vehicle selected..");
                    addVehicle();
                    break;

                case 2:
                    System.out.println("Search Vehicle selected..");
                    searchVehicle();
                    break;

                case 3:
                    System.out.println("Add Person selected..");
                    addPerson();
                    break;

                case 4:
                    System.out.println("Rent Vehicle selected..");
                    rentVehicle();
                    break;

                case 5:
                    System.out.println("Report selected..");
                    report();
                    break;

                case 0:
                    System.out.println("Exit...");
                    break;

                default:
                    break;
            }

        } while (selection != 0);
    }

    public void addVehicle() {

        System.out.println("Please enter brand of the vehicle");
        String brand = scanner.nextLine();

        System.out.println("Please enter model of the vehicle");
        String model = scanner.nextLine();

        Vehicle vehicle = Vehicle.builder().brand(brand).model(model).build();

        vehicleController.add(vehicle);
    }

    public void searchVehicle() {

        System.out.println("Please enter a vehicle id");
        Long id = scanner.nextLong();

        Vehicle vehicle = vehicleController.search(id);
        System.out.println(vehicle);
    }

    public void rentVehicle() {

        System.out.println("Please enter a vehicle id");
        Long id = scanner.nextLong();

        Vehicle vehicle = vehicleController.search(id);
        vehicle.setStatus(EVehicleStatus.RENT);
        System.out.println("VEHICLE INFORMATION: " + vehicle);


        System.out.println("Please enter person/renter id");
        Long personId = scanner.nextLong();

        Person person = personController.search(personId);
        System.out.println("PERSON INFORMATION:" + person);


        Rental rental = Rental.builder()
                .vehicle(vehicle)
                .person(person)
                .build();
        rentalController.add(rental);
    }

    public void addPerson() {

        System.out.println("Please enter your name: ");
        String firstname = scanner.nextLine();

        System.out.println("Please enter your surname");
        String surname = scanner.nextLine();

        Person person= Person.builder().firstName(firstname).surname(surname).build();

        personController.add(person);
    }

    public void report() {

        int selection = 0;

        do {

            System.out.println("**************************");
            System.out.println("******** REPORTS ********");
            System.out.println("**************************");

            System.out.println("1- Vehicles on rental");
            System.out.println("2- Available Vehicles");
            System.out.println("3- Vehicles rented by any customer");
            System.out.println("0- Exit");

            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("Searching for vehicles on rental. ");
                    kiradakiAraclar();
                    break;

                case 2:
                    System.out.println("Searching for available vehicles.");
                    musaitAraclar();
                    break;

                case 3:
                    System.out.println("Searching for vehicles rented by any customer.");
                    System.out.println("Please enter the person id to search for rentals.");
                    herhangiBirMusterininKiraladigiAraclar();
                    break;


                case 0:
                    System.out.println("Exit...");
                    break;

                default:
                    break;
            }

        } while (selection != 0);
    }

    public  List<Vehicle> kiradakiAraclar() {
        return vehicleController.availableOrRentedVehicles(EVehicleStatus.RENT);

//        List<Vehicle> araclerListesi = aracController.kiradakiAracler();
//        for (Arac arac : araclerListesi) {
//            System.out.println("Status: " + arac.getDurum() + "\t Id: " + arac.getId() + "\t Brand: " + arac.getMarka() +
//                    "\t Model: " + arac.getModel());
//        }
    }

    public List<Vehicle> musaitAraclar() {
        return vehicleController.availableOrRentedVehicles(EVehicleStatus.AVAILABLE);

    }

    public List<Vehicle> herhangiBirMusterininKiraladigiAraclar() {
        System.out.println("Please enter person/renter id");
        Long personId = scanner.nextLong();

        return vehicleController.rentedVehiclesByPersonId(personId);

    }
//        List<Vehicle> araclarListesi = kiralamaController.kiralanmisArabalar(id);
//        for (Arac arac : araclarListesi) {
//            System.out.println("Status: " + arac.getDurum() + "\t Id: " + arac.getId() + "\t Brand: " + arac.getMarka() +
//                    "\t Model: " + arac.getModel());
//        }
//    }
}
