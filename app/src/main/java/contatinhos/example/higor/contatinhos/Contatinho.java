package contatinhos.example.higor.contatinhos;

public class Contatinho {

    private int id;
    private String nome;
    private String telefone;
    private String infos;

    public Contatinho(int id, String nome, String telefone, String infos) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.infos = infos;
    }

    public Contatinho(String nome, String telefone, String infos) {
        this.nome = nome;
        this.telefone = telefone;
        this.infos = infos;
    }

    public Contatinho() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }
}
