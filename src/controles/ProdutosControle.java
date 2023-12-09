/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.ProdutosEma;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Melany
 */
public class ProdutosControle extends AbstractTableModel {
    private List<ProdutosEma> lista;
    
    public void setList(List<ProdutosEma> lista){
        this.lista = lista;
        this.fireTableDataChanged();
    }
    
    public ProdutosEma getBean(int row){
        return lista.get(row);
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 7; // Correspondente ao número de campos na sua classe ProdutosEma
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProdutosEma cliente = lista.get(rowIndex);
       if (columnIndex == 0){
            return cliente.getIdProdutoEma();
        }
        if (columnIndex == 1){
            return cliente.getNomeProdutoEma();
        }
        if (columnIndex == 2){
            return cliente.getDescricaoProdutoEma();
        }
        if (columnIndex == 3){
            return cliente.getPrecoVendaEma();
        }
        if (columnIndex == 4){
            return cliente.getQuantidadeEstoqueEma();
        }
        if (columnIndex == 5){
            return cliente.getCategoriaEma();
        }
        if (columnIndex == 6){
            return cliente.getFornecedorEma();
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
            return "DESCRIÇÃO";
        }
        if (column == 3){
            return "PREÇO";
        }
        if (column == 4){
            return "QUANTIDADE";
        }
        if (column == 5){
            return "CATEGORIA";
        }
        if (column == 6){
            return "FORNECEDOR";
        }
        return "";
    }
}
