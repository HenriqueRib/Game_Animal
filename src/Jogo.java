import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
// 33 min

public class Jogo {
    
    private final Scanner scanner = new Scanner (System.in); 
    
    private final ListIterator<Animal> animais;
    
    private Jogo(ListIterator<Animal> animais) {
        this.animais = animais;
        
    }
    public static void main (String[] args) throws InterruptedException{
//        Painel painel = new Painel();;
//        painel.setVisible(true);
//        Interface grafica

        Jogo jogo = novo();
        jogo.iniciar();
    
    }
    
    public static Jogo novo(){
        
        List<Animal> animais = new ArrayList();
        animais.add(new Animal("Golfinho", "sabe nadar"));
        animais.add(new Animal("Macaco", "come banana"));
        return new Jogo(animais.listIterator());
    }
    
     private void iniciar() {
         resetarAnimais();
        System.out.println("Pense em um animal");
        
        try {
            Thread.sleep(2000);
        } catch (Exception ex){
         
     }
        perguntarCaracteristica();
        
//        novo.animais.forEachRemaining(System.out::println); // teste como estava funcionando
//        System.out.println(novo.animais);
    }

    private void perguntarCaracteristica() {
        if(animais.hasNext()){
            Animal animal = animais.next();
            String resposta = perguntar("O animal que voce pensou " + animal.getCaracteristica() + "?" );
            if("Sim".equals(resposta) || "S".equals(resposta) || "sim".equals(resposta)){
                tentarAdivinhar(animal);
            }else{
                perguntarCaracteristica();
            }
        }else {
            desistir();
        }
        
    }
    
    private String perguntar(String pergunta){ // Metodo hile que captura todos os caracteres da linha do terminal
        System.out.println(pergunta);
        String resposta = scanner.nextLine();
        while ("".equals(resposta)){ 
        resposta = scanner.nextLine();
        }
        
        return resposta;
    }

    private void tentarAdivinhar(Animal animal) {
       String resposta = perguntar("O animal que você pensou é um " + animal.getNome() + "?");
       if("Sim".equals(resposta) || "S".equals(resposta) || "sim".equals(resposta) || "s".equals(resposta)){
           System.out.println("Sou fera!");
           encerrarJogo();
       } else {
           perguntarCaracteristica();  
       }
    }

    private void encerrarJogo() {
       String resposta = perguntar("Vamos jogar novamente");
       if("Sim".equals(resposta) || "S".equals(resposta) || "sim".equals(resposta) || "s".equals(resposta)){
           iniciar();
       } else {
           System.out.println("Então ta (");
       }
    }

    private void desistir() {
        String nome = perguntar("Desisto. Qual animal você pensou?");
        String caracteristica = perguntar ("Me diga uma caracteristica dele");
        animais.add(new Animal(nome, caracteristica));
        encerrarJogo();
    }

    private void resetarAnimais() {
        while (animais.hasPrevious()){
            animais.previous();
        }
    }
    
}
