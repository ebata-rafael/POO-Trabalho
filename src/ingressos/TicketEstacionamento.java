package ingressos;

import automovel.Veiculo;
import cliente.estacionabem.Cliente;
import modelagem.Vaga;
import tarifacao.TarifaEstacionamento;
import utilitarios.DataUtil;

import java.time.LocalDateTime;

public abstract class TicketEstacionamento
{
    private Cliente cliente;
    private Vaga vaga;
    private Veiculo veiculo;
    private TarifaEstacionamento tarifa;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private double totalPagar;

    public TicketEstacionamento(Cliente cliente, Vaga vaga, Veiculo veiculo, TarifaEstacionamento tarifa)
    {
        this.cliente = cliente;
        this.vaga = vaga;
        this.veiculo = veiculo;
        this.tarifa = tarifa;
        this.dataInicio = LocalDateTime.now().plusHours(10);
        this.dataFim = null;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public Vaga getVaga() {
        return vaga;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public TarifaEstacionamento getTarifa() {
        return tarifa;
    }
    public LocalDateTime getDataInicio() {
        return dataInicio;
    }
    public LocalDateTime getDataFim() {
        return dataFim;
    }
    public double getTotalPagar() {return totalPagar;}

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public void setTotalPagar (double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public abstract void encerrarTicket();

    public abstract double calcularTotalPagar();

    public String toString() {
        return "\nCliente: " + cliente +
                "\nVaga: " + vaga +
                "\nVeiculo: " + veiculo +
                "\nTarifa: " + tarifa +
                "\nData inicio: " + DataUtil.formatarData(dataInicio) +
                "\nData fim: " + DataUtil.formatarData(dataFim) +
                "\nTotal pagar: " + totalPagar;
    }
}