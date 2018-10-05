public class Anlage {
    
    private String Bezeichnung;
    private double ak;
    private double year;
    private double duration;

    public Anlage(String Bezeichnung, double ak, double year, double duration) {
        this.Bezeichnung = Bezeichnung;
        this.ak = ak;
        this.year = year;
        this.duration = duration;
    }

    public String getBezeichnung() {
        return Bezeichnung;
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

    public void setBezeichnung(String Bezeichnung) {
        this.Bezeichnung = Bezeichnung;
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
