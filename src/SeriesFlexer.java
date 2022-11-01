public class SeriesFlexer {
    public static Integer seriesFlexer(int[] db, int goal){
        int counter = 0;
        int max = 0;
        for (int i = 0; i < 31; i++){
            if (db[i] >= goal){
                counter++;
            } else {
                max = Math.max(counter,max);
                counter = 0;
            }
        }
        return max;
    }
}
