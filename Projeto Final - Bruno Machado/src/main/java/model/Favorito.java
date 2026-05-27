package model;

public class Favorito {

    private int id;
    private int usuario_id;
    private int produto_id;
    private String marca;
    private String modelo;

    public Favorito(int produto_id, int usuario_id) {
        this.produto_id = produto_id;
        this.usuario_id = usuario_id;
    }

    public Favorito(int usuario_id, int produto_id, String marca, String modelo) {
        this.usuario_id = usuario_id;
        this.produto_id = produto_id;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Favorito() {
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
