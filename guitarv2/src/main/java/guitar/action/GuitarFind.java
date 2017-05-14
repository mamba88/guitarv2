package com.guitar.action;

import java.util.Iterator;
import java.util.List;

import com.guitar.model.Guitar;
import com.guitar.model.GuitarSpec;
import com.guitar.model.Inventory;

public class GuitarFind {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Inventory inventory = new Inventory();
	    initializeInventory(inventory);

	    GuitarSpec whatErinLikes = 
	    	      new GuitarSpec("ÃñÒ¥¼ªËû", "µç¼ªËû", "ÓÈ¿ËÀïÀï", "¹Åµä¼ªËû");
	    List matchingGuitars = inventory.search(whatErinLikes);
	    if (!matchingGuitars.isEmpty()) {
	      System.out.println("Erin, you might like these guitars:");
	      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
	        Guitar guitar = (Guitar)i.next();
	        GuitarSpec spec = guitar.getSpec();
	        System.out.println("  We have a " +
	          spec.getBuilder() + " " + guitar.getModel() + " " +
	          spec.getType() + " guitar:\n     " +
	          spec.getBackWood() + " back and sides,\n     " +
	          spec.getTopWood() + " top.\n  You can have it for only $" +
	          guitar.getPrice() + "!\n  ----");
	      }
	    } else {
	      System.out.println("Sorry, Erin, we have nothing for you.");
	    }
	}
	
	private static void initializeInventory(Inventory inventory) {
	    inventory.addGuitar("0001", 3999.95, "CJ", 
	      new GuitarSpec("21´ç", "»¨ÀæÄ¾", "°ØÄ¾", "Sitka"));
	    
	    inventory.addGuitar("0003", 1499.95, "Stratocastor", 
	      new GuitarSpec("23´ç", "ÎàÍ©Ä¾", "°×ËÉÄ¾", "Alder"));
	    
	    inventory.addGuitar("0004", 1549.95,  "Stratocastor",  
	      new  GuitarSpec("26´ç", "èëÄ¾", "»¨ÀæÄ¾", "Alder"));
	    
	    inventory.addGuitar("0006", 5495.95,  "D-18", 
	      new GuitarSpec("28´ç", "»¨ÀæÄ¾", "é²Ä¾", "Adirondack"));
	    
	    inventory.addGuitar("0007", 6295.95,  "OM-28", 
	      new GuitarSpec("21´ç", "èÖÄ¾", "ÎàÍ©Ä¾", "Adirondack"));
	    
	    inventory.addGuitar("0009", 2295.95, "Les Paul", 
	      new GuitarSpec("36´ç", "ÎàÍ©Ä¾", "»¨ÀæÄ¾", "Mahogany"));
	    
	  
	    
	  }

}
