package src;

public class Main {
    public static void main(String[] args) {
        for(Contato c : ContatoDAO.getContatos()){
            System.out.println("Nome: " + c.getNome());
        }
    }
}
