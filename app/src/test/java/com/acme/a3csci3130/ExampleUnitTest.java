package com.acme.a3csci3130;

import junit.extensions.ActiveTestSuite;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
import junit.framework.*;

public class ExampleUnitTest {
        protected String personID;
        protected String businessnumber;
        protected String name;
        protected String address;
        protected String primary;
        protected String province;

        // assigning the values
        @Test
        protected void rightsetUp(){

            personID = "dededede";
            businessnumber = "11111";
            name = "abc ABC";
            address = "100 road";
            primary = "Fisher";
            province = "NS";
        }

        @Test
        public void testAdd(){
            Contact person = new Contact(personID, businessnumber, name, primary, address, province);
            assertEquals(person.address, address);
            assertEquals(person.business_number, businessnumber);
            assertEquals(person.name, name);
            assertEquals(person.primary, primary);
            assertEquals(person.province, province);
        }
    }
}