// ========== This is for Search Service ==========
package project;

import java.util.*;

// Simple utility class for searching garages by service or vehicle type
public class SearchService {
	private static ArrayList<GarageProfile> garages=new ArrayList<>();
	
	public static void AddGarages(GarageProfile[] garage) {
		for(int i=0;i<garage.length;i++) {
			if(!garages.contains(garage[i])) {
				garages.add(garage[i]);
			}
		}
	}
    /**
     * Finds garages that offer a service by name
     */
    public static void searchGaragesByService(String serviceName) {
        List<GarageProfile> result = new ArrayList<>();
        for (int i=0;i<garages.size();i++) {
            if (garages.get(i).getAvailableServiceNames().contains(serviceName)) {
                result.add(garages.get(i));
            }
        }
        System.out.println("Garages offering "+serviceName+ " are:\n");
        for(int i=0;i<result.size();i++) {
        	System.out.println(result.get(i).toString());
        }
        System.out.println();
    }

    /**
     * Finds garages that support a specific vehicle type
     */
    public static void searchGaragesByVehicleType( VehicleType type) {
        List<GarageProfile> result = new ArrayList<>();
        for (GarageProfile garage : garages) {
            if (garage.getSupportedVehicleTypes().contains(type)) {
                result.add(garage);
            }
        }
        System.out.println("Garages dealing with "+type+ " are:\n");
        for(int i=0;i<result.size();i++) {
        	System.out.println(result.get(i).toString());
        }
        System.out.println();
    }
}
