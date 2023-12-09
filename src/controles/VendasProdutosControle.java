/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import bean.VendasProdutoEma;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Melany
 */
public class VendasProdutosControle extends AbstractTableModel {

    private List<VendasProdutoEma> lista;

    public void setList(List<VendasProdutoEma> lista) {
        this.lista = lista;
        this.fireTableDataChanged();
    }

    public VendasProdutoEma getBean(int row) {
        return lista.get(row);
    }

    public void addBean(VendasProdutoEma vendasProdutosEma) {
        lista.add(vendasProdutosEma);
        this.fireTableDataChanged();
    }

    public void removeBean(int index) {
        lista.remove(index);
        this.fireTableDataChanged();
    }

    public void updateBean(int index, VendasProdutoEma VendasProdutoEma) {
        lista.set(index, VendasProdutoEma);
        this.fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return lista != null ? lista.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VendasProdutoEma vendasProdutos = lista.get(rowIndex);
        if (columnIndex == 0) {
            return vendasProdutos.getProdutosEma();
        }
        if (columnIndex == 1) {
            return vendasProdutos.getPrecoUnitarioEma();
        }
        if (columnIndex == 2) {
            return vendasProdutos.getQuantidadeVendidaEma();
        }
        if (columnIndex == 3){
            return vendasProdutos.getPrecoUnitarioEma() * vendasProdutos.getQuantidadeVendidaEma();
        }
        
        
        
        return "";
    }
    
    

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Produto";
        }
        if (column == 1) {
            return "Preço unitário";
        }
        if (column == 2) {
            return "Quantidade vendida";
        }
        if (column == 3) {
            return "Total";
        }
        return "";
    }
}
