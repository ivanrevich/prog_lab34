package nature;

public class Sky extends NatureObject{
    private Weather weather = Weather.random();

    public Sky() {
        super("небо");
    }

    @Override
    public String toString() {
        return super.title;
    }
    public Weather getWeather() {
        return weather;
    }

    public void changeWeather() {
        weather = Weather.random();
        System.out.println("Небо изменилось: теперь " + weather);
    }

    @Override
    public void appeared() {
        System.out.println(title + " появилось из-за туч (" + weather + ")");
    }

    @Override
    public void misapprehended() {
        System.out.println(title+" скрылось из-за туч (" + weather + ")");
    }
}
