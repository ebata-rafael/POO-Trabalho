package kitmenu;

import dados.Repositorio;
import ingressos.TicketEstacionamento;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MenuFaturamento
{
    private final UI terminal;

    public MenuFaturamento()
    {
        this.terminal = UI.getInstance();
    }

    public void realizarFaturamento()
    {
        String dataInicio, dataFim;
        double faturamento;

        dataInicio = terminal.selecionarString("Digite a data de inicio (dia/mes/ano): ");
        dataFim = terminal.selecionarString("Digite a data de fim (dia/mes/ano): ");

        faturamento = calcularFaturamento(dataInicio, dataFim);
        terminal.exibir("O faturamento no periodo selecionado foi de " + faturamento);
    }

    private double calcularFaturamento(String dataInicioString, String dataFimString)
    {
        ArrayList<TicketEstacionamento> tickets = Repositorio.getInstance().getTickets();
        double soma = 0.0;
        LocalDate dataInicio = LocalDate.parse(dataInicioString);
        LocalDate dataFim = LocalDate.parse(dataFimString);

        for(TicketEstacionamento ticket : tickets)
        {
            if(dataInicio.isAfter(ticket.getDataInicio().toLocalDate()) && (ticket.getDataFim() != null && dataFim.isBefore(ticket.getDataFim().toLocalDate())))
            {
                soma += ticket.getTotalPagar();
            }
        }
        return soma;
    }

}
