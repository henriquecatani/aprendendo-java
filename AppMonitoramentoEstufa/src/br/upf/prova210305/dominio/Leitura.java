package br.upf.prova210305.dominio;

public class Leitura {
    private String horario;
    private Double valorCelsius;

    
    public String getFaixa() {
        if ( valorCelsius < 15)
            return "Baixa";
        else if ( valorCelsius < 30)
            return "Ideal";
        else 
            return "Alta"; 
    }


    //#region Getters e Setters
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Double getValorCelsius() {
        return valorCelsius;
    }

    public void setValorCelsius(Double valorCelsius) throws IllegalArgumentException {
        if ( valorCelsius < 40 && valorCelsius > 0 )
            this.valorCelsius = valorCelsius;
        else throw new IllegalArgumentException("A temperatura deve ser entre 0 e 40 graus Celsius!");
    }
    //#endregion

    //#region Init
    public Leitura(String horario, Double valorCelsius) {
        this.horario = horario;
        this.valorCelsius = valorCelsius;
    }

    public Leitura(Double valorCelsius) {
        this.valorCelsius = valorCelsius;
    }

    public Leitura(String horario) {
        this.horario = horario;
    }
    
    public Leitura() { }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((horario == null) ? 0 : horario.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Leitura other = (Leitura) obj;
        if (horario == null) {
            if (other.horario != null)
                return false;
        } else if (!horario.equals(other.horario))
            return false;
        return true;
    }


    //#endregion

}
