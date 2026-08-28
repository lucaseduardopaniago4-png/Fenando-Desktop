package model;

import java.sql.Date;

public class Areas {

    private int pk_terra;
    private int fk_proprietario;
    private String sementePlantada;
    private Date dataPlantada;
    private Date dataColheita;
    private String qualidadeSolo;
    private Double quantidadeHectare;
    private Double producaoHectare;

    public Areas() {
    }

    public Areas(int pk_terra, int fk_proprietario, String sementePlantada, Date dataPlantada, Date dataColheita, String qualidadeSolo, Double quantidadeHectare, Double producaoHectare) {
        this.pk_terra = pk_terra;
        this.fk_proprietario = fk_proprietario;
        this.sementePlantada = sementePlantada;
        this.dataPlantada = dataPlantada;
        this.dataColheita = dataColheita;
        this.qualidadeSolo = qualidadeSolo;
        this.quantidadeHectare = quantidadeHectare;
        this.producaoHectare = producaoHectare;
    }

    /**
     * @return the pk_terra
     */
    public int getPk_terra() {
        return pk_terra;
    }

    /**
     * @param pk_terra the pk_terra to set
     */
    public void setPk_terra(int pk_terra) {
        this.pk_terra = pk_terra;
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
     * @return the sementePlantada
     */
    public String getSementePlantada() {
        return sementePlantada;
    }

    /**
     * @param sementePlantada the sementePlantada to set
     */
    public void setSementePlantada(String sementePlantada) {
        this.sementePlantada = sementePlantada;
    }

    /**
     * @return the dataPlantada
     */
    public Date getDataPlantada() {
        return dataPlantada;
    }

    /**
     * @param dataPlantada the dataPlantada to set
     */
    public void setDataPlantada(Date dataPlantada) {
        this.dataPlantada = dataPlantada;
    }

    /**
     * @return the dataColheita
     */
    public Date getDataColheita() {
        return dataColheita;
    }

    /**
     * @param dataColheita the dataColheita to set
     */
    public void setDataColheita(Date dataColheita) {
        this.dataColheita = dataColheita;
    }

    /**
     * @return the qualidadeSolo
     */
    public String getQualidadeSolo() {
        return qualidadeSolo;
    }

    /**
     * @param qualidadeSolo the qualidadeSolo to set
     */
    public void setQualidadeSolo(String qualidadeSolo) {
        this.qualidadeSolo = qualidadeSolo;
    }

    /**
     * @return the quantidadeHectare
     */
    public Double getQuantidadeHectare() {
        return quantidadeHectare;
    }

    /**
     * @param quantidadeHectare the quantidadeHectare to set
     */
    public void setQuantidadeHectare(Double quantidadeHectare) {
        this.quantidadeHectare = quantidadeHectare;
    }

    /**
     * @return the producaoHectare
     */
    public Double getProducaoHectare() {
        return producaoHectare;
    }

    /**
     * @param producaoHectare the producaoHectare to set
     */
    public void setProducaoHectare(Double producaoHectare) {
        this.producaoHectare = producaoHectare;
    }
}
