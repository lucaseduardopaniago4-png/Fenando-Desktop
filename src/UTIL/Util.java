package util;

import java.awt.Component;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Funções utilitárias reaproveitadas por todas as telas (VIEW) do sistema:
 * mensagens padronizadas, limpeza de formulário e conversão de campos de
 * texto para os tipos usados pelos Models (double, int, data).
 */
public class Util {

    private static final SimpleDateFormat FORMATO_DATA = new SimpleDateFormat("dd/MM/yyyy");

    static {
        FORMATO_DATA.setLenient(false);
    }

    private Util() {
    }

    public static void exibirErro(Component pai, String mensagem) {
        JOptionPane.showMessageDialog(pai, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void exibirInfo(Component pai, String mensagem) {
        JOptionPane.showMessageDialog(pai, mensagem, "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirmar(Component pai, String mensagem) {
        int opcao = JOptionPane.showConfirmDialog(pai, mensagem, "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return opcao == JOptionPane.YES_OPTION;
    }

    public static void limparCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }

    /**
     * Converte texto (aceita vírgula ou ponto como separador decimal) para
     * double, exigindo valor maior que zero.
     */
    public static double parseDoublePositivo(String texto, String nomeCampo) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(nomeCampo + " é obrigatório.");
        }
        try {
            double valor = Double.parseDouble(texto.trim().replace(",", "."));
            if (valor <= 0) {
                throw new IllegalArgumentException(nomeCampo + " deve ser maior que zero.");
            }
            return valor;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(nomeCampo + " deve ser um número válido.");
        }
    }

    public static int parseInteiroPositivo(String texto, String nomeCampo) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(nomeCampo + " é obrigatório.");
        }
        try {
            int valor = Integer.parseInt(texto.trim());
            if (valor <= 0) {
                throw new IllegalArgumentException(nomeCampo + " deve ser maior que zero.");
            }
            return valor;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(nomeCampo + " deve ser um número inteiro válido.");
        }
    }

    /**
     * Converte texto no formato dd/MM/yyyy para java.sql.Date.
     */
    public static Date parseData(String texto, String nomeCampo) {
        if (texto == null || texto.isBlank()) {
            throw new IllegalArgumentException(nomeCampo + " é obrigatória.");
        }
        try {
            java.util.Date data = FORMATO_DATA.parse(texto.trim());
            return new Date(data.getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(nomeCampo + " deve estar no formato dd/mm/aaaa.");
        }
    }

    public static String formatarData(Date data) {
        return data == null ? "" : FORMATO_DATA.format(data);
    }
}
