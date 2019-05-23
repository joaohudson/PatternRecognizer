/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr.logic;

/**
 *
 * @author João Hudson
 */
public class PatternRecognizer {
    
    private final Pattern pattern;
    
    /**
     * Cria um Reconhecedor de padrões para reconhecer
     * cadeias do padrão especificado.
     * 
     * @param pattern O padrão a ser reconhecido. Não deve ser null.
     */
    public PatternRecognizer(Pattern pattern)
    {
        this.pattern = pattern;
        
        if(pattern == null)
            throw new IllegalArgumentException("Padrão inválido!");
    }
    
    /**
     * Analisa a cadeia verificando se atende ao padrão
     * deste reconhecedor.
     * 
     * @param input A cadeia a ser analisada.
     * @return True se atende ao padrão, false
     * do contrário.
     */
    public boolean analyze(String input)
    {
        switch(pattern)
        {
            case CPF:
                return analizeCPF(input);
            case EMAIL:
                return analizeEmail(input);
            case PHONE:
                return analizePhone(input);
            case URL:
                return analizeURL(input);
            default: 
                return false;
        }
    }
    
    /**
     * Verifica se a cadeia atende ao padrão
     * de CPF.
     * 
     * @param input A cadeia a ser analisada.
     * @return True se é um CPF, false do 
     * contrário.
     */
    private boolean analizeCPF(String input)
    {   
        return input.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d\\d");
    }
    
    /**
     * Verifica se a cadeia atende ao padrão
     * de Telefone.
     * 
     * @param input A cadeia a ser analisada.
     * @return True se é um Telefone, false do 
     * contrário.
     */
    private boolean analizePhone(String input)
    {
        return input.matches("\\d{4,5}-\\d{4}");
    }
    
    /**
     * Verifica se a cadeia atende ao padrão
     * de Email.
     * 
     * @param input A cadeia a ser analisada.
     * @return True se é um Email, false do 
     * contrário.
     */
    private boolean analizeEmail(String input)
    {
        return input.matches("(\\w+@\\w+\\.com)|(\\w+@\\w+\\.org)|(\\w+@\\w+\\.br)");
    }
    
    /**
     * Verifica se a cadeia atende ao padrão
     * de URL.
     * 
     * @param input A cadeia a ser analisada.
     * @return True se é uma URL, false do 
     * contrário.
     */
    private boolean analizeURL(String input)
    {
        return input.matches("(www\\.\\w+\\.com)|(www\\.\\w+\\.org)|(www\\.\\w+\\.br)");
    }
}
