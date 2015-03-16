import java.util.Random;


public class Main {

	static int array_size = 1024;
	static int[] array = new int[array_size];
	static int[] table = new int[257];
	static int total_bits_in_the_array = 0;
	
	private static void create_table(){
		int i;
		int bits_set = 0;
		
		for (i = 0 ; i <= 256 ; i++){
			bits_set = 0;
			for (int z = 0; z <= 8 ; z++){
				bits_set += i>>z & 0x1;
			}
		table[i] = bits_set;
		//System.out.println("i = " + i + " bits_set = " + bits_set);
		}
		
		
		
	}
	
	public static void main(String args[]){
			System.out.println("hi");
			create_table();
			fill_array();
			parse_array();
			System.out.println("The amount of bits in the array is: " + total_bits_in_the_array);
	}


	private static void parse_array() {
		int current;
		
		for (int i = 0; i < array.length; i++){
			current = array[i];
			
			int down = current & 0xff; 
			int up = current & 0xff00;
			
			int sum = table[up] + table[down];
			
			total_bits_in_the_array += sum;
		}		
	}

	private static void fill_array() {
		Random ran = new Random();
		
		for (int i = 0; i < array.length; i++){
			array[i] = Math.abs(ran.nextInt()%512);
		}
		
	}
}
