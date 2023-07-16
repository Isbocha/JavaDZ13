package ru.netology.JavaDZ13.AviaSouls;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Ticket ticket1 = new Ticket(
                "Москва",
                "Питер",
                3_000,
                8,
                10);
        Ticket ticket2 = new Ticket(
                "Воркута",
                "Лангепас",
                7_000,
                13,
                17);
        Ticket ticket3 = new Ticket(
                "Барнаул",
                "Чебоксары",
                1_000,
                10,
                20);
        Ticket ticket4 = new Ticket(
                "Барнаул",
                "Чебоксары",
                2_000,
                10,
                20);
        System.out.println(ticket1.compareTo(ticket2));
        System.out.println(ticket2.compareTo(ticket3));
        System.out.println(ticket1.compareTo(ticket3));


    }

}
