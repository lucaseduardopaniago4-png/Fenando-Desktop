package model;

import java.sql.Date;

public class Proprietario {

    private int pk_proprietario;
    private String cnpj;
    private String escrituraEstadual;
    private String estadoCivil;
    private String sexo;
    private int idadeProprietario;
    private String nomeProprietario;

    public Proprietario(int pk_proprietario, String cnpj, String escrituraEstadual, String estadoCivil, String sexo, int idadeProprietario, String nomeProprietario) {
        this.pk_proprietario = pk_proprietario;
        this.cnpj = cnpj;
        this.escrituraEstadual = escrituraEstadual;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.idadeProprietario = idadeProprietario;
        this.nomeProprietario = nomeProprietario;
    }

    public Proprietario() {
    }

    /**
     * @return the pk_proprietario
     */
    public int getPk_proprietario() {
        return pk_proprietario;
    }

    /**
     * @param pk_proprietario the pk_proprietario to set
     */
    public void setPk_proprietario(int pk_proprietario) {
        this.pk_proprietario = pk_proprietario;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the escrituraEstadual
     */
    public String getEscrituraEstadual() {
        return escrituraEstadual;
    }

    /**
     * @param escrituraEstadual the escrituraEstadual to set
     */
    public void setEscrituraEstadual(String escrituraEstadual) {
        this.escrituraEstadual = escrituraEstadual;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the idadeProprietario
     */
    public int getIdadeProprietario() {
        return idadeProprietario;
    }

    /**
     * @param idadeProprietario the idadeProprietario to set
     */
    public void setIdadeProprietario(int idadeProprietario) {
        this.idadeProprietario = idadeProprietario;
    }

    /**
     * @return the nomeProprietario
     */
    public String getNomeProprietario() {
        return nomeProprietario;
    }

    /**
     * @param nomeProprietario the nomeProprietario to set
     */
    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }     
}
