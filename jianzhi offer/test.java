import java.util.List;

class test {
    public static void main(String[] args) {
        System.out.println("helloword");
    }

    public List print(int[][] matrix) {
        int r2 = matrix.length-1;
        int r1 = 0;
        int c1 = 0;
        int c2 = matrix[0].length-1;

        List<Integer> list = new ArrayList<>();


        while (r1<=r2 && c1<=c2) {
            for (int i = c1; i <= c2; i++) {
                list.add(matrix[r1][i]);
            }
    
            for (int i = r1+1; i <= r2; i++) {
                list.add(matrix[i][c2]);
            }

            if (r1 != r2) {
                for (int i = c2-1; i>=c1; i++) {
                    list.add(matrix[r2][i]);
                }
            }

            if (c1 != c2) {
                for (int i = r2-1; i>r1; i++) {
                    list.add(matrix[i][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }
    

}