package ru.netology.JavaDZ13.AviaSouls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator comparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket(
            "Москва",
            "Питер",
            300,
            8,
            10);
    Ticket ticket2 = new Ticket(
            "Воркута",
            "Лангепас",
            700,
            13,
            17);
    Ticket ticket3 = new Ticket(
            "Барнаул",
            "Чебоксары",
            200,
            10,
            20);
    Ticket ticket4 = new Ticket(
            "Барнаул",
            "Чебоксары",
            500,
            10,
            14);
    Ticket ticket5 = new Ticket(
            "Барнаул",
            "Чебоксары",
            100,
            10,
            11);
    Ticket ticket6 = new Ticket(
            "Воркута",
            "Лангепас",
            800,
            13,
            18);
    Ticket ticket7 = new Ticket(
            "Москва",
            "Питер",
            400,
            9,
            10);
    Ticket ticket8 = new Ticket(
            "Омск",
            "Уфа",
            400,
            8,
            10);
    Ticket ticket9 = new Ticket(
            "Омск",
            "Уфа",
            400,
            13,
            22);

    @BeforeEach
    public void setup() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
    }

    @Test
    public void shouldAllTickets() {
        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Arrays.sort(tickets);
        Ticket[] expected = {ticket5, ticket3, ticket1, ticket4, ticket2};
        Assertions.assertArrayEquals(tickets, expected);
    }

    @Test
    public void shouldSearchTickets1() {
        Ticket[] expected = {ticket5, ticket3, ticket4};
        Ticket[] actual = aviaSouls.search("Барнаул", "Чебоксары");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTickets2() {
        aviaSouls.add(ticket6);
        Ticket[] expected = {ticket2, ticket6};
        Ticket[] actual = aviaSouls.search("Воркута", "Лангепас");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTicketsAndSortByTime1() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] tickets = {ticket2, ticket6};
        Ticket[] expected = {ticket2, ticket6};
        Arrays.sort(tickets, timeComparator);
        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void shouldSearchTicketsAndSortByTime2() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] tickets = {ticket1, ticket2};
        Ticket[] expected = {ticket1, ticket2};
        Arrays.sort(tickets, timeComparator);
        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void shouldSearchTicketsAndSortByTime3() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        Ticket[] tickets = {ticket4, ticket5};
        Ticket[] expected = {ticket5, ticket4};
        Arrays.sort(tickets, timeComparator);
        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void shouldSearchTicketsAndSortByTime4() {
        TicketTimeComparator timeComparator = new TicketTimeComparator();
        aviaSouls.add(ticket7);
        Ticket[] tickets = {ticket1, ticket7};
        Ticket[] expected = {ticket7, ticket1};
        Arrays.sort(tickets, timeComparator);
        Assertions.assertArrayEquals(expected, tickets);
    }

    @Test
    public void shouldSearchTicketsAndSortByTime5() {
        aviaSouls.add(ticket6);
        Ticket[] expected = {ticket2, ticket6};
        Ticket[] actual = aviaSouls.searchAndSortBy("Воркута", "Лангепас", Ticket::compareTo);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTicketsAndSortByTime6() {
        aviaSouls.add(ticket7);
        Ticket[] expected = {ticket7, ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("Москва", "Питер", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTicketsAndSortByTime7() {
        aviaSouls.add(ticket8);
        aviaSouls.add(ticket9);
        Ticket[] expected = {ticket8, ticket9};
        Ticket[] actual = aviaSouls.searchAndSortBy("Омск", "Уфа", comparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
