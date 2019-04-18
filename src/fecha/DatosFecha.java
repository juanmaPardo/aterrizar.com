package fecha;

public interface DatosFecha {
    
    public int getDia();
    
    public int getMes();
    
    public int getAnio();
    
    public String getDateFormat();
    
    public String representacionEnIso();
    
    public String representacionEnNorteamericano();
    
    public String representacionEnLatinoamericano();
    
    public int diasPasaron(DatosFecha a, DatosFecha b);
    
    public DatosFecha fechaAnterior(DatosFecha a, DatosFecha b);
}
