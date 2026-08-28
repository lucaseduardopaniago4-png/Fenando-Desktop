package util;

/**
 * Item genérico usado para popular JComboBox de chaves estrangeiras
 * (proprietário, área, fertilizante), guardando o id real e exibindo
 * uma descrição amigável.
 */
public class ComboItem {

    private final int id;
    private final String descricao;

    public ComboItem(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
