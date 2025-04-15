package com.example.Booking_Service;


import com.example.Booking_Service.entity.Addres;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddressTest {

    @Test
    public void testId() {
        Addres address = new Addres();
        address.setId(1);
        assertEquals(1, address.getId());
    }

    @Test
    public void testHouseNo() {
        Addres address = new Addres();
        address.setHouseNo("123");
        assertEquals("123", address.getHouseNo());
    }

    @Test
    public void testArea() {
        Addres address = new Addres();
        address.setArea("Downtown");
        assertEquals("Downtown", address.getArea());
    }

    @Test
    public void testCity() {
        Addres address = new Addres();
        address.setCity("New York");
        assertEquals("New York", address.getCity());
    }

    @Test
    public void testPincode() {
        Addres address = new Addres();
        address.setPincode(123456);
        assertEquals(123456, address.getPincode());
    }

    @Test
    public void testState() {
        Addres address = new Addres();
        address.setState("NY");
        assertEquals("NY", address.getState());
    }

    @Test
    public void testAddressEntity() {
        Addres address = new Addres();
        address.setId(1);
        address.setHouseNo("123");
        address.setArea("Downtown");
        address.setCity("New York");
        address.setPincode(123456);
        address.setState("NY");

        // Verify if the getters return the correct values
        assertAll("address",
                () -> assertEquals(1, address.getId()),
                () -> assertEquals("123", address.getHouseNo()),
                () -> assertEquals("Downtown", address.getArea()),
                () -> assertEquals("New York", address.getCity()),
                () -> assertEquals(123456, address.getPincode()),
                () -> assertEquals("NY", address.getState())
        );
    }
}

