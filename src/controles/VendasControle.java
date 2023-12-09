/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.VendasEma;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Melany
 */
public class VendasControle extends AbstractTableModel {

    private List<VendasEma> lista;

    public void setList(List<VendasEma> lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    public VendasEma getBean(int row) {
        return lista.get(row);
    }

    @Override
    public int getRowCount() {
        return lista != null ? lista.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VendasEma cliente = lista.get(rowIndex);
        if (columnIndex == 0) {
            return cliente.getIdVendaEma();
        }
        if (columnIndex == 1) {
            return cliente.getFkClienteEma();
        }
        if (columnIndex == 2) {
            return cliente.getFkFuncionarioEma();
        }
        if (columnIndex == 3) {
            return cliente.getStatusEntregaEma();
        }
        if (columnIndex == 4) {
            return cliente.getMetodoPagamentoEma();
        }
        if (columnIndex == 5) {
            return cliente.getTotalVendaEma();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        }
        if (column == 1) {
            return "Cliente";
        }
        if (column == 2) {
            return "Funcionario";
        }
        if (column == 3) {
            return "Status";
        }
        if (column == 4) {
            return "Metodo";
        }
        if (column == 5) {
            return "Total";
        }
        return "";
    }
}
