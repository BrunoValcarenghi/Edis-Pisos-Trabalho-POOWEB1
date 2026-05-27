package model;

public class Avaliacao {

    private int id;
    private int usuario_id;
    private String texto;
    private String nome;


    public Avaliacao() {

    }

    public Avaliacao(int id, int usuario_id, String texto) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.texto = texto;
    }

    public Avaliacao(int usuario_id, String texto) {
        this.usuario_id = usuario_id;
        this.texto = texto;
    }

    public Avaliacao(int id, int usuario_id, String texto, String nome) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.texto = texto;
    }

    public Avaliacao(int usuario_id, String texto, String nome) {
        this.usuario_id = usuario_id;
        this.texto = texto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
