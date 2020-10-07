public class Animal {
    
    private final String nome;
    private final String caracteristica;
    
    public Animal(String nome, String caracteristica) {
        this.nome = nome;
        this.caracteristica = caracteristica;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getCaracteristica(){
        return caracteristica;
    }
}

