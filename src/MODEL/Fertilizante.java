package model;

import java.sql.Date;

public class Fertilizante {

    private int pk_fertilizante;
    private int fk_proprietario;
    private int fk_terra;
    private String nomeFertilizante;
    private String tipoFertilizante;
    private Date dataAplicacao;
    private Double quantidadeAplicada;

    public Fertilizante() {
    }

    public Fertilizante(int pk_fertilizante, int fk_proprietario, int fk_terra, String nomeFertilizante, String tipoFertilizante, Date dataAplicacao, Double quantidadeAplicada) {
        this.pk_fertilizante = pk_fertilizante;
        this.fk_proprietario = fk_proprietario;
        this.fk_terra = fk_terra;
        this.nomeFertilizante = nomeFertilizante;
        this.tipoFertilizante = tipoFertilizante;
        this.dataAplicacao = dataAplicacao;
        this.quantidadeAplicada = quantidadeAplicada;
    }

    /**
     * @return the pk_fertilizante
     */
    public int getPk_fertilizante() {
        return pk_fertilizante;
    }

    /**
     * @param pk_fertilizante the pk_fertilizante to set
     */
    public void setPk_fertilizante(int pk_fertilizante) {
        this.pk_fertilizante = pk_fertilizante;
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
     * @return the nomeFertilizante
     */
    public String getNomeFertilizante() {
        return nomeFertilizante;
    }

    /**
     * @param nomeFertilizante the nomeFertilizante to set
     */
    public void setNomeFertilizante(String nomeFertilizante) {
        this.nomeFertilizante = nomeFertilizante;
    }

    /**
     * @return the tipoFertilizante
     */
    public String getTipoFertilizante() {
        return tipoFertilizante;
    }

    /**
     * @param tipoFertilizante the tipoFertilizante to set
     */
    public void setTipoFertilizante(String tipoFertilizante) {
        this.tipoFertilizante = tipoFertilizante;
    }

    /**
     * @return the dataAplicacao
     */
    public Date getDataAplicacao() {
        return dataAplicacao;
    }

    /**
     * @param dataAplicacao the dataAplicacao to set
     */
    public void setDataAplicacao(Date dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    /**
     * @return the quantidadeAplicada
     */
    public Double getQuantidadeAplicada() {
        return quantidadeAplicada;
    }

    /**
     * @param quantidadeAplicada the quantidadeAplicada to set
     */
    public void setQuantidadeAplicada(Double quantidadeAplicada) {
        this.quantidadeAplicada = quantidadeAplicada;
    }

}
