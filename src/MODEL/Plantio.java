package model;

import java.sql.Date;

public class Plantio {

    private int pk_plantio;
    private int fk_proprietario;
    private int fk_terra;
    private int fk_fertilizante;
    private String nomeSemente;
    private String profundidadePlantada;

    public Plantio() {
    }

    public Plantio(int pk_plantio, int fk_proprietario, int fk_terra, int fk_fertilizante, String nomeSemente, String profundidadePlantada) {
        this.pk_plantio = pk_plantio;
        this.fk_proprietario = fk_proprietario;
        this.fk_terra = fk_terra;
        this.fk_fertilizante = fk_fertilizante;
        this.nomeSemente = nomeSemente;
        this.profundidadePlantada = profundidadePlantada;
    }

    /**
     * @return the pk_plantio
     */
    public int getPk_plantio() {
        return pk_plantio;
    }

    /**
     * @param pk_plantio the pk_plantio to set
     */
    public void setPk_plantio(int pk_plantio) {
        this.pk_plantio = pk_plantio;
    }

    /**
     * @return the fk_proprietario
     */
    public int getFk_proprietario() {
        return fk_proprietario;
    }

    /**
     * @param fk_proprietario the fk_proprietario to set
     */
    public void setFk_proprietario(int fk_proprietario) {
        this.fk_proprietario = fk_proprietario;
    }

    /**
     * @return the fk_terra
     */
    public int getFk_terra() {
        return fk_terra;
    }

    /**
     * @param fk_terra the fk_terra to set
     */
    public void setFk_terra(int fk_terra) {
        this.fk_terra = fk_terra;
    }

    /**
     * @return the fk_fertilizante
     */
    public int getFk_fertilizante() {
        return fk_fertilizante;
    }

    /**
     * @param fk_fertilizante the fk_fertilizante to set
     */
    public void setFk_fertilizante(int fk_fertilizante) {
        this.fk_fertilizante = fk_fertilizante;
    }

    /**
     * @return the nomeSemente
     */
    public String getNomeSemente() {
        return nomeSemente;
    }

    /**
     * @param nomeSemente the nomeSemente to set
     */
    public void setNomeSemente(String nomeSemente) {
        this.nomeSemente = nomeSemente;
    }

    /**
     * @return the profundidadePlantada
     */
    public String getProfundidadePlantada() {
        return profundidadePlantada;
    }

    /**
     * @param profundidadePlantada the profundidadePlantada to set
     */
    public void setProfundidadePlantada(String profundidadePlantada) {
        this.profundidadePlantada = profundidadePlantada;
    }

}
