package com.mobiquity.packer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    public void shouldParseStringToAnItem() {
        String itemString = "(1,20.34,€30)";

        Item parseItem = Item.parseItem(itemString);

        assertEquals(1, parseItem.index());
        assertEquals(20.34, parseItem.weight());
        assertEquals(30, parseItem.cost());
    }
}