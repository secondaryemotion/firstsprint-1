public class Converter {
    public static Double convertKm(int steps){
        return (double) (steps * 75 / 1000);
    }
    public static Double convertKkal(int steps){
        return (double) ((steps * 50)/1000);
    }
}
