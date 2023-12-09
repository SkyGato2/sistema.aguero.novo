/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.UsuariosEma;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Melany
 */
public class UsuariosControle extends AbstractTableModel {
    private List lista;
    
    public void setList(List lista){
        this.lista = lista;
        this.fireTableDataChanged();
    }
    public UsuariosEma getBean (int row){
        return (UsuariosEma) lista.get(row);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UsuariosEma usuarios = (UsuariosEma) lista.get(rowIndex);
        if (columnIndex == 0){
            return usuarios.getIdUsuarioEma();
        }
        if (columnIndex == 1){
            return usuarios.getNomeUsuarioEma();
        }
        if (columnIndex == 2){
            return usuarios.getNomeCompletoEma();
        }
        if (columnIndex == 3){
            return usuarios.getEmailEma();
        }
        
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        if (column == 0){
            return "ID";
        }
        if (column == 1){
            return "NOME";
        }
        if (column == 2){
            return "NOME COMPLETO";
        }
        if (column == 3){
            return "EMAIL";
        }
        
        return "";  
    }

}
