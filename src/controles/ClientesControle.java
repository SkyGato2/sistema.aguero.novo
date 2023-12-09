/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.ClientesEma;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Melany
 */
public class ClientesControle extends AbstractTableModel {

    private List<ClientesEma> lista;

    public void setList(List<ClientesEma> lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    public ClientesEma getBean(int row) {
        return lista.get(row);
    }

    @Override
    public int getRowCount() {
        return lista != null ? lista.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ClientesEma cliente = lista.get(rowIndex);
        if (columnIndex == 0) {
            return cliente.getIdClienteEma();
        }
        if (columnIndex == 1) {
            return cliente.getNomeCompletoEma();
        }
        if (columnIndex == 2) {
            return cliente.getCpfEma();
        }
        if (columnIndex == 3) {
            return cliente.getRgEma();
        }
        if (columnIndex == 4) {
            return cliente.getGeneroEma();
        }
        if (columnIndex == 5) {
            return cliente.getTelefoneEma();
        }
        if (columnIndex == 6) {
            return cliente.getEnderecoEma();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "ID";
        }
        if (column == 1) {
            return "NOME";
        }
        if (column == 2) {
            return "CPF";
        }
        if (column == 3) {
            return "RG";
        }
        if (column == 4) {
            return "GENERO";
        }
        if (column == 5) {
            return "TELEFONE";
        }
        if (column == 6) {
            return "ENDERECO";
        }
        return "";
    }
}
