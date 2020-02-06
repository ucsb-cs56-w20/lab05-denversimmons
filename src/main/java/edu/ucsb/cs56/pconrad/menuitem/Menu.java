package edu.ucsb.cs56.pconrad.menuitem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class byPrice implements Comparator<MenuItem>
{
    public int compare(MenuItem a, MenuItem b)
    {
	return a.getPriceInCents() - b.getPriceInCents();
    }
}

class byName implements Comparator<MenuItem>
{
    public int compare(MenuItem a, MenuItem b)
    {
        return a.getName().compareTo(b.getName());
    }
}

class byCategory implements Comparator<MenuItem>
{
    public int compare(MenuItem a, MenuItem b)
    {
        return a.getCategory().compareTo(b.getCategory());
    }
}

public class Menu {

    private ArrayList<MenuItem> menuitems; 
    
    public Menu() {
        menuitems = new ArrayList<MenuItem>();
    }

    public void add(MenuItem mi) {
        menuitems.add(mi);
    }

    public String csv() {
	String csv = "";
	for(int i = 0; i < menuitems.size(); i++)
	{
	    csv += menuitems.get(i).toString() + "\n";
	}
	return csv;
    }

    public String csvSortedByPriceThenName() {
	Collections.sort(menuitems, new  byPrice().thenComparing(new byName()));
	return csv();
    }

    public String csvSortedByName(){
	Collections.sort(menuitems, new byName());
        return csv();
    }

    public String csvSortedByCategoryThenName() {
	Collections.sort(menuitems, new byCategory().thenComparing(new byName()));
        return csv();

    }

    public String csvSortedByCategoryThenPriceDescendingThenByName() {
	Collections.sort(menuitems, new  byCategory().thenComparing(new byPrice().reversed().thenComparing(new byName())));
	return csv();
    }
}
