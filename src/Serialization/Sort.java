package Serialization;
import java.util.Arrays;
import java.util.Comparator;


public class Sort {
	
	public static Bolnie[] byNames(Bolnie[] array){
        Arrays.sort(array, Comparator.comparing(Bolnie::getName));
        return array;
    }

}
