package tarifacao;

import enums.DiaDaSemana;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;


public class TarifaEstacionaBem
{
    private LocalDateTime dataInicio;
    private double valorPrimeiraHora;
    private double valorHoraSubsequente;
    private DiaDaSemana diaDaSemana;

    /*
    O modificador 'static' foi utilizado para o objeto formatadorData porque, embora seja acessível a todos os objetos da
    classe, não há necessidade de cada um ter seu próprio formatador. Isso se deve ao fato de que o formato é padrão e
    um único formatador é capaz de realizar o que é necessário.
     */
    public static DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public TarifaEstacionaBem() {
    }

    public TarifaEstacionaBem (TabelaPrecos[] valorHoras)
    {
        dataInicio = LocalDateTime.now();
        valorPrimeiraHora = valorHoras[DiaDaSemana.valueOf(diaDaSemanaString(dataInicio)).getValorOpcao()].getPrimeiraHora();
        valorHoraSubsequente = valorHoras[DiaDaSemana.valueOf(diaDaSemanaString(dataInicio)).getValorOpcao()].getHoraSubsequente();
        diaDaSemana = DiaDaSemana.valueOf(diaDaSemanaString(dataInicio));
    }

    public TarifaEstacionaBem(double valorPrimeiraHora, double valorHoraSubsequente, DiaDaSemana diaDaSemana) {
        this.dataInicio = LocalDateTime.now();
        this.valorPrimeiraHora = valorPrimeiraHora;
        this.valorHoraSubsequente = valorHoraSubsequente;
        this.diaDaSemana = diaDaSemana;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public double getValorPrimeiraHora() {
        return valorPrimeiraHora;
    }

    public double getValorHoraSubsequente() {
        return valorHoraSubsequente;
    }

    public DiaDaSemana getDiaDaSemana() {
        return diaDaSemana;
    }

    public String diaDaSemanaString(LocalDateTime data){

        String dia = data.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault()).toUpperCase();
        dia = dia.replace("-FEIRA", "");
        return dia;
    }

    public String toString()
    {
        return "\nData inicio: " + dataInicio.format(formatadorData) +
                "\nDia: " + diaDaSemana.toString() +
                "\nValor 1ºhora: " + valorPrimeiraHora +
                "\nValor após 1ºhora: " + valorHoraSubsequente;
    }
}
