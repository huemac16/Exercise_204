
public class Anlage {

    private String text;
    private double ak;
    private double year;
    private double duration;

    public Anlage(String text, double ak, double year, double duration) {
        this.text = text;
        this.ak = ak;
        this.year = year;
        this.duration = duration;
    }

    public double calcDurUntilNow(int y) {
        if ((double) y - year < 0) {
            return duration;
        }
        if (y - year >= duration) {
            return duration;
        }
        return (double) y - year;
    }

    public double calcAfAUntilNow(int y) {
        return calcDurUntilNow(y) / duration * ak;
    }

    public double calcValueBefore(int y) {
        double afaUN = calcAfAUntilNow(y);
        if (ak - afaUN < 0) {
            return 0;
        }
        return ak - afaUN;
    }

    public double calcAfA(int y) {
        if (calcValueBefore(y) == 0) {
            return 0;
        }
        return ak / duration;
    }

    public double calcBW(int y) {
        double v = calcValueBefore(y), a = calcAfA(y);
        if (v - a < 0) {
            return 0;
        }
        return v - a;
    }

    public String getText() {
        return text;
    }

    public double getAk() {
        return ak;
    }

    public double getYear() {
        return year;
    }

    public double getDuration() {
        return duration;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAk(double ak) {
        this.ak = ak;
    }

    public void setYear(double year) {
        this.year = year;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

}
