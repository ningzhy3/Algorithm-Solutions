public class Main {
	public static void main(String[] args) {
		
	}
	public static void permutations(char[] cs, int i, List list){
		if (i == cs.length-1) {
			String val = String.valueOf(cs);
			if (!list.contains()) {
				list.add(val);
			}
		} else {
			for (int j = i; j < cs.length; j++) {
				swap(cs,i,j);
				//backtracking
				permutations(cs,i+1,list);
				swap(cs,i,j);
			}
		}
	}
	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp; 
	}
}