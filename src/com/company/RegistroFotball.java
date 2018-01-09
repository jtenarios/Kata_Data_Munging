package com.company;

public class RegistroFotball {

    private String team;
    private int favor;
    private int contra;
    private int diferencia;

    public RegistroFotball() { }

    public RegistroFotball(String team, int favor, int contra) {
        this.team = team;
        this.favor = favor;
        this.contra = contra;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getFavor() {
        return favor;
    }

    public void setFavor(int favor) {
        this.favor = favor;
    }

    public int getContra() {
        return contra;
    }

    public void setContra(int contra) {
        this.contra = contra;
    }

    public int getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(int diferencia) {
        this.diferencia = diferencia;
    }


}
