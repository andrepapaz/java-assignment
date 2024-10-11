package com.mobiquity.packer;

public record Item(int index, double weight, int cost) {
    public static Item parseItem(String stringItem) {
        String item = stringItem.replace("(", "").replace(")", "");
        String[] itemSplit = item.split(",");
        return new Item(Integer.parseInt(itemSplit[0]), Double.parseDouble(itemSplit[1]), Integer.parseInt(itemSplit[2].replace("€", "")));
    }
}
