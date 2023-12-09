/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.FuncionariosEma;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author eduar
 */
    public class FuncionariosControle extends AbstractTableModel {
    private List<FuncionariosEma> lista;
    
    public void setList(List<FuncionariosEma> lista){
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public FuncionariosEma getBean(int row){
        return lista.get(row);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6; // Correspondente ao número de campos na sua classe FuncionariosEma
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FuncionariosEma cliente = lista.get(rowIndex);
       if (columnIndex == 0){
            return cliente.getStatusEma();
        }
        if (columnIndex == 1){
            return cliente.getNomeCompletoEma();
        }
        if (columnIndex == 2){
            return cliente.getEnderecoEma();
        }
        if (columnIndex == 3){
            return cliente.getCidadeEma();
        }
        if (columnIndex == 4){
            return cliente.getGeneroEma();
        }
        if (columnIndex == 5){
            return cliente.getTelefoneEma();
        }
        
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        if (column == 0){
            return "Status";
        }
        if (column == 1){
            return "NOME";
        }
        if (column == 2){
            return "ENDEREÇO";
        }
        if (column == 3){
            return "CIDADE";
        }
        if (column == 4){
            return "GENERO";
        }
        if (column == 5){
            return "TELEFONE";
        }
   
        return "";
    }
}
